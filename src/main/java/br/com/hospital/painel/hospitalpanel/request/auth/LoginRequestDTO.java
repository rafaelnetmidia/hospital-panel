package br.com.hospital.painel.hospitalpanel.request.auth;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class LoginRequestDTO {
    private String username;
    private String password;
}