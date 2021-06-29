package one.digital.innovation.controleponto.controller;

import one.digital.innovation.controleponto.model.CategoriaUsuario;
import one.digital.innovation.controleponto.model.dto.CategoriaUsuarioDTO;
import one.digital.innovation.controleponto.service.CategoriaUsuarioService;
import one.digital.innovation.controleponto.swagger.docs.CategoriaControllerDoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categoria-usuario")
public class CategoriaUsuarioController implements CategoriaControllerDoc {

    private final CategoriaUsuarioService service;

    @Autowired
    public CategoriaUsuarioController(CategoriaUsuarioService service) {
        this.service = service;
    }

    @Override
    @PostMapping
    public ResponseEntity<CategoriaUsuarioDTO> createCategoria(@Valid @RequestBody CategoriaUsuarioDTO categoriaUsuarioDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.save(categoriaUsuarioDTO));
    }

    @Override
    @PutMapping
    public ResponseEntity<CategoriaUsuarioDTO> updateCategoria(@Valid @RequestBody CategoriaUsuarioDTO categoriaUsuarioDTO) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.save(categoriaUsuarioDTO));
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<CategoriaUsuarioDTO> deleteCategoria(@PathVariable Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.delete(id));
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoriaUsuarioDTO> findCategoriaById(@PathVariable Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findById(id));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<CategoriaUsuarioDTO>> listAllCategoria() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findAll());
    }
}
