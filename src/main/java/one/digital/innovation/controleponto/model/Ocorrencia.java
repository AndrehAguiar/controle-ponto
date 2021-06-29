package one.digital.innovation.controleponto.model;

import lombok.*;
import one.digital.innovation.controleponto.model.dto.OcorrenciaDTO;
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
public class Ocorrencia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String descricao;

    public Ocorrencia(OcorrenciaDTO ocorrenciaDTO) {
        this.id = ocorrenciaDTO.getId();
        this.nome = ocorrenciaDTO.getNome();
        this.descricao = ocorrenciaDTO.getDescricao();
    }
}
