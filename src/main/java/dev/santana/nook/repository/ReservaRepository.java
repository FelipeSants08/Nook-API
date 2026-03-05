package dev.santana.nook.repository;

import dev.santana.nook.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Long> {

    @Query(
            """
            SELECT COUNT(r) > 0 FROM Reserva r
            WHERE r.sala.id = :salaId
            AND r.status = 'ATIVA'
            AND (:inicio < r.fim AND :fim > r.inicio)
            """
    )
    Boolean existeConflito(Long salaId, LocalDateTime inicio, LocalDateTime fim);

    @Query(
            """
            SELECT r FROM Reserva r
                        WHERE r.sala.id = :salaId
                        AND r.status = 'ATIVA'
                        AND r.inicio BETWEEN :inicio AND :fim
            """
    )
    List<Reserva> pegarReservasPorSalaEPorPeriodo(Long salaId, LocalDateTime inicio, LocalDateTime fim);

}
