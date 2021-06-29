package one.digital.innovation.controleponto.model;

import lombok.*;
import one.digital.innovation.controleponto.model.dto.JornadaTrabalhoDTO;
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
@Entity
@Audited
public class JornadaTrabalho {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;

    public JornadaTrabalho(JornadaTrabalhoDTO jornadaTrabalhoDTO) {
        this.id = jornadaTrabalhoDTO.getId();
        this.descricao = jornadaTrabalhoDTO.getDescricao();
    }
}
