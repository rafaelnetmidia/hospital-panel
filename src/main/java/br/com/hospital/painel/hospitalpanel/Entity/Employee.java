package br.com.hospital.painel.hospitalpanel.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_seq")
    private Long idEmployee;
    private String name;
    private String cpf;
    private String rg;
    private String telephone;

    @OneToOne
    @JoinColumn(name = "id_position")
    private Position position;

    public Employee() {
    }

}
