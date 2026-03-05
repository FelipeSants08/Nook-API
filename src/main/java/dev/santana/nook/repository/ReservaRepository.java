package dev.santana.nook.repository;

import dev.santana.nook.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

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

}
