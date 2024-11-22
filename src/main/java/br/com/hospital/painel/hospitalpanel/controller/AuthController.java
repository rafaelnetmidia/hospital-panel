package br.com.hospital.painel.hospitalpanel.controller;

import br.com.hospital.painel.hospitalpanel.Entity.AppUser;
import br.com.hospital.painel.hospitalpanel.config.jwt.JwtAuthenticationFilter;
import br.com.hospital.painel.hospitalpanel.config.jwt.JwtUtil;
import br.com.hospital.painel.hospitalpanel.request.auth.LoginRequestDTO;
import br.com.hospital.painel.hospitalpanel.response.auth.AuthResponseDTO;
import br.com.hospital.painel.hospitalpanel.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @PostMapping("/token")
    public ResponseEntity<?> authenticate(@RequestBody LoginRequestDTO request) {

        String username = request.getUsername();
        String password = request.getPassword();

        AppUser user = userService.findByUsername(username);

        if (user == null || !passwordEncoder.matches(password, user.getPassword()) || !user.getIsActive()) {
            return ResponseEntity.status(401).body("Usuário ou senha incorretos");
        }

        String token = jwtUtil.generateToken(user.getUsername());

        return ResponseEntity.ok(new AuthResponseDTO(token));
    }

    @DeleteMapping("/token")
    public ResponseEntity<?> invalidateToken(@RequestHeader("Authorization") String tokenHeader) {

        if (tokenHeader == null || !tokenHeader.startsWith("Bearer ")) {
            return ResponseEntity.badRequest().body("Token inválido ou ausente");
        }

        String token = tokenHeader.substring(7);
        jwtAuthenticationFilter.invalidateToken(token);

        return ResponseEntity.ok("Token invalidado com sucesso");
    }

}
