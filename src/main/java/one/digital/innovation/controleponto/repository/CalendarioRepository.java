package one.digital.innovation.controleponto.repository;

import one.digital.innovation.controleponto.model.Calendario;
import one.digital.innovation.controleponto.model.JornadaTrabalho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalendarioRepository extends JpaRepository<Calendario, Long> {
}
