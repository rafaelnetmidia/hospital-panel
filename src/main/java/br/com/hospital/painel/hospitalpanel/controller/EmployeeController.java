package br.com.hospital.painel.hospitalpanel.controller;

import br.com.hospital.painel.hospitalpanel.Entity.Employee;
import br.com.hospital.painel.hospitalpanel.request.employee.RegisterEmployeeAndUserRequest;
import br.com.hospital.painel.hospitalpanel.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Controller
@RequestMapping("/employees")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping("/register")
    public ResponseEntity<String> registerEmployeeAndUser(@RequestBody RegisterEmployeeAndUserRequest request) {

        Employee employee = employeeService.registerEmployeeAndUser(request);

        if(employee != null) {
            return ResponseEntity.created(URI.create("/employees/" + employee.getIdEmployee())).build();
        }

        return ResponseEntity.badRequest().build();

    }

    @GetMapping
    public ResponseEntity<List<Employee>> findAllEmployee() {

        List<Employee> employee = employeeService.findAllEmployee();

        if (employee.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(employee);
    }

    @PutMapping("/{id}")
    public ResponseEntity<URI> updateEmployee(@PathVariable Long id, @RequestBody RegisterEmployeeAndUserRequest request) {

        Employee employee = employeeService.updateEmployee(id, request);

        if(employee == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(URI.create("/employees/" + employee.getIdEmployee()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }

}
