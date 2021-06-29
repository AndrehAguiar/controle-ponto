package one.digital.innovation.controleponto.model;

import lombok.*;
import one.digital.innovation.controleponto.model.dto.CategoriaUsuarioDTO;
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
public class CategoriaUsuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;

    public CategoriaUsuario(CategoriaUsuarioDTO categoriaUsuarioDTO) {
        this.id = categoriaUsuarioDTO.getId();
        this.descricao = categoriaUsuarioDTO.getDescricao();
    }

}
