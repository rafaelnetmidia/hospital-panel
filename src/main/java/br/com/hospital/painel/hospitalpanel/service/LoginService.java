package br.com.hospital.painel.hospitalpanel.service;

import br.com.hospital.painel.hospitalpanel.Entity.AppUser;
import br.com.hospital.painel.hospitalpanel.Entity.Employee;
import br.com.hospital.painel.hospitalpanel.Entity.Role;
import br.com.hospital.painel.hospitalpanel.repository.UserRepository;
import br.com.hospital.painel.hospitalpanel.request.auth.LoginRequestDTO;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class LoginService {

    private final UserRepository userRepository;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;

    public AppUser saveLogin(Long idEmployee, String username, String password, List<Integer> roles) {

        Set<Role> roleEntities = roleService.rolesList(roles);

        AppUser appUser = AppUser.builder()
                .employee(new Employee(idEmployee))
                .username(username)
                .password(passwordEncoder.encode(password))
                .roles(roleEntities)
                .isActive(true)
                .build();

        return userRepository.save(appUser);
    }

    public List<AppUser> findAllLogin() {
        return userRepository.findAll();
    }

    public AppUser updateUser(Long idLogin, LoginRequestDTO request) {

        Optional<AppUser> user = findLoginId(idLogin);

        if (user.isPresent()) {
            user.get().setUsername(request.getUsername());
            user.get().setPassword(passwordEncoder.encode(request.getPassword()));
            user.get().setRoles(roleService.rolesList(request.getRoles()));
            user.get().setIsActive(request.getIsActive());
            return userRepository.save(user.get());
        }
        return null;
    }

    public void deleteLogin(Long idLogin) {
        userRepository.deleteById(idLogin);
    }

    public Optional<AppUser> findLoginId(Long idLogin) {
        return userRepository.findById(idLogin);
    }
}
