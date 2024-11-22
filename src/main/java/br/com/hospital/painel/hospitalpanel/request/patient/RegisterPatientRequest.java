package br.com.hospital.painel.hospitalpanel.request.patient;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegisterPatientRequest {

    private String name;
    private String cpf;
    private String rg;
    private String telephone;
    private String email;
    private String birthDate;
    private Boolean isActive;

}
