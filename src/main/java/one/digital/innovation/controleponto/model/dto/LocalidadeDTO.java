package one.digital.innovation.controleponto.model.dto;

import lombok.*;
import one.digital.innovation.controleponto.model.Localidade;
import one.digital.innovation.controleponto.model.NivelAcesso;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class LocalidadeDTO {

    private Long id;
    private NivelAcesso nivelAcesso;
    private String descricao;

    public LocalidadeDTO(Localidade localidade) {
        this.id = localidade.getId();
        this.nivelAcesso = localidade.getNivelAcesso();
        this.descricao = localidade.getDescricao();
    }
}
