package com.kardec.clinica.controller;

import com.kardec.clinica.paciente.DadosCadastroPaciente;
import com.kardec.clinica.paciente.Paciente;
import com.kardec.clinica.paciente.PacienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    public void cadastrarPacientes(@RequestBody @Valid DadosCadastroPaciente dados){
        repository.save(new Paciente(dados));
    }
}
