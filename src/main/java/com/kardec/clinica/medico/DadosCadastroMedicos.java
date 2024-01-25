package com.kardec.clinica.medico;

import com.kardec.clinica.endereco.DadosEndereco;

public record DadosCadastroMedicos(String nome, String email, String crm, Especialidade especialidade, DadosEndereco endereco) {
}
