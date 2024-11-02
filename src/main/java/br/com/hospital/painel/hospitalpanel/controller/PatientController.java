package br.com.hospital.painel.hospitalpanel.controller;

import br.com.hospital.painel.hospitalpanel.Entity.Patient;
import br.com.hospital.painel.hospitalpanel.request.patient.RegisterPatientRequest;
import br.com.hospital.painel.hospitalpanel.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/patients")
@AllArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping("/register")
    public ResponseEntity<String> registerPatient(@RequestBody RegisterPatientRequest request) {

        Patient patient = patientService.registerPatient(request);

        if(patient != null) {
            return ResponseEntity.created(URI.create("/patients/" + patient.getIdPatient())).build();
        }

        return ResponseEntity.badRequest().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> findPatient(@PathVariable Long id) {
        Patient patient = patientService.findPatient(id);
        return ResponseEntity.ok(patient);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<URI> updatePatient(@PathVariable Long id, @RequestBody RegisterPatientRequest request) {
        Patient patient = patientService.updatePatient(id, request);
        return ResponseEntity.ok(URI.create("/patients/" + patient.getIdPatient()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.ok().build();
    }
}
