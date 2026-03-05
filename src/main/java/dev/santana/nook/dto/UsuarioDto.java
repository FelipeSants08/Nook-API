package dev.santana.nook.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UsuarioDto(
        @NotBlank(message = "Campo obrigatório")
        String nome,
        @NotBlank(message = "Campo obrigatório")
        @Email(message = "Campo é um email, formato errado")
        String email) {
}
