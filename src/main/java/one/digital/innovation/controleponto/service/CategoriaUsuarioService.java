package one.digital.innovation.controleponto.service;

import one.digital.innovation.controleponto.model.CategoriaUsuario;
import one.digital.innovation.controleponto.model.dto.CategoriaUsuarioDTO;
import one.digital.innovation.controleponto.repository.CategoriaUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaUsuarioService {

    private final CategoriaUsuarioRepository repository;

    @Autowired
    public CategoriaUsuarioService(CategoriaUsuarioRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public CategoriaUsuarioDTO save(CategoriaUsuarioDTO categoriaUsuarioDTO) {
        return new CategoriaUsuarioDTO(repository.save(new CategoriaUsuario(categoriaUsuarioDTO)));
    }

    @Transactional
    public CategoriaUsuarioDTO delete(Long id) throws Exception {
        CategoriaUsuarioDTO categoriaUsuarioDTO = findById(id);
        repository.deleteById(id);
        return categoriaUsuarioDTO;
    }

    @Transactional(readOnly = true)
    public CategoriaUsuarioDTO findById(Long id) throws Exception {
        return new CategoriaUsuarioDTO(repository.findById(id).orElseThrow(
                () -> new Exception("Categoria de usuário não encontrada")));
    }

    @Transactional(readOnly = true)
    public List<CategoriaUsuarioDTO> findAll() {
        return repository.findAll().stream()
                .map(CategoriaUsuarioDTO::new).collect(Collectors.toList());
    }
}
