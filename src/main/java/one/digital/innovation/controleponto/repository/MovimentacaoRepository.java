package one.digital.innovation.controleponto.repository;

import one.digital.innovation.controleponto.model.Movimentacao;
import one.digital.innovation.controleponto.model.dto.MovimentacaoDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Movimentacao.MovimentacaoId> {
}
