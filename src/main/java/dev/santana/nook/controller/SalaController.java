package dev.santana.nook.controller;

import dev.santana.nook.dto.SalaDto;
import dev.santana.nook.model.Sala;
import dev.santana.nook.service.SalaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sala")
public class SalaController {

    private final SalaService salaService;

    public SalaController(SalaService salaService) {
        this.salaService = salaService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Sala> findAll(){
        return salaService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarSala(@Valid @RequestBody SalaDto dto){
        salaService.criarSala(dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarSalaPorId(@RequestParam Long id){
        salaService.deletarSalaPorId(id);
    }

    @PutMapping("/{id}")
    public void alterarSala(Long id, @Valid @RequestBody SalaDto dto){
        salaService.alterarSalaPorId(id, dto);
    }

    @PatchMapping("/{id}")
    public void alterarStatus(Long id){
        salaService.alteraStatusDaSalaPorId(id);
    }

}
