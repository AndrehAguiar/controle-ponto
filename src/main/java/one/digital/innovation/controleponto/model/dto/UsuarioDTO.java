package one.digital.innovation.controleponto.model.dto;

import lombok.*;
import one.digital.innovation.controleponto.model.*;
import org.hibernate.envers.Audited;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class UsuarioDTO {

    private Long id;
    private String nome;
    private Empresa empresa;
    private NivelAcesso nivelAcesso;
    private CategoriaUsuario categoriaUsuario;
    private JornadaTrabalho jornadaTrabalho;
    private BigDecimal tolerancia;
    private LocalDateTime inicioJornada;
    private LocalDateTime finalJornada;

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.empresa = usuario.getEmpresa();
        this.nivelAcesso = usuario.getNivelAcesso();
        this.categoriaUsuario = usuario.getCategoriaUsuario();
        this.jornadaTrabalho = usuario.getJornadaTrabalho();
        this.tolerancia = usuario.getTolerancia();
        this.inicioJornada = usuario.getInicioJornada();
        this.finalJornada = usuario.getFinalJornada();
    }
}
