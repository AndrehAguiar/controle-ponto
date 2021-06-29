package one.digital.innovation.controleponto.model;

import lombok.*;
import one.digital.innovation.controleponto.model.dto.EmpresaDTO;
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
public class Empresa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricao;
    private String cnpj;
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;
    private String telefone;

    public Empresa(EmpresaDTO empresaDTO) {
        this.id = empresaDTO.getId();
        this.descricao = empresaDTO.getDescricao();
        this.cnpj = empresaDTO.getCnpj();
        this.endereco = empresaDTO.getEndereco();
        this.bairro = empresaDTO.getBairro();
        this.cidade = empresaDTO.getCidade();
        this.estado = empresaDTO.getEstado();
        this.telefone = empresaDTO.getTelefone();
    }
}
