package dev.santana.nook.controller;

import dev.santana.nook.dto.ReservaDto;
import dev.santana.nook.model.Reserva;
import dev.santana.nook.service.ReservaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/reserva")
public class ReservaController {

    private final ReservaService service;

    public ReservaController(ReservaService service) {
        this.service = service;
    }

    @PostMapping("/criar")
    @ResponseStatus(HttpStatus.CREATED)
    public void criarReserva(@RequestBody @Valid ReservaDto dto){
        service.criarReserva(dto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Reserva> listarReservas(){
        return service.listarReservas();
    }

    public Reserva pegarReserva(Long id){
        return service.pegarReserva(id);
    }

    @PostMapping("/cancelar/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void criarReserva(@RequestParam Long id){
        service.cancelarReserva(id);
    }

}
