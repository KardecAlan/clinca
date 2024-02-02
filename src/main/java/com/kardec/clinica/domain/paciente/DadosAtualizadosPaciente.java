package com.kardec.clinica.domain.paciente;

import com.kardec.clinica.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizadosPaciente(

        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
