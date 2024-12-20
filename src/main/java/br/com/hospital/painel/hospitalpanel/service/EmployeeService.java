package br.com.hospital.painel.hospitalpanel.service;

import br.com.hospital.painel.hospitalpanel.Entity.Employee;
import br.com.hospital.painel.hospitalpanel.Entity.Position;
import br.com.hospital.painel.hospitalpanel.repository.EmployeeRepository;
import br.com.hospital.painel.hospitalpanel.request.employee.RegisterEmployeeRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee registerEmployee(RegisterEmployeeRequest request) {

        Position position = Position.builder()
                .idPosition(request.getIdPosition())
                .build();

        Employee employee = Employee.builder()
                .name(request.getName())
                .telephone(request.getTelephone())
                .rg(request.getRg())
                .cpf(request.getCpf())
                .position(position)
                .build();

        return employeeRepository.save(employee);
    }

    public Employee findEmployee(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public Employee updateEmployee(Long id, RegisterEmployeeRequest request) {

        Employee employee = findEmployee(id);

        if(employee != null) {

            Position position = Position
                    .builder()
                    .idPosition(request.getIdPosition())
                    .build();

            employee.setName(request.getName());
            employee.setCpf(request.getCpf());
            employee.setRg(request.getRg());
            employee.setTelephone(request.getTelephone());
            employee.setIdEmployee(employee.getIdEmployee());
            employee.setPosition(position);

            return employeeRepository.save(employee);
        }

        return null;
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
