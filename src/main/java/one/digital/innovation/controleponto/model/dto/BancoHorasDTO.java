package one.digital.innovation.controleponto.model.dto;

import lombok.*;
import one.digital.innovation.controleponto.model.BancoHoras;

import javax.persistence.Embeddable;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class BancoHorasDTO {

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    @EqualsAndHashCode
    @Embeddable
    public static class BancoHorasIdDTO implements Serializable {

        private Long idBancoHoras;
        private Long idMovimento;
        private Long idUsuario;

        public BancoHorasIdDTO(BancoHoras.BancoHorasId bancoHorasId) {
            this.idBancoHoras = bancoHorasId.getIdBancoHoras();
            this.idMovimento = bancoHorasId.getIdMovimento();
            this.idUsuario = bancoHorasId.getIdUsuario();
        }
    }

    private BancoHorasIdDTO id;
    private LocalDateTime dataTrabalhada;
    private BigDecimal quantidadeHoras;
    private BigDecimal saldoHoras;

    public BancoHorasDTO(BancoHoras bancoHoras) {
        this.id = new BancoHorasIdDTO(bancoHoras.getId());
        this.dataTrabalhada = bancoHoras.getDataTrabalhada();
        this.quantidadeHoras = bancoHoras.getQuantidadeHoras();
        this.saldoHoras = bancoHoras.getSaldoHoras();
    }
}
