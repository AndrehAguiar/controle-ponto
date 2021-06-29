package one.digital.innovation.controleponto.controller;

import one.digital.innovation.controleponto.model.dto.NivelAcessoDTO;
import one.digital.innovation.controleponto.service.NivelAcessoService;
import one.digital.innovation.controleponto.swagger.docs.NivelAcessoControllerDoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/nivel-acesso")
public class NivelAcessoController implements NivelAcessoControllerDoc {

    private final NivelAcessoService service;

    @Autowired
    public NivelAcessoController(NivelAcessoService service) {
        this.service = service;
    }

    @Override
    @PostMapping
    public ResponseEntity<NivelAcessoDTO> createNivelAcesso(@Valid @RequestBody NivelAcessoDTO nivelAcessoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.save(nivelAcessoDTO));
    }

    @Override
    @PutMapping
    public ResponseEntity<NivelAcessoDTO> updateNivelAcesso(@Valid @RequestBody NivelAcessoDTO nivelAcessoDTO) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.save(nivelAcessoDTO));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<NivelAcessoDTO> deleteNivelAcesso(@PathVariable Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.delete(id));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<NivelAcessoDTO> findNivelAcessoById(@PathVariable Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findById(id));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<NivelAcessoDTO>> listAllNivelAcesso() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findAll());
    }
}
