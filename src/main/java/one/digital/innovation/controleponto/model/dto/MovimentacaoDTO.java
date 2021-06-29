package one.digital.innovation.controleponto.model.dto;

import lombok.*;
import one.digital.innovation.controleponto.model.Calendario;
import one.digital.innovation.controleponto.model.Movimentacao;
import one.digital.innovation.controleponto.model.Ocorrencia;
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
public class MovimentacaoDTO {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public static class MovimentacaoIdDTO implements Serializable {
        private Long idMovimento;
        private Long idUsuario;

        public MovimentacaoIdDTO(Movimentacao.MovimentacaoId movimentacaoId) {
            this.idMovimento = movimentacaoId.getIdMovimento();
            this.idUsuario = movimentacaoId.getIdUsuario();
        }
    }

    @Id
    @EmbeddedId
    private MovimentacaoIdDTO id;
    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;
    private BigDecimal periodo;

    private Ocorrencia ocorrencia;
    private Calendario calendario;

    public MovimentacaoDTO(Movimentacao movimentacao) {
        this.id = new MovimentacaoIdDTO(movimentacao.getId());
        this.dataEntrada = movimentacao.getDataEntrada();
        this.dataSaida = movimentacao.getDataSaida();
        this.periodo = movimentacao.getPeriodo();
        this.ocorrencia = movimentacao.getOcorrencia();
        this.calendario = movimentacao.getCalendario();
    }
}
