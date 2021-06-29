package one.digital.innovation.controleponto.model.dto;

import lombok.*;
import one.digital.innovation.controleponto.model.Ocorrencia;
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
public class OcorrenciaDTO {
    private Long id;
    private String nome;
    private String descricao;

    public OcorrenciaDTO(Ocorrencia ocorrencia) {
        this.id = ocorrencia.getId();
        this.nome = ocorrencia.getNome();
        this.descricao = ocorrencia.getDescricao();
    }
}
