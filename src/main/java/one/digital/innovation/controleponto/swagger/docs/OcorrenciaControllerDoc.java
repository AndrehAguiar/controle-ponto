package one.digital.innovation.controleponto.swagger.docs;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import one.digital.innovation.controleponto.model.dto.OcorrenciaDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Api("Gerencia o Ocorrência")
public interface OcorrenciaControllerDoc {

    @ApiOperation(value = "Operação de criação da Ocorrência.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Sucesso na criação da Ocorrência."),
            @ApiResponse(code = 400, message = "Erro nos atributos informados ou atributos faltantes.")
    })
    ResponseEntity<OcorrenciaDTO> createOcorrencia(OcorrenciaDTO ocorrenciaDTO);

    @ApiOperation(value = "Operação de alteração da Ocorrência.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso na alteração da Ocorrência."),
            @ApiResponse(code = 400, message = "Erro nos atributos informados ou atributos faltantes."),
            @ApiResponse(code = 404, message = "Ocorrência não encontrada.")
    })
    ResponseEntity<OcorrenciaDTO> updateOcorrencia(OcorrenciaDTO ocorrenciaDTO);

    @ApiOperation(value = "Operação de exclusão da Ocorrência.")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Sucesso na exclusão da Ocorrência."),
            @ApiResponse(code = 404, message = "Ocorrência não encontrada.")
    })
    ResponseEntity<OcorrenciaDTO> deleteOcorrencia(Long id) throws Exception;

    @ApiOperation(value = "Operação de busca por um Ocorrência específico.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso no retorno da Ocorrência."),
            @ApiResponse(code = 404, message = "Ocorrência não encontrada.")
    })
    ResponseEntity<OcorrenciaDTO> findOcorrenciaById(Long id) throws Exception;

    @ApiOperation(value = "Operação de busca por todos os Ocorrência.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso no retorno da Ocorrência."),
            @ApiResponse(code = 404, message = "Ocorrência não encontrada.")
    })
    ResponseEntity<List<OcorrenciaDTO>> listAllOcorrencia();
}
