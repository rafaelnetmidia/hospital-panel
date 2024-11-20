package br.com.hospital.painel.hospitalpanel.controller;

import br.com.hospital.painel.hospitalpanel.Entity.AppUser;
import br.com.hospital.painel.hospitalpanel.config.jwt.JwtUtil;
import br.com.hospital.painel.hospitalpanel.request.auth.LoginRequestDTO;
import br.com.hospital.painel.hospitalpanel.response.auth.AuthResponseDTO;
import br.com.hospital.painel.hospitalpanel.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class AuthController {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
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
}
