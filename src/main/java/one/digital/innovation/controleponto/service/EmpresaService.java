package one.digital.innovation.controleponto.service;

import one.digital.innovation.controleponto.model.Empresa;
import one.digital.innovation.controleponto.model.dto.EmpresaDTO;
import one.digital.innovation.controleponto.repository.EmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmpresaService {

    private final EmpresaRepository repository;

    @Autowired
    public EmpresaService(EmpresaRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public EmpresaDTO save(EmpresaDTO empresaDTO) {
        return new EmpresaDTO(repository.save(new Empresa(empresaDTO)));
    }

    @Transactional
    public EmpresaDTO delete(Long id) throws Exception {
        EmpresaDTO empresaDTO = findById(id);
        repository.deleteById(id);
        return empresaDTO;
    }

    @Transactional(readOnly = true)
    public EmpresaDTO findById(Long id) throws Exception {
        return new EmpresaDTO(repository.findById(id).orElseThrow(
                () -> new Exception("Empresa não encontrada.")));
    }

    @Transactional(readOnly = true)
    public List<EmpresaDTO> findAll() {
        return repository.findAll().stream()
                .map(EmpresaDTO::new).collect(Collectors.toList());
    }
}
