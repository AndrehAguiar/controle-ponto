package one.digital.innovation.controleponto.service;

import one.digital.innovation.controleponto.model.Ocorrencia;
import one.digital.innovation.controleponto.model.dto.OcorrenciaDTO;
import one.digital.innovation.controleponto.repository.OcorrenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OcorrenciaService {

    private final OcorrenciaRepository repository;

    @Autowired
    public OcorrenciaService(OcorrenciaRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public OcorrenciaDTO save(OcorrenciaDTO ocorrenciaDTO) {
        return new OcorrenciaDTO(repository.save(new Ocorrencia(ocorrenciaDTO)));
    }

    @Transactional
    public OcorrenciaDTO delete(Long id) throws Exception {
        OcorrenciaDTO ocorrenciaDTO = findById(id);
        repository.deleteById(id);
        return ocorrenciaDTO;
    }

    @Transactional(readOnly = true)
    public OcorrenciaDTO findById(Long id) throws Exception {
        return new OcorrenciaDTO(repository.findById(id).orElseThrow(
                () -> new Exception("Ocorrência não encontrada.")));
    }

    @Transactional(readOnly = true)
    public List<OcorrenciaDTO> findAll() {
        return repository.findAll().stream()
                .map(OcorrenciaDTO::new).collect(Collectors.toList());
    }
}
