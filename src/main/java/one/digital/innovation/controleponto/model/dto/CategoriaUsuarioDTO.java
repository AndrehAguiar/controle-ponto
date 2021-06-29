package one.digital.innovation.controleponto.model.dto;

import lombok.*;
import one.digital.innovation.controleponto.model.CategoriaUsuario;
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
public class CategoriaUsuarioDTO {

    private Long id;
    private String descricao;

    public CategoriaUsuarioDTO(CategoriaUsuario categoriaUsuario) {
        this.id = categoriaUsuario.getId();
        this.descricao = categoriaUsuario.getDescricao();
    }
}
