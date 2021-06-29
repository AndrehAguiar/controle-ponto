package one.digital.innovation.controleponto.service;

import one.digital.innovation.controleponto.model.BancoHoras;
import one.digital.innovation.controleponto.model.dto.BancoHorasDTO;
import one.digital.innovation.controleponto.repository.BancoHorasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BancoHorasService {

    private final BancoHorasRepository repository;

    @Autowired
    public BancoHorasService(BancoHorasRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public BancoHorasDTO save(BancoHorasDTO bancoHorasDTO) {
        if(bancoHorasDTO.getId().getIdBancoHoras() == null){
            Long id = findAll().size() + 1L;
            bancoHorasDTO.getId().setIdBancoHoras(id);
        }
        return new BancoHorasDTO(repository.save(new BancoHoras(bancoHorasDTO)));
    }

    @Transactional
    public BancoHorasDTO delete(Long idBancoHoras, Long idMovimento, Long idUsuario) throws Exception {
        BancoHorasDTO bancoHorasDTO = findById(idBancoHoras, idMovimento, idUsuario);
        repository.deleteById(new BancoHoras.BancoHorasId(bancoHorasDTO.getId()));
        return bancoHorasDTO;
    }

    @Transactional(readOnly = true)
    public BancoHorasDTO findById(Long idBancoHoras, Long idMovimento, Long idUsuario) throws Exception {
        return new BancoHorasDTO(repository.findById(
                new BancoHoras.BancoHorasId(idBancoHoras, idMovimento, idUsuario)).orElseThrow(
                () -> new Exception("Banco de horas não localizado.")));
    }

    @Transactional(readOnly = true)
    public List<BancoHorasDTO> findAll() {
        return repository.findAll().stream()
                .map(BancoHorasDTO::new).collect(Collectors.toList());
    }
}
