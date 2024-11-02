package br.com.hospital.painel.hospitalpanel.service;

import org.springframework.stereotype.Service;

@Service
public class TesteService {

    public String validarIdade(Integer idade) {

        if (idade >= 18) {
            return "Você é maior de idade";
        } else {
            return "Você é menor de idade";
        }
    }
}
