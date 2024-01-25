package com.kardec.clinica.paciente;

import com.kardec.clinica.endereco.DadosEndereco;

public record DadosCadastroPaciente( String nome, String email, String telefone, String cpf, DadosEndereco endereco) {
}
