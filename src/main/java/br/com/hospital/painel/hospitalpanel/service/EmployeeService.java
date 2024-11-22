package br.com.hospital.painel.hospitalpanel.service;

import br.com.hospital.painel.hospitalpanel.Entity.Employee;
import br.com.hospital.painel.hospitalpanel.repository.EmployeeRepository;
import br.com.hospital.painel.hospitalpanel.request.employee.RegisterEmployeeRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee registerEmployee(RegisterEmployeeRequest request) {

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

    public Employee updateEmployee(Long id, RegisterEmployeeRequest request) {

        Employee employee = findIdEmployee(id);

        employee.setName(request.getName());
        employee.setTelephone(request.getTelephone());
        employee.setRg(request.getRg());
        employee.setCpf(request.getCpf());
        employee.setEmail(request.getEmail());

        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> findAllEmployee() {
        return employeeRepository.findAll();
    }

    public Employee findIdEmployee(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }
}
