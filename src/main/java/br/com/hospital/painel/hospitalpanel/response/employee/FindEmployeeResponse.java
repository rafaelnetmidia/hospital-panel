package br.com.hospital.painel.hospitalpanel.response.employee;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class FindEmployeeResponse {

    private Long idEmployee;
    private String name;
    private String telephone;
    private String rg;
    private String cpf;
    private Long idPosition;
    private String position;

}
