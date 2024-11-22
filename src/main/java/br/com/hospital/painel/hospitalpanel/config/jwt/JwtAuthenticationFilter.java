package br.com.hospital.painel.hospitalpanel.config.jwt;

import br.com.hospital.painel.hospitalpanel.controller.AuthController;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;
    private final Set<String> tokenBlacklist = new HashSet<>();

    @Override
    public void doFilterInternal(HttpServletRequest request, @Nullable HttpServletResponse response, @Nullable FilterChain filterChain)
            throws ServletException, IOException {

        String token = request.getHeader("Authorization");

        if (token != null && token.startsWith("Bearer ")) {
            token = token.substring(7);  // Remove "Bearer " do token

            if (isTokenBlacklisted(token)) {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                response.getWriter().write("Token inválido");
                return;
            }

            String username = jwtUtil.extractUsername(token);
            if (username != null && jwtUtil.validateToken(token, username)) {
                // Configura a autenticação no SecurityContext
                SecurityContextHolder.getContext().setAuthentication(
                        new JwtAuthenticationToken(username)
                );
            }
        }

        filterChain.doFilter(request, response);
    }


    public boolean isTokenBlacklisted(String token) {
        return tokenBlacklist.contains(token);
    }

    public void invalidateToken(String token) {
        tokenBlacklist.add(token);
    }
}
