package one.digital.innovation.controleponto.model.dto;

import lombok.*;
import one.digital.innovation.controleponto.model.Empresa;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class EmpresaDTO {

    private Long id;
    private String descricao;
    private String cnpj;
    private String endereco;
    private String bairro;
    private String cidade;
    private String estado;
    private String telefone;

    public EmpresaDTO(Empresa empresa) {
        this.id = empresa.getId();
        this.descricao = empresa.getDescricao();
        this.cnpj = empresa.getCnpj();
        this.endereco = empresa.getEndereco();
        this.bairro = empresa.getBairro();
        this.cidade = empresa.getCidade();
        this.estado = empresa.getEstado();
        this.telefone = empresa.getTelefone();
    }
}
