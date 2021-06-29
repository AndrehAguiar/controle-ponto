package one.digital.innovation.controleponto.model;

import lombok.*;
import one.digital.innovation.controleponto.model.dto.LocalidadeDTO;
import org.hibernate.envers.Audited;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@Audited
public class Localidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private NivelAcesso nivelAcesso;
    private String descricao;

    public Localidade(LocalidadeDTO localidadeDTO) {
        this.id = localidadeDTO.getId();
        this.nivelAcesso = localidadeDTO.getNivelAcesso();
        this.descricao = localidadeDTO.getDescricao();
    }
}
