package com.kardec.clinica.medico;

import com.kardec.clinica.endereco.DadosEnderecos;

public record DadosCadastrosMedicos(String nome, String email, String crm, Especialidade especialidade, DadosEnderecos endereco) {
}
