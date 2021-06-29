package one.digital.innovation.controleponto.model;

import lombok.*;
import one.digital.innovation.controleponto.model.dto.CalendarioDTO;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Audited
public class Calendario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private TipoData tipoData;
    private String descricao;
    private LocalDateTime dataEspecial;

    public Calendario(CalendarioDTO calendarioDTO) {
        this.id = calendarioDTO.getId();
        this.tipoData = calendarioDTO.getTipoData();
        this.descricao = calendarioDTO.getDescricao();
        this.dataEspecial = calendarioDTO.getDataEspecial();
    }
}
