package dev.santana.nook.dto;

import dev.santana.nook.model.Usuario;

public record UsuarioResponse(Long id, String nome) {
    public UsuarioResponse(Usuario usuario){
        this(usuario.getId(), usuario.getNome());
    }
}
