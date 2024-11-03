package br.com.hospital.painel.hospitalpanel.request.patient;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegisterPatientRequest {

    private String name;
    private String birthDate;
    private String telephone;

}
