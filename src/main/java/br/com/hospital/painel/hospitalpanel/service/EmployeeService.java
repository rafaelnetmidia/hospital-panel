package br.com.hospital.painel.hospitalpanel.service;

import br.com.hospital.painel.hospitalpanel.Entity.AppUser;
import br.com.hospital.painel.hospitalpanel.Entity.Employee;
import br.com.hospital.painel.hospitalpanel.Entity.Role;
import br.com.hospital.painel.hospitalpanel.repository.EmployeeRepository;
import br.com.hospital.painel.hospitalpanel.request.employee.RegisterEmployeeAndUserRequest;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final UserDetailsServiceImpl userDetailsService;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    @Transactional
    public Employee registerEmployeeAndUser(RegisterEmployeeAndUserRequest request) {

        Employee employeeSaved = getSaveEmployee(request);

        if(request.getUserName() != null && request.getPassword() != null && request.getRoles() != null && !request.getRoles().isEmpty()){
            getSaveUser(request, employeeSaved);
        }

        return employeeSaved;
    }

    private AppUser getSaveUser(RegisterEmployeeAndUserRequest request, Employee employeeSaved) {
        Set<Role> roles = roleService.rolesList(request.getRoles());

        AppUser appUser = AppUser.builder()
                .username(request.getUserName())
                .password(passwordEncoder.encode(request.getPassword()))
                .employee(employeeSaved)
                .roles(roles)
                .isActive(true)
                .build();

        return userDetailsService.createUser(appUser);
    }

    private Employee getSaveEmployee(RegisterEmployeeAndUserRequest request) {
        Employee employee = Employee.builder()
                .name(request.getName())
                .telephone(request.getTelephone())
                .rg(request.getRg())
                .cpf(request.getCpf())
                .email(request.getEmail())
                .isActive(true)
                .build();

        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, RegisterEmployeeAndUserRequest request) {
        return null;
    }

    public void deleteEmployee(Long id) {
    }

    public List<Employee> findAllEmployee() {
        return null;
    }
}
