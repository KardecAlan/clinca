package com.kardec.clinica.medico;

import com.kardec.clinica.endereco.DadosEnderecos;

public record DadosCadastroMedicos(String nome, String email, String crm, Especialidade especialidade, DadosEnderecos endereco) {
}
