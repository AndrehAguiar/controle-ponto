package one.digital.innovation.controleponto.controller;

import one.digital.innovation.controleponto.model.dto.UsuarioDTO;
import one.digital.innovation.controleponto.service.UsuarioService;
import one.digital.innovation.controleponto.swagger.docs.UsuarioControllerDoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController implements UsuarioControllerDoc {

    private final UsuarioService service;

    @Autowired
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @Override
    @PostMapping
    public ResponseEntity<UsuarioDTO> createUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.save(usuarioDTO));
    }

    @Override
    @PutMapping
    public ResponseEntity<UsuarioDTO> updateUsuario(@Valid @RequestBody UsuarioDTO usuarioDTO) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.save(usuarioDTO));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<UsuarioDTO> deleteUsuario(@PathVariable Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.delete(id));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<UsuarioDTO> findUsuarioById(@PathVariable Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findById(id));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<UsuarioDTO>> listAllUsuario() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findAll());
    }
}
