package dev.santana.nook.dto;

import dev.santana.nook.model.StatusReserva;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ReservaDto(
        @NotNull
        Long salaId,
        @NotNull
        Long usuarioId,
        @NotNull
        LocalDateTime dataInicio,
        @NotNull
        LocalDateTime dataFim) {
}
