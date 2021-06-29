package one.digital.innovation.controleponto.swagger.docs;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import one.digital.innovation.controleponto.model.dto.TipoDataDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Api("Gerencia o Tipo de Data")
public interface TipoDataControllerDoc {

    @ApiOperation(value = "Operação de criação da Tipo de Data.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Sucesso na criação da Tipo de Data."),
            @ApiResponse(code = 400, message = "Erro nos atributos informados ou atributos faltantes.")
    })
    ResponseEntity<TipoDataDTO> createTipoData(TipoDataDTO tipoDataDTO);

    @ApiOperation(value = "Operação de alteração da Tipo de Data.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso na alteração da Tipo de Data."),
            @ApiResponse(code = 400, message = "Erro nos atributos informados ou atributos faltantes."),
            @ApiResponse(code = 404, message = "Tipo de Data não encontrada.")
    })
    ResponseEntity<TipoDataDTO> updateTipoData(TipoDataDTO tipoDataDTO);

    @ApiOperation(value = "Operação de exclusão da Tipo de Data.")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Sucesso na exclusão da Tipo de Data."),
            @ApiResponse(code = 404, message = "Tipo de Data não encontrada.")
    })
    ResponseEntity<TipoDataDTO> deleteTipoData(Long id) throws Exception;

    @ApiOperation(value = "Operação de busca por um Tipo de Data específico.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso no retorno da Tipo de Data."),
            @ApiResponse(code = 404, message = "Tipo de Data não encontrada.")
    })
    ResponseEntity<TipoDataDTO> findTipoDataById(Long id) throws Exception;

    @ApiOperation(value = "Operação de busca por todos os Tipo de Data.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso no retorno da Tipo de Data."),
            @ApiResponse(code = 404, message = "Tipo de Data não encontrada.")
    })
    ResponseEntity<List<TipoDataDTO>> listAllTipoData();
}
