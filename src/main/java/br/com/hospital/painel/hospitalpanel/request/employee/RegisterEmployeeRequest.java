package br.com.hospital.painel.hospitalpanel.request.employee;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegisterEmployeeRequest {

    private String name;
    private String email;
    private String cpf;
    private String rg;
    private String telephone;

}
