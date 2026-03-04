package dev.santana.nook.model;

import dev.santana.nook.dto.SalaDto;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private Integer capacidade;
    private Boolean ativa;

    public Sala(SalaDto dto) {
        this.capacidade = dto.capacidade();
        this.nome = dto.nome();
        this.ativa = true;
    }
    public Sala() {}

    public void alteraStatusDaSala() {
        this.ativa = !this.ativa;
    }

    public void atualizarSala(SalaDto dto) {
        this.capacidade = dto.capacidade();
        this.nome = dto.nome();
    }
}
