package one.digital.innovation.controleponto.service;

import one.digital.innovation.controleponto.model.Usuario;
import one.digital.innovation.controleponto.model.dto.UsuarioDTO;
import one.digital.innovation.controleponto.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    @Autowired
    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public UsuarioDTO save(UsuarioDTO usuarioDTO) {
        return new UsuarioDTO(repository.save(new Usuario(usuarioDTO)));
    }

    @Transactional
    public UsuarioDTO delete(Long id) throws Exception {
        UsuarioDTO usuarioDTO = findById(id);
        repository.deleteById(id);
        return usuarioDTO;
    }

    @Transactional(readOnly = true)
    public UsuarioDTO findById(Long id) throws Exception {
        return new UsuarioDTO(repository.findById(id).orElseThrow(
                () -> new Exception("Usuário não encontrado.")));
    }

    @Transactional(readOnly = true)
    public List<UsuarioDTO> findAll() {
        return repository.findAll().stream()
                .map(UsuarioDTO::new).collect(Collectors.toList());
    }
}
