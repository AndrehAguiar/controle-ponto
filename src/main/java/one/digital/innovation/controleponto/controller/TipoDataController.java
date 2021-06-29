package one.digital.innovation.controleponto.controller;

import one.digital.innovation.controleponto.model.dto.TipoDataDTO;
import one.digital.innovation.controleponto.service.TipoDataService;
import one.digital.innovation.controleponto.swagger.docs.TipoDataControllerDoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tipo-data")
public class TipoDataController implements TipoDataControllerDoc {

    private final TipoDataService service;

    @Autowired
    public TipoDataController(TipoDataService service) {
        this.service = service;
    }

    @Override
    @PostMapping
    public ResponseEntity<TipoDataDTO> createTipoData(@Valid @RequestBody TipoDataDTO tipoDataDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.save(tipoDataDTO));
    }

    @Override
    @PutMapping
    public ResponseEntity<TipoDataDTO> updateTipoData(@Valid @RequestBody TipoDataDTO tipoDataDTO) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.save(tipoDataDTO));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<TipoDataDTO> deleteTipoData(@PathVariable Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.delete(id));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<TipoDataDTO> findTipoDataById(@PathVariable Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findById(id));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<TipoDataDTO>> listAllTipoData() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findAll());
    }
}
