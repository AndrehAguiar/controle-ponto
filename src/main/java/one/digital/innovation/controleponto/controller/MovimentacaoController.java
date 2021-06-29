package one.digital.innovation.controleponto.controller;

import one.digital.innovation.controleponto.model.dto.MovimentacaoDTO;
import one.digital.innovation.controleponto.service.MovimentacaoService;
import one.digital.innovation.controleponto.swagger.docs.MovimentacaoControllerDoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/movimentacao")
public class MovimentacaoController implements MovimentacaoControllerDoc {

    private final MovimentacaoService service;

    @Autowired
    public MovimentacaoController(MovimentacaoService service) {
        this.service = service;
    }

    @Override
    @PostMapping
    public ResponseEntity<MovimentacaoDTO> createMovimentacao(@Valid @RequestBody MovimentacaoDTO movimentacaoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.save(movimentacaoDTO));
    }

    @Override
    @PutMapping
    public ResponseEntity<MovimentacaoDTO> updateMovimentacao(@Valid @RequestBody MovimentacaoDTO movimentacaoDTO) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.save(movimentacaoDTO));
    }

    @Override
    @DeleteMapping("/{idMovimento}/{idUsuario}")
    public ResponseEntity<MovimentacaoDTO> deleteMovimentacao(@PathVariable Long idMovimento, @PathVariable Long idUsuario) throws Exception {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.delete(idMovimento, idUsuario));
    }

    @Override
    @GetMapping("/{idMovimento}/{idUsuario}")
    public ResponseEntity<MovimentacaoDTO> findMovimentacaoById(@PathVariable Long idMovimento, @PathVariable Long idUsuario) throws Exception {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findById(idMovimento, idUsuario));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<MovimentacaoDTO>> listAllMovimentacao() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findAll());
    }
}
