package br.com.hospital.painel.hospitalpanel.controller;

import br.com.hospital.painel.hospitalpanel.Entity.Employee;
import br.com.hospital.painel.hospitalpanel.request.employee.RegisterEmployeeRequest;
import br.com.hospital.painel.hospitalpanel.response.employee.FindEmployeeResponse;
import br.com.hospital.painel.hospitalpanel.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@Controller
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/register")
    public ResponseEntity<String> registerEmployee(@RequestBody RegisterEmployeeRequest request) {

        Employee employee = employeeService.registerEmployee(request);

        if(employee != null) {
            return ResponseEntity.created(URI.create("/employees/" + employee.getIdEmployee())).build();
        }

        return ResponseEntity.badRequest().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<FindEmployeeResponse> findEmployee(@PathVariable Long id) {

        Employee employee = employeeService.findEmployee(id);

        FindEmployeeResponse response = new FindEmployeeResponse();
        response.setIdEmployee(employee.getIdEmployee());
        response.setName(employee.getName());
        response.setCpf(employee.getCpf());
        response.setRg(employee.getRg());
        response.setTelephone(employee.getTelephone());
        response.setIdPosition(employee.getPosition().getIdPosition());
        response.setPosition(employee.getPosition().getFunction());

        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<URI> updateEmployee(@PathVariable Long id, @RequestBody RegisterEmployeeRequest request) {
        Employee employee = employeeService.updateEmployee(id, request);
        return ResponseEntity.ok(URI.create("/employees/" + employee.getIdEmployee()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }

}
