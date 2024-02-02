package com.kardec.clinica.domain.medico;

import com.kardec.clinica.domain.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroMedico(
        @NotBlank (message = "Nome é obrigatório")// Anotacao para nao permitir que o campo seja nulo ou vazio
        String nome,
        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Formato do email é inválido") // Anotacao para que o campo seja em formato de email
        String email,
        @NotBlank(message = "Telefone é obrigatório")
        String telefone,
        @NotBlank(message = "CRM é obrigatório")
        @Pattern(regexp = "\\d{4,6}", message = "Formato do CRM é inválido") // Anotacao para que o campo seja digito entre 4 a 6 numeros
        String crm,
        @NotNull (message = "Especialidade é obrigatória")// Nao e NotBlank pq nao e uma string e sim um enum
        Especialidade especialidade,
        @NotNull(message = "Dados do endereço são obrigatórios") // Por nao ser uma String e sim um DTO
        @Valid // Como e um DTO precisa dessa anotacao para validar as anotacoes dentro deste DTO
        DadosEndereco endereco) {
}
