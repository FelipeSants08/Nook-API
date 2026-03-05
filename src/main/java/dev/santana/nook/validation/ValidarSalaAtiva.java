package dev.santana.nook.validation;

import dev.santana.nook.dto.ReservaDto;
import dev.santana.nook.exception.SalaInativaException;
import dev.santana.nook.model.Sala;
import dev.santana.nook.service.SalaService;
import org.springframework.stereotype.Component;

@Component
public class ValidarSalaAtiva implements ValidarReserva {

    private final SalaService service;

    public ValidarSalaAtiva(SalaService service) {
        this.service = service;
    }

    public void validar(ReservaDto dto){
        Sala sala = service.findSalaPorId(dto.salaId());
        if (!sala.getAtiva()){
            throw new SalaInativaException("Sala inativa!");
        }
    }
}
