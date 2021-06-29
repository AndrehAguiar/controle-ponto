package one.digital.innovation.controleponto.controller;

import one.digital.innovation.controleponto.model.dto.EmpresaDTO;
import one.digital.innovation.controleponto.service.EmpresaService;
import one.digital.innovation.controleponto.swagger.docs.EmpresaControllerDoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/empresa")
public class EmpresaControler implements EmpresaControllerDoc {

    private final EmpresaService service;

    @Autowired
    public EmpresaControler(EmpresaService service) {
        this.service = service;
    }

    @Override
    @PostMapping
    public ResponseEntity<EmpresaDTO> createEmpresa(@Valid @RequestBody EmpresaDTO empresaDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.save(empresaDTO));
    }

    @Override
    @PutMapping
    public ResponseEntity<EmpresaDTO> updateEmpresa(@Valid @RequestBody EmpresaDTO empresaDTO) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.save(empresaDTO));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<EmpresaDTO> deleteEmpresa(@PathVariable Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.delete(id));
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<EmpresaDTO> findEmpresaById(@PathVariable Long id) throws Exception {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findById(id));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<EmpresaDTO>> listAllEmpresa() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findAll());
    }
}
