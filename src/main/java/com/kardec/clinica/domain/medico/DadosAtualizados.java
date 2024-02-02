package com.kardec.clinica.domain.medico;

import com.kardec.clinica.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizados(

        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
