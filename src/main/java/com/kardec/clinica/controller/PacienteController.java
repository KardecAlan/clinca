package com.kardec.clinica.controller;

import com.kardec.clinica.paciente.DadosCadastroPaciente;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @PostMapping
    public void cadastrarPacientes(@RequestBody DadosCadastroPaciente dados){
        System.out.println("dados recebido: " +dados);
    }
}
