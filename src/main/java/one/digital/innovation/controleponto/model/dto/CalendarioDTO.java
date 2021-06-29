package one.digital.innovation.controleponto.model.dto;

import lombok.*;
import one.digital.innovation.controleponto.model.Calendario;
import one.digital.innovation.controleponto.model.TipoData;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class CalendarioDTO {

    private Long id;
    private TipoData tipoData;
    private String descricao;
    private LocalDateTime dataEspecial;

    public CalendarioDTO(Calendario calendario) {
        this.id = calendario.getId();
        this.tipoData = calendario.getTipoData();
        this.descricao = calendario.getDescricao();
        this.dataEspecial = calendario.getDataEspecial();
    }
}
