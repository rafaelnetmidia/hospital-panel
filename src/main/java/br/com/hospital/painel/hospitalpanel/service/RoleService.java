package br.com.hospital.painel.hospitalpanel.service;

import br.com.hospital.painel.hospitalpanel.Entity.Role;
import br.com.hospital.painel.hospitalpanel.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;

    public Optional<Role> findById(Long id) {
        return roleRepository.findById(id.intValue());
    }

    public Set<Role> rolesList(List<Long> roles) {

        Set<Role> rolesList = new HashSet<>();

        for (Long roleId : roles) {
            Optional<Role> role = findById(roleId);
            rolesList.add(role.orElseThrow(() -> new RuntimeException("Role not found")));
        }

        return rolesList;
    }

}
