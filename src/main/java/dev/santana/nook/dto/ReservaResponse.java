package dev.santana.nook.dto;

import dev.santana.nook.model.Reserva;
import dev.santana.nook.model.Sala;
import dev.santana.nook.model.StatusReserva;

import java.time.LocalDateTime;

public record ReservaResponse(Long id, Sala sala, UsuarioResponse usuario, LocalDateTime inicio, LocalDateTime fim,
                              StatusReserva status) {

    public ReservaResponse(Reserva reserva){
        this(reserva.getId(), reserva.getSala(), new UsuarioResponse(reserva.getUsuario()), reserva.getInicio(), reserva.getFim(), reserva.getStatus());
    }
}
