package dev.santana.nook.dto;

import dev.santana.nook.model.StatusReserva;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ReservaDto(
        @NotNull(message = "Campo obrigatório")
        Long salaId,
        @NotNull(message = "Campo obrigatório")
        Long usuarioId,
        @NotNull(message = "Campo obrigatório")
        LocalDateTime dataInicio,
        @NotNull(message = "Campo obrigatório")
        LocalDateTime dataFim) {
}
