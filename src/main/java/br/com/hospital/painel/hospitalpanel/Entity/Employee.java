package br.com.hospital.painel.hospitalpanel.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    @SequenceGenerator(name = "employee_seq", sequenceName = "employee_seq", allocationSize = 1)
    private Long idEmployee;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false, unique = true)
    private String cpf;
    private String rg;
    private String telephone;
    @Column(nullable = false, unique = true)
    private String email;
    @CreationTimestamp
    @Column(updatable = false, nullable = false)
    private LocalDateTime dtCreate;
    @Column(nullable = false)
    private Boolean isActive;

    public Employee() {

    }


    public Employee(Long idEmployee) {
        this.idEmployee = idEmployee;
    }
}
