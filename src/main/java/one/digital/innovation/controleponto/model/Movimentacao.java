package one.digital.innovation.controleponto.model;

import lombok.*;
import one.digital.innovation.controleponto.model.dto.MovimentacaoDTO;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Audited
public class Movimentacao {
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public static class MovimentacaoId implements Serializable {
        private Long idMovimento;
        private Long idUsuario;

        public MovimentacaoId(MovimentacaoDTO.MovimentacaoIdDTO movimentacaoIdDTO) {
            this.idMovimento = movimentacaoIdDTO.getIdMovimento();
            this.idUsuario = movimentacaoIdDTO.getIdUsuario();
        }
    }

    @Id
    @EmbeddedId
    private MovimentacaoId id;
    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;
    private BigDecimal periodo;

    @ManyToOne
    private Ocorrencia ocorrencia;
    @ManyToOne
    private Calendario calendario;

    public Movimentacao(MovimentacaoDTO movimentacaoDTO) {
        this.id = new MovimentacaoId(movimentacaoDTO.getId());
        this.dataEntrada = movimentacaoDTO.getDataEntrada();
        this.dataSaida = movimentacaoDTO.getDataSaida();
        this.periodo = movimentacaoDTO.getPeriodo();
        this.ocorrencia = movimentacaoDTO.getOcorrencia();
        this.calendario = movimentacaoDTO.getCalendario();
    }
}
