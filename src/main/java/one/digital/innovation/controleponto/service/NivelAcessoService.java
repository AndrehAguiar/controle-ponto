package one.digital.innovation.controleponto.service;

import one.digital.innovation.controleponto.model.NivelAcesso;
import one.digital.innovation.controleponto.model.dto.NivelAcessoDTO;
import one.digital.innovation.controleponto.repository.NivelAcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NivelAcessoService {

    private final NivelAcessoRepository repository;

    @Autowired
    public NivelAcessoService(NivelAcessoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public NivelAcessoDTO save(NivelAcessoDTO nivelAcessoDTO) {
        return new NivelAcessoDTO(repository.save(new NivelAcesso(nivelAcessoDTO)));
    }

    @Transactional
    public NivelAcessoDTO delete(Long id) throws Exception {
        NivelAcessoDTO nivelAcessoDTO = findById(id);
        repository.deleteById(id);
        return nivelAcessoDTO;
    }

    @Transactional(readOnly = true)
    public NivelAcessoDTO findById(Long id) throws Exception {
        return new NivelAcessoDTO(repository.findById(id).orElseThrow(
                () -> new Exception("Nivel de acesso não encontrado.")));
    }

    @Transactional(readOnly = true)
    public List<NivelAcessoDTO> findAll() {
        return repository.findAll().stream()
                .map(NivelAcessoDTO::new).collect(Collectors.toList());
    }
}
