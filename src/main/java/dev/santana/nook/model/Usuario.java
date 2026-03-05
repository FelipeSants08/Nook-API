package dev.santana.nook.model;

import dev.santana.nook.dto.UsuarioDto;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Entity
@Getter
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(unique = true, nullable = false)
    private String email;

    @OneToMany(mappedBy = "usuario", fetch = FetchType.LAZY)
    private List<Reserva> reservas;

    public Usuario(){}

    public Usuario(UsuarioDto dto){
        this.nome = dto.nome();
        this.email = dto.email();
    }

    public void atualizarUsuario(UsuarioDto dto){
        this.nome = dto.nome();
        this.email = dto.email();
    }
}
