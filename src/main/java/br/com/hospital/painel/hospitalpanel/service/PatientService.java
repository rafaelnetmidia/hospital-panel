package br.com.hospital.painel.hospitalpanel.service;

import br.com.hospital.painel.hospitalpanel.Entity.Patient;
import br.com.hospital.painel.hospitalpanel.repository.PatientRepository;
import br.com.hospital.painel.hospitalpanel.request.patient.RegisterPatientRequest;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    @SneakyThrows
    public Patient registerPatient(RegisterPatientRequest request) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date birthDate = dateFormat.parse(request.getBirthDate());

        Patient patient = Patient.builder()
                .name(request.getName())
                .cpf(request.getCpf())
                .rg(request.getRg())
                .dtBirth(birthDate)
                .telephone(request.getTelephone())
                .email(request.getEmail())
                .isActive(true)
                .build();
        return patientRepository.save(patient);

    }


    public Patient findPatient(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @SneakyThrows
    public Patient updatePatient(Long id, RegisterPatientRequest request) {

        Patient patient = findPatient(id);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date birthDate = dateFormat.parse(request.getBirthDate());

        if(patient != null) {
            patient.setName(request.getName());
            patient.setCpf(request.getCpf());
            patient.setRg(request.getRg());
            patient.setTelephone(request.getTelephone());
            patient.setEmail(request.getEmail());
            patient.setDtBirth(birthDate);
            patient.setIsActive(request.getIsActive());
            return patientRepository.save(patient);
        }

        return null;
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    public Patient findPatientToDocument(String cpf) {
        return patientRepository.findByCpf(cpf);
    }

    public List<Patient> findPatientAll() {
        return patientRepository.findAll();
    }
}
