package dev.santana.nook.service;

import dev.santana.nook.dto.UsuarioDto;
import dev.santana.nook.dto.UsuarioResponse;
import dev.santana.nook.exception.IdNaoEncontradoException;
import dev.santana.nook.model.Usuario;
import dev.santana.nook.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    public void criarUsuario(UsuarioDto dto){
        Usuario usuario = new Usuario(dto);
        this.repository.save(usuario);
    }

    public void deletarPorId(Long id){
        Usuario usuario = pegarPorId(id);
        repository.delete(usuario);
    }

    public List<UsuarioResponse> listarUsuarios(){
        return repository.findAll()
                .stream()
                .map(UsuarioResponse::new)
                .toList();
    }

    @Transactional
    public void atualizarUsuario(Long id, UsuarioDto dto){
        Usuario usuario = pegarPorId(id);
        usuario.atualizarUsuario(dto);
    }

    public UsuarioResponse pegarPorIdResponse(Long id){
        Usuario usuario = pegarPorId(id);
        return new UsuarioResponse(usuario);
    }

    public Usuario pegarPorId(Long id){
        return repository
                .findById(id)
                .orElseThrow(
                        () -> new IdNaoEncontradoException("Usuário não encontrado!")
                );
    }

}
