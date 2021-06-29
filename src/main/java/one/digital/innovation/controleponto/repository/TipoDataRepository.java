package one.digital.innovation.controleponto.repository;

import one.digital.innovation.controleponto.model.TipoData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoDataRepository extends JpaRepository<TipoData, Long> {
}
