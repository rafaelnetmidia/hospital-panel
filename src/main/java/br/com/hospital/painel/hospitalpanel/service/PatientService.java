package br.com.hospital.painel.hospitalpanel.service;

import br.com.hospital.painel.hospitalpanel.Entity.Patient;
import br.com.hospital.painel.hospitalpanel.repository.PatientRepository;
import br.com.hospital.painel.hospitalpanel.request.patient.RegisterPatientRequest;
import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

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
                .dtBirth(birthDate)
                .telephone(request.getTelephone())
                .build();

        return patientRepository.save(patient);

    }


    public Patient findPatient(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    public Patient updatePatient(Long id, RegisterPatientRequest request) {
        Patient patient = findPatient(id);

        if(patient != null) {
            patient.setName(request.getName());
            patient.setTelephone(request.getTelephone());
            return patientRepository.save(patient);
        }

        return null;
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }
}
