package dev.santana.nook.validation;

import dev.santana.nook.dto.ReservaDto;
import dev.santana.nook.exception.CronologiaException;

public class ValidarCronologiaReserva implements ValidarReserva {

    public void validar(ReservaDto dto) {
        if (dto.dataInicio().isAfter(dto.dataFim()) || dto.dataInicio().isEqual(dto.dataFim())) {
            throw new CronologiaException("A data de início deve ser anterior à data de fim!");
        }
    }
}
