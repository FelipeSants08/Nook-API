package dev.santana.nook.model;

import dev.santana.nook.dto.ReservaDto;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = false)
    private Sala sala;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private LocalDateTime inicio;

    @Column(nullable = false)
    private LocalDateTime fim;

    @Enumerated(EnumType.STRING)
    private StatusReserva status;

    public Reserva(){
    }

    public Reserva(Sala sala, Usuario usuario, ReservaDto dto){

        this.sala = sala;
        this.usuario = usuario;
        this.inicio = dto.dataInicio();
        this.fim = dto.dataFim();
        this.status = StatusReserva.ATIVA;
    }

    public void cancelarReserva(){
        this.status = StatusReserva.CANCELADA;
    }
}
