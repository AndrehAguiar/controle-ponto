package one.digital.innovation.controleponto.model.dto;

import lombok.*;
import one.digital.innovation.controleponto.model.TipoData;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class TipoDataDTO {

    private Long id;
    private String descricao;

    public TipoDataDTO(TipoData tipoData) {
        this.id = tipoData.getId();
        this.descricao = tipoData.getDescricao();
    }
}
