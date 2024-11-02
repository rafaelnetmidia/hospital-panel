package br.com.hospital.painel.hospitalpanel.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "patient")
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_seq")
    private Long idPatient;
    @Column(name = "name", length = 50)
    private String name;
    private Date dtBirth;
    @Column(name = "telephone", length = 20)
    private String telephone;

    public Patient() {

    }
}
