package com.kardec.clinica.controller;

import com.kardec.clinica.medico.DadosCadastroMedico;
import com.kardec.clinica.medico.Medico;
import com.kardec.clinica.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    public void cadastrarMedicos(@RequestBody DadosCadastroMedico dados){
        repository.save(new Medico(dados));
    }

}
