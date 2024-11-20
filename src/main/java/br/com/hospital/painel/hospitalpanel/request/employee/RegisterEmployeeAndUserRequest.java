package br.com.hospital.painel.hospitalpanel.request.employee;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class RegisterEmployeeAndUserRequest {

    private String name;
    private String email;
    private String cpf;
    private String rg;
    private String telephone;
    private String userName;
    private String password;
    private List<Long> roles;

}
