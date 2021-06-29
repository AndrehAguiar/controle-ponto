package one.digital.innovation.controleponto.swagger.docs;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import one.digital.innovation.controleponto.model.dto.MovimentacaoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Api("Gerencia a Movimentacao")
public interface MovimentacaoControllerDoc {

    @ApiOperation(value = "Operação de criação da Movimentacao.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Sucesso na criação da Movimentacao."),
            @ApiResponse(code = 400, message = "Erro nos atributos informados ou atributos faltantes.")
    })
    ResponseEntity<MovimentacaoDTO> createMovimentacao(MovimentacaoDTO movimentacaoDTO);

    @ApiOperation(value = "Operação de alteração da Movimentacao.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso na alteração da Movimentacao."),
            @ApiResponse(code = 400, message = "Erro nos atributos informados ou atributos faltantes."),
            @ApiResponse(code = 404, message = "Movimentacao não encontrada.")
    })
    ResponseEntity<MovimentacaoDTO> updateMovimentacao(MovimentacaoDTO movimentacaoDTO);

    @ApiOperation(value = "Operação de exclusão da Movimentacao.")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Sucesso na exclusão da Movimentacao."),
            @ApiResponse(code = 404, message = "Movimentacao não encontrada.")
    })
    ResponseEntity<MovimentacaoDTO> deleteMovimentacao(Long idMovimento, Long idUsuarioid) throws Exception;

    @ApiOperation(value = "Operação de busca por um Movimentacao específico.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso no retorno da Movimentacao."),
            @ApiResponse(code = 404, message = "Movimentacao não encontrada.")
    })
    ResponseEntity<MovimentacaoDTO> findMovimentacaoById(Long idMovimento, Long idUsuarioid) throws Exception;

    @ApiOperation(value = "Operação de busca por todos os Movimentacao.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso no retorno da Movimentacao."),
            @ApiResponse(code = 404, message = "Movimentacao não encontrada.")
    })
    ResponseEntity<List<MovimentacaoDTO>> listAllMovimentacao();
}
