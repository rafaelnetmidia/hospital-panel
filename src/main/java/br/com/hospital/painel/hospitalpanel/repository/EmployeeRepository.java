package br.com.hospital.painel.hospitalpanel.repository;

import br.com.hospital.painel.hospitalpanel.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
