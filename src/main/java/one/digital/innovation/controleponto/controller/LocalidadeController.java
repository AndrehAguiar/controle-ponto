package one.digital.innovation.controleponto.controller;

import one.digital.innovation.controleponto.model.dto.LocalidadeDTO;
import one.digital.innovation.controleponto.service.LocalidadeService;
import one.digital.innovation.controleponto.swagger.docs.LocalidadeControllerDoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/localidade")
public class LocalidadeController implements LocalidadeControllerDoc {

    private final LocalidadeService service;

    @Autowired
    public LocalidadeController(LocalidadeService service) {
        this.service = service;
    }

    @Override
    @PostMapping
    public ResponseEntity<LocalidadeDTO> createLocalidade(@Valid @RequestBody LocalidadeDTO LocalidadeDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.save(LocalidadeDTO));
    }

    @Override
    @PutMapping
    public ResponseEntity<LocalidadeDTO> updateLocalidade(@Valid @RequestBody LocalidadeDTO LocalidadeDTO) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.save(LocalidadeDTO));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<LocalidadeDTO> deleteLocalidade(@PathVariable Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.delete(id));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<LocalidadeDTO> findLocalidadeById(@PathVariable Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findById(id));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<LocalidadeDTO>> listAllLocalidade() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findAll());
    }
}
