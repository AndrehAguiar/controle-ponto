package one.digital.innovation.controleponto.model.dto;

import lombok.*;
import one.digital.innovation.controleponto.model.NivelAcesso;
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
public class NivelAcessoDTO {
    private Long id;
    private String descricao;

    public NivelAcessoDTO(NivelAcesso nivelAcesso) {
        this.id = nivelAcesso.getId();
        this.descricao = nivelAcesso.getDescricao();
    }
}
