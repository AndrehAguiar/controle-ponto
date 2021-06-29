package one.digital.innovation.controleponto.service;

import one.digital.innovation.controleponto.model.Movimentacao;
import one.digital.innovation.controleponto.model.dto.MovimentacaoDTO;
import one.digital.innovation.controleponto.repository.MovimentacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovimentacaoService {

    private final MovimentacaoRepository repository;

    @Autowired
    public MovimentacaoService(MovimentacaoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public MovimentacaoDTO save(MovimentacaoDTO movimentacaoDTO) {
        if(movimentacaoDTO.getId().getIdMovimento() == null) {
            Long id = findAll().size() + 1L;
            movimentacaoDTO.getId().setIdMovimento(id);
        }
        return new MovimentacaoDTO(repository.save(new Movimentacao(movimentacaoDTO)));
    }


    public MovimentacaoDTO delete(Long idMovimento, Long idUsuario) throws Exception {
        MovimentacaoDTO movimentacaoDTO = findById(idMovimento, idUsuario);
        repository.deleteById(new Movimentacao.MovimentacaoId(idMovimento, idUsuario));
        return movimentacaoDTO;
    }

    public MovimentacaoDTO findById(Long idMovimento, Long idUsuario) throws Exception {
        return new MovimentacaoDTO(repository.findById(new Movimentacao.MovimentacaoId(idMovimento, idUsuario)).orElseThrow(
                () -> new Exception("Movimentação não encontrada.")));
    }

    public List<MovimentacaoDTO> findAll() {
        return repository.findAll().stream()
                .map(MovimentacaoDTO::new).collect(Collectors.toList());
    }
}
