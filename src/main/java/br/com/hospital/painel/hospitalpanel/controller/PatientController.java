package br.com.hospital.painel.hospitalpanel.controller;

import br.com.hospital.painel.hospitalpanel.Entity.Patient;
import br.com.hospital.painel.hospitalpanel.request.patient.PatientRequest;
import br.com.hospital.painel.hospitalpanel.request.patient.RegisterPatientRequest;
import br.com.hospital.painel.hospitalpanel.service.PatientService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<Patient>> findPatientAll() {

        List<Patient> patient = patientService.findPatientAll();

        if (patient.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(patient);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patient> findPatientToId(@PathVariable Long id) {

        Patient patient = patientService.findPatient(id);

        if (patient == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(patient);
    }


    @PostMapping("/find-patient/document")
    public ResponseEntity<Patient> findPatientToDocument(@RequestBody PatientRequest request) {

       Patient patient = patientService.findPatientToDocument(request.getCpf());

        if(patient == null) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(patient);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<URI> updatePatient(@PathVariable Long id, @RequestBody RegisterPatientRequest request) {

        Patient patient = patientService.updatePatient(id, request);

        if (patient == null) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(URI.create("/patients/" + patient.getIdPatient()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatient(@PathVariable Long id) {
        patientService.deletePatient(id);
        return ResponseEntity.ok().build();
    }
}
