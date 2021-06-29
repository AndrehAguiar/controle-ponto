package one.digital.innovation.controleponto.model;

import lombok.*;
import one.digital.innovation.controleponto.model.dto.UsuarioDTO;
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
@Entity
@Audited
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToOne
    private Empresa empresa;

    @ManyToOne
    private NivelAcesso nivelAcesso;

    @ManyToOne
    private CategoriaUsuario categoriaUsuario;

    @ManyToOne
    private JornadaTrabalho jornadaTrabalho;
    private BigDecimal tolerancia;
    private LocalDateTime inicioJornada;
    private LocalDateTime finalJornada;

    public Usuario(UsuarioDTO usuarioDTO) {
        this.id = usuarioDTO.getId();
        this.nome = usuarioDTO.getNome();
        this.empresa = usuarioDTO.getEmpresa();
        this.nivelAcesso = usuarioDTO.getNivelAcesso();
        this.categoriaUsuario = usuarioDTO.getCategoriaUsuario();
        this.jornadaTrabalho = usuarioDTO.getJornadaTrabalho();
        this.tolerancia = usuarioDTO.getTolerancia();
        this.inicioJornada = usuarioDTO.getInicioJornada();
        this.finalJornada = usuarioDTO.getFinalJornada();
    }
}
