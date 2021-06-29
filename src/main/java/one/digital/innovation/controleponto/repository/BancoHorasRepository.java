package one.digital.innovation.controleponto.repository;

import one.digital.innovation.controleponto.model.BancoHoras;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BancoHorasRepository extends JpaRepository<BancoHoras, BancoHoras.BancoHorasId> {
}
