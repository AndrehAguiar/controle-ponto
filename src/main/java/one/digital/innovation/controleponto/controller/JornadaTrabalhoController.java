package one.digital.innovation.controleponto.controller;

import one.digital.innovation.controleponto.model.dto.JornadaTrabalhoDTO;
import one.digital.innovation.controleponto.service.JornadaTrabalhoService;
import one.digital.innovation.controleponto.swagger.docs.JornadaControllerDoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/jornada")
public class JornadaTrabalhoController implements JornadaControllerDoc {

    private final JornadaTrabalhoService service;

    @Autowired
    public JornadaTrabalhoController(JornadaTrabalhoService service) {
        this.service = service;
    }

    @Override
    @PostMapping
    public ResponseEntity<JornadaTrabalhoDTO> createJornada(@Valid @RequestBody JornadaTrabalhoDTO JornadaTrabalhoDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.save(JornadaTrabalhoDTO));
    }

    @Override
    @PutMapping
    public ResponseEntity<JornadaTrabalhoDTO> updateJornada(@Valid @RequestBody JornadaTrabalhoDTO JornadaTrabalhoDTO) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.save(JornadaTrabalhoDTO));
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<JornadaTrabalhoDTO> deleteJornada(@PathVariable Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.NO_CONTENT)
                .body(service.deleteById(id));
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<JornadaTrabalhoDTO> findJornadaById(@PathVariable("id") Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findById(id));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<JornadaTrabalhoDTO>> listAllJornada() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findAll());
    }
}
