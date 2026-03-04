package dev.santana.nook.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SalaDto(@NotBlank
                      String nome,
                      @NotNull
                      Integer capacidade){
}