package br.com.hospital.painel.hospitalpanel.controller;

import br.com.hospital.painel.hospitalpanel.service.TesteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
@AllArgsConstructor
public class TesteController {

    private final TesteService testeService;

    @GetMapping("/teste-get")
    public String test(@RequestParam String nome, @RequestParam Integer idade) {

        String returnoIdade = this.testeService.validarIdade(idade);

        return "Olá Mundo! meu nome é " + nome + " e tenho " + idade + " anos. " + returnoIdade;
    }



}
