package one.digital.innovation.controleponto.service;

import one.digital.innovation.controleponto.model.JornadaTrabalho;
import one.digital.innovation.controleponto.model.dto.JornadaTrabalhoDTO;
import one.digital.innovation.controleponto.repository.JornadaTrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JornadaTrabalhoService {

    private final JornadaTrabalhoRepository repository;

    @Autowired
    public JornadaTrabalhoService(JornadaTrabalhoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public JornadaTrabalhoDTO save(JornadaTrabalhoDTO jornadaTrabalhoDTO) {
        return new JornadaTrabalhoDTO(repository.save(new JornadaTrabalho(jornadaTrabalhoDTO)));
    }

    @Transactional
    public JornadaTrabalhoDTO deleteById(Long id) throws Exception {
        JornadaTrabalhoDTO jornadaTrabalhoDTO = findById(id);
        repository.deleteById(id);
        return jornadaTrabalhoDTO;
    }

    @Transactional(readOnly = true)
    public JornadaTrabalhoDTO findById(Long id) throws Exception {
        return new JornadaTrabalhoDTO(repository.findById(id).orElseThrow(
                () -> new Exception("Jornada de trabalho não encontrada.")));
    }

    @Transactional(readOnly = true)
    public List<JornadaTrabalhoDTO> findAll() {
        return repository.findAll().stream()
                .map(JornadaTrabalhoDTO::new).collect(Collectors.toList());
    }
}
