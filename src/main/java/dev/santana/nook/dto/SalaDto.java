package dev.santana.nook.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SalaDto(@NotBlank(message = "Campo obrigatório")
                      String nome,
                      @NotNull(message = "Campo obrigatório")
                      Integer capacidade){
}