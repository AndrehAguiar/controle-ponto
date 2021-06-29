package one.digital.innovation.controleponto.service;

import one.digital.innovation.controleponto.model.Calendario;
import one.digital.innovation.controleponto.model.dto.CalendarioDTO;
import one.digital.innovation.controleponto.repository.CalendarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalendarioService {

    private final CalendarioRepository repository;

    @Autowired
    public CalendarioService(CalendarioRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public CalendarioDTO save(CalendarioDTO calendarioDTO) {
        return new CalendarioDTO(repository.save(new Calendario(calendarioDTO)));
    }

    @Transactional
    public CalendarioDTO delete(Long id) throws Exception {
        CalendarioDTO calendarioDTO = findById(id);
        repository.deleteById(id);
        return calendarioDTO;
    }

    @Transactional(readOnly = true)
    public CalendarioDTO findById(Long id) throws Exception {
        return new CalendarioDTO(repository.findById(id).orElseThrow(
                () -> new Exception("Calendário não encontrado.")));
    }

    @Transactional(readOnly = true)
    public List<CalendarioDTO> findAll() {
        return repository.findAll().stream()
                .map(CalendarioDTO::new).collect(Collectors.toList());
    }
}
