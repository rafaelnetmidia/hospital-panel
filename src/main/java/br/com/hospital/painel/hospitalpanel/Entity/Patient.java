package br.com.hospital.painel.hospitalpanel.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_seq")
    private Long idPatient;
    @Column(length = 50)
    private String name;
    @Column(nullable = false, unique = true)
    private String cpf;
    private String rg;
    private Date dtBirth;
    @Column(length = 20)
    private String telephone;
    @Column(unique = true)
    private String email;
    @Column(nullable = false)
    private Boolean isActive;

    public Patient() {

    }
}
