package one.digital.innovation.controleponto.controller;

import one.digital.innovation.controleponto.model.dto.OcorrenciaDTO;
import one.digital.innovation.controleponto.service.OcorrenciaService;
import one.digital.innovation.controleponto.swagger.docs.OcorrenciaControllerDoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/ocorrencia")
public class OcorreciaController implements OcorrenciaControllerDoc {

    private final OcorrenciaService service;

    @Autowired
    public OcorreciaController(OcorrenciaService service) {
        this.service = service;
    }


    @Override
    @PostMapping
    public ResponseEntity<OcorrenciaDTO> createOcorrencia(@Valid @RequestBody OcorrenciaDTO ocorrenciaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.save(ocorrenciaDTO));
    }

    @Override
    @PutMapping
    public ResponseEntity<OcorrenciaDTO> updateOcorrencia(@Valid @RequestBody OcorrenciaDTO ocorrenciaDTO) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.save(ocorrenciaDTO));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<OcorrenciaDTO> deleteOcorrencia(@PathVariable Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.delete(id));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<OcorrenciaDTO> findOcorrenciaById(@PathVariable Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findById(id));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<OcorrenciaDTO>> listAllOcorrencia() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findAll());
    }
}
