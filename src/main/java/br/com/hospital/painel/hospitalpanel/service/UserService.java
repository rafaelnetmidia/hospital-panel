package br.com.hospital.painel.hospitalpanel.service;

import br.com.hospital.painel.hospitalpanel.Entity.AppUser;
import br.com.hospital.painel.hospitalpanel.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public AppUser findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
