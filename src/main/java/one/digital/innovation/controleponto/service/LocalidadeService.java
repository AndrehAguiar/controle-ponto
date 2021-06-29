package one.digital.innovation.controleponto.service;

import one.digital.innovation.controleponto.model.Localidade;
import one.digital.innovation.controleponto.model.dto.LocalidadeDTO;
import one.digital.innovation.controleponto.repository.LocalidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocalidadeService {

    private final LocalidadeRepository repository;

    @Autowired
    public LocalidadeService(LocalidadeRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public LocalidadeDTO save(LocalidadeDTO localidadeDTO) {
        return new LocalidadeDTO(repository.save(new Localidade(localidadeDTO)));
    }

    @Transactional
    public LocalidadeDTO delete(Long id) throws Exception {
        LocalidadeDTO localidadeDTO = findById(id);
        repository.deleteById(id);
        return localidadeDTO;
    }

    @Transactional(readOnly = true)
    public LocalidadeDTO findById(Long id) throws Exception {
        return new LocalidadeDTO(repository.findById(id).orElseThrow(
                () -> new Exception("Localidade não encontrada.")));
    }

    @Transactional(readOnly = true)
    public List<LocalidadeDTO> findAll() {
        return repository.findAll().stream()
                .map(LocalidadeDTO::new).collect(Collectors.toList());
    }
}
