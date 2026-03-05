package dev.santana.nook.validation;

import dev.santana.nook.dto.ReservaDto;
import dev.santana.nook.repository.ReservaRepository;
import org.springframework.stereotype.Component;

@Component
public class ValidarConflitoDeDataEmReserva implements ValidarReserva {

    private final ReservaRepository repository;

    public ValidarConflitoDeDataEmReserva(ReservaRepository repository) {
        this.repository = repository;
    }

    public void validar(ReservaDto dto){
        if (repository.existeConflito(dto.salaId(), dto.dataInicio(), dto.dataFim())){
            throw new RuntimeException("Já existe uma reserva nesse horario");
        }
    }
}
