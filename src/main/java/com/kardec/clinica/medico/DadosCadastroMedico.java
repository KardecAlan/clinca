package com.kardec.clinica.medico;

import com.kardec.clinica.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroMedico(
        @NotBlank // Anotacao para nao permitir que o campo seja nulo ou vazio
        String nome,
        @NotBlank
        @Email // Anotacao para que o campo seja em formato de email
        String email,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}") // Anotacao para que o campo seja digito entre 4 a 6 numeros
        String crm,
        @NotNull // Nao e NotBlank pq nao e uma string e sim um enum
        Especialidade especialidade,
        @NotNull // Por nao ser uma String e sim um DTO
        @Valid // Como e um DTO precisa dessa anotacao para validar as anotacoes dentro deste DTO
        DadosEndereco endereco) {
}
