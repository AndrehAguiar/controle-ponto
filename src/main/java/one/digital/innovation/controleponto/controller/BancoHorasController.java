package one.digital.innovation.controleponto.controller;


import one.digital.innovation.controleponto.model.dto.BancoHorasDTO;
import one.digital.innovation.controleponto.service.BancoHorasService;
import one.digital.innovation.controleponto.swagger.docs.BancoHorasControllerDoc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/banco-horas")
public class BancoHorasController implements BancoHorasControllerDoc {

    private final BancoHorasService service;

    @Autowired
    public BancoHorasController(BancoHorasService service) {
        this.service = service;
    }

    @Override
    @PostMapping
    public ResponseEntity<BancoHorasDTO> createBancoHoras(@Valid @RequestBody BancoHorasDTO bancoHorasDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.save(bancoHorasDTO));
    }

    @Override
    @PutMapping
    public ResponseEntity<BancoHorasDTO> updateBancoHoras(@Valid @RequestBody BancoHorasDTO bancoHorasDTO) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.save(bancoHorasDTO));
    }

    @Override
    @DeleteMapping("/{idBancoHoras}/{idMovimento}/{idUsuario}")
    public ResponseEntity<BancoHorasDTO> deleteBancoHoras(@PathVariable Long idBancoHoras, @PathVariable Long idMovimento, @PathVariable Long idUsuario) throws Exception {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.delete(idBancoHoras, idMovimento, idUsuario));
    }

    @Override
    @GetMapping("/{idBancoHoras}/{idMovimento}/{idUsuario}")
    public ResponseEntity<BancoHorasDTO> findBancoHorasById(@PathVariable Long idBancoHoras, @PathVariable Long idMovimento, @PathVariable Long idUsuario) throws Exception {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findById(idBancoHoras, idMovimento, idUsuario));
    }

    @Override
    @GetMapping
    public ResponseEntity<List<BancoHorasDTO>> listAllBancoHoras() {
        return ResponseEntity.status(HttpStatus.OK)
                .body(service.findAll());
    }
}
