package dev.santana.nook.validation;

import dev.santana.nook.dto.ReservaDto;

public class ValidarCronologiaReserva implements ValidarReserva {

    public void validar(ReservaDto dto) {
        if (dto.dataInicio().isAfter(dto.dataFim()) || dto.dataInicio().isEqual(dto.dataFim())) {
            throw new RuntimeException("A data de início deve ser anterior à data de fim!");
        }
    }
}
