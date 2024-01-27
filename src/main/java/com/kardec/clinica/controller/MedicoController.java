package com.kardec.clinica.controller;

import com.kardec.clinica.medico.DadosCadastroMedico;
import com.kardec.clinica.medico.Medico;
import com.kardec.clinica.medico.MedicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
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
    @Transactional
    public void cadastrarMedicos(@RequestBody @Valid DadosCadastroMedico dados){
        repository.save(new Medico(dados));
    }

}
