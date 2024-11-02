package br.com.hospital.painel.hospitalpanel.repository;

import br.com.hospital.painel.hospitalpanel.Entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
