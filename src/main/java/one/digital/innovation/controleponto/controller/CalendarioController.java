package one.digital.innovation.controleponto.controller;

import one.digital.innovation.controleponto.model.dto.CalendarioDTO;
import one.digital.innovation.controleponto.service.CalendarioService;
import one.digital.innovation.controleponto.swagger.docs.CalendarioControllerDoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/calendario")
public class CalendarioController implements CalendarioControllerDoc {

    private final CalendarioService service;

    @Autowired
    public CalendarioController(CalendarioService service) {
        this.service = service;
    }

    @Override
    @PostMapping
    public ResponseEntity<CalendarioDTO> createCalendario(@Valid @RequestBody CalendarioDTO calendarioDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.save(calendarioDTO));
    }

    @Override
    @PutMapping
    public ResponseEntity<CalendarioDTO> updateCalendario(@Valid @RequestBody CalendarioDTO calendarioDTO) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.save(calendarioDTO));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<CalendarioDTO> deleteCalendario(@PathVariable Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.delete(id));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<CalendarioDTO> findCalendarioById(@PathVariable Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findById(id));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<CalendarioDTO>> listAllCalendario() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findAll());
    }
}
