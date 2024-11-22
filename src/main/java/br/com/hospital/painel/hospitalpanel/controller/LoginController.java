package br.com.hospital.painel.hospitalpanel.controller;

import br.com.hospital.painel.hospitalpanel.Entity.AppUser;
import br.com.hospital.painel.hospitalpanel.Entity.Employee;
import br.com.hospital.painel.hospitalpanel.request.auth.LoginRequestDTO;
import br.com.hospital.painel.hospitalpanel.service.EmployeeService;
import br.com.hospital.painel.hospitalpanel.service.LoginService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/login")
@AllArgsConstructor
public class LoginController {

    private final LoginService loginService;
    private final EmployeeService employeeService;

    @PostMapping("/{idEmployee}")
    public ResponseEntity<?> registerLoginToEmployee(@PathVariable Long idEmployee, @RequestBody LoginRequestDTO request) {

        Employee employee = employeeService.findIdEmployee(idEmployee);

        if (employee == null) {
            return ResponseEntity.status(401).body("Funcionário não localizado");
        }

        AppUser user = loginService.saveLogin(employee.getIdEmployee(), request.getUsername(), request.getPassword(), request.getRoles());

        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<List<AppUser>> findAllLogin() {

        List<AppUser> login = loginService.findAllLogin();

        if (login.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(login);
    }

    @GetMapping("/{idLogin}")
    public ResponseEntity<AppUser> findLoginId(@PathVariable Long idLogin) {

        Optional<AppUser> login = loginService.findLoginId(idLogin);

        if (login.isPresent()) {
            return ResponseEntity.ok(login.get());
        }

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{idLogin}")
    public ResponseEntity<URI> updateLogin(@PathVariable Long idLogin, @RequestBody LoginRequestDTO request) {

        AppUser appUser = loginService.updateUser(idLogin, request);

        if(appUser == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(URI.create("/login/" + appUser.getIdUser()));
    }

    @DeleteMapping("/{idLogin}")
    public ResponseEntity<Void> deleteLogin(@PathVariable Long idLogin) {
        loginService.deleteLogin(idLogin);
        return ResponseEntity.ok().build();
    }

}
