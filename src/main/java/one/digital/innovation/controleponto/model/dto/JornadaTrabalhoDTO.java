package one.digital.innovation.controleponto.model.dto;

import lombok.*;
import one.digital.innovation.controleponto.model.JornadaTrabalho;
import org.hibernate.envers.Audited;

import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class JornadaTrabalhoDTO {

    private Long id;
    private String descricao;

    public JornadaTrabalhoDTO(JornadaTrabalho jornadaTrabalho) {
        this.id = jornadaTrabalho.getId();
        this.descricao = jornadaTrabalho.getDescricao();
    }
}
