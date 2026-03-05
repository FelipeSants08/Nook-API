package dev.santana.nook.controller;

import dev.santana.nook.dto.UsuarioDto;
import dev.santana.nook.model.Usuario;
import dev.santana.nook.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/usuario")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    private List<Usuario> listar(){
        return service.listarUsuarios();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Usuario pegarPorId(@RequestParam Long id){
        return service.pegarPorId(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void criarUsuario(@Valid @RequestBody UsuarioDto dto){
        service.criarUsuario(dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarPorId(Long id){
        service.deletarPorId(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void alterarUsuario(Long id, @Valid @RequestBody UsuarioDto dto){
        service.atualizarUsuario(id, dto);
    }

}
