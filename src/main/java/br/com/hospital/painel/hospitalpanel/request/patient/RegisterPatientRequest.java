package br.com.hospital.painel.hospitalpanel.request.patient;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterPatientRequest {

    private String name;
    private String birthDate;
    private String telephone;

}
