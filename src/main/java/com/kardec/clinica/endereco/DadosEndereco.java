package com.kardec.clinica.endereco;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosEndereco(
        @NotBlank // Anotacao para que nao possa ser nulo e nem vazio
        String logradouro,
        @NotBlank
        String bairro,
        @NotBlank
        String cidade,
        @NotBlank
        @Pattern(regexp = "\\d{8}") // Anotacao para que o campo seja digito de 8 numeros
        String cep,
        @NotBlank
        String uf,
        String complemento,
        String numero) {
}
