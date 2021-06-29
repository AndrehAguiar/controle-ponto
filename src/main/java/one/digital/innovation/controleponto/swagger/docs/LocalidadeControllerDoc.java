package one.digital.innovation.controleponto.swagger.docs;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import one.digital.innovation.controleponto.model.dto.LocalidadeDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Api("Gerencia a Localidade")
public interface LocalidadeControllerDoc {

    @ApiOperation(value = "Operação de criação da Localidade.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Sucesso na criação da Localidade."),
            @ApiResponse(code = 400, message = "Erro nos atributos informados ou atributos faltantes.")
    })
    ResponseEntity<LocalidadeDTO> createLocalidade(LocalidadeDTO LocalidadeDTO);

    @ApiOperation(value = "Operação de alteração da Empresa.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso na alteração da Localidade."),
            @ApiResponse(code = 400, message = "Erro nos atributos informados ou atributos faltantes."),
            @ApiResponse(code = 404, message = "Localidade não encontrada.")
    })
    ResponseEntity<LocalidadeDTO> updateLocalidade(LocalidadeDTO LocalidadeDTO);

    @ApiOperation(value = "Operação de exclusão da Localidade.")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Sucesso na exclusão da Localidade."),
            @ApiResponse(code = 404, message = "Localidade não encontrada.")
    })
    ResponseEntity<LocalidadeDTO> deleteLocalidade(Long id) throws Exception;

    @ApiOperation(value = "Operação de busca por uma Localidade específico.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso no retorno da Localidade."),
            @ApiResponse(code = 404, message = "Localidade não encontrada.")
    })
    ResponseEntity<LocalidadeDTO> findLocalidadeById(Long id) throws Exception;

    @ApiOperation(value = "Operação de busca por todos os Localidade.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso no retorno da Localidade."),
            @ApiResponse(code = 404, message = "Localidade não encontrada.")
    })
    ResponseEntity<List<LocalidadeDTO>> listAllLocalidade();
}
