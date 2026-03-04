package dev.santana.nook.service;

import dev.santana.nook.dto.SalaDto;
import dev.santana.nook.model.Sala;
import dev.santana.nook.repository.SalaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaService {

    private final SalaRepository repository;

    public SalaService(SalaRepository repository) {
        this.repository = repository;
    }

    public List<Sala> findAll() {
        return repository.findAll();
    }

    public void criarSala(SalaDto dto){
        Sala sala = new Sala(dto);
        repository.save(sala);
    }

    public void deletarSalaPorId(Long id){
        Sala sala = findSalaPorId(id);
        repository.delete(sala);
    }

    public Sala findSalaPorId(Long id){
        return repository.findById(id)
                .orElseThrow(
                        () -> new RuntimeException("ID não encontrado!")
                );
    }

    @Transactional
    public void alteraStatusDaSalaPorId(Long id){
        Sala sala = findSalaPorId(id);
        sala.alteraStatusDaSala();
    }

    @Transactional
    public void alterarSalaPorId(Long id, SalaDto dto){
        Sala sala = findSalaPorId(id);
        sala.atualizarSala(dto);
    }
}
