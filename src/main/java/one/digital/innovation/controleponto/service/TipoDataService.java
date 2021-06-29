package one.digital.innovation.controleponto.service;

import one.digital.innovation.controleponto.model.TipoData;
import one.digital.innovation.controleponto.model.dto.TipoDataDTO;
import one.digital.innovation.controleponto.repository.TipoDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoDataService {

    private final TipoDataRepository repository;

    @Autowired
    public TipoDataService(TipoDataRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public TipoDataDTO save(TipoDataDTO tipoDataDTO) {
        return new TipoDataDTO(repository.save(new TipoData(tipoDataDTO)));
    }

    @Transactional
    public TipoDataDTO delete(Long id) throws Exception {
        TipoDataDTO tipoDataDTO = findById(id);
        repository.deleteById(id);
        return tipoDataDTO;
    }

    @Transactional(readOnly = true)
    public TipoDataDTO findById(Long id) throws Exception {
        return new TipoDataDTO(repository.findById(id).orElseThrow(
                ()->new Exception("Tipo de data não encontrada.")));
    }

    @Transactional(readOnly = true)
    public List<TipoDataDTO> findAll() {
        return repository.findAll().stream()
                .map(TipoDataDTO::new).collect(Collectors.toList());
    }
}
