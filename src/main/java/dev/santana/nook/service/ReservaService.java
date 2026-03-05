package dev.santana.nook.service;

import dev.santana.nook.dto.ReservaDto;
import dev.santana.nook.dto.ReservaResponse;
import dev.santana.nook.exception.IdNaoEncontradoException;
import dev.santana.nook.model.Reserva;
import dev.santana.nook.model.Sala;
import dev.santana.nook.model.Usuario;
import dev.santana.nook.repository.ReservaRepository;
import dev.santana.nook.repository.UsuarioRepository;
import dev.santana.nook.validation.ValidarReserva;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservaService {

    private final ReservaRepository repository;
    private final UsuarioService usuarioService;
    private final SalaService salaService;
    private final List<ValidarReserva> validarReservas;

    public ReservaService(ReservaRepository repository, UsuarioService usuarioService, SalaService salaService, List<ValidarReserva> validarReservas) {
        this.repository = repository;
        this.usuarioService = usuarioService;
        this.salaService = salaService;
        this.validarReservas = validarReservas;
    }

    @Transactional
    public void criarReserva(ReservaDto dto){
        //chamar sala
        Sala sala = salaService.findSalaPorId(dto.salaId());
        //chamar usuario
        Usuario usuario = usuarioService.pegarPorId(dto.usuarioId());

        validarReservas.forEach(v -> v.validar(dto));

        Reserva reserva = new Reserva(sala, usuario, dto);
        repository.save(reserva);

    }

    @Transactional
    public void cancelarReserva(Long id){
        Reserva reserva = pegarReserva(id);
        reserva.cancelarReserva();
    }

    public ReservaResponse pegarReservaResponse(Long id){
        Reserva reserva = pegarReserva(id);
        return new ReservaResponse(reserva);
    }

    public Reserva pegarReserva(Long id){
        return repository.findById(id)
                .orElseThrow(() -> new IdNaoEncontradoException("Reserva não encontrada"));
    }

    public List<ReservaResponse> listarReservas(){
        return repository.findAll()
                .stream()
                .map(ReservaResponse::new)
                .toList();
    }

}
