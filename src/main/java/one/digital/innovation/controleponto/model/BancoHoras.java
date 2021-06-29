package one.digital.innovation.controleponto.model;

import lombok.*;
import one.digital.innovation.controleponto.model.dto.BancoHorasDTO;
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
public class BancoHoras {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public static class BancoHorasId implements Serializable {

        private Long idBancoHoras;
        private Long idMovimento;
        private Long idUsuario;

        public BancoHorasId(BancoHorasDTO.BancoHorasIdDTO bancoHorasIdDTO) {
            this.idBancoHoras = bancoHorasIdDTO.getIdBancoHoras();
            this.idMovimento = bancoHorasIdDTO.getIdMovimento();
            this.idUsuario = bancoHorasIdDTO.getIdUsuario();
        }
    }

    @Id
    @EmbeddedId
    private BancoHorasId id;
    private LocalDateTime dataTrabalhada;
    private BigDecimal quantidadeHoras;
    private BigDecimal saldoHoras;

    public BancoHoras(BancoHorasDTO bancoHorasDTO) {
        this.id = new BancoHorasId(bancoHorasDTO.getId());
        this.dataTrabalhada = bancoHorasDTO.getDataTrabalhada();
        this.quantidadeHoras = bancoHorasDTO.getQuantidadeHoras();
        this.saldoHoras = bancoHorasDTO.getSaldoHoras();
    }
}
