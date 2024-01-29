package com.kardec.clinica.paciente;

import com.kardec.clinica.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizadosPaciente(

        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
