package com.kardec.clinica.medico;

import com.kardec.clinica.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizados(

        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
