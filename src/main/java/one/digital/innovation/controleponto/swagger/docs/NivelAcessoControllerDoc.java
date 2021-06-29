package one.digital.innovation.controleponto.swagger.docs;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import one.digital.innovation.controleponto.model.dto.NivelAcessoDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Api("Gerencia o Nível de acesso")
public interface NivelAcessoControllerDoc {

    @ApiOperation(value = "Operação de criação da Nível de Acesso.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Sucesso na criação da Nível de Acesso."),
            @ApiResponse(code = 400, message = "Erro nos atributos informados ou atributos faltantes.")
    })
    ResponseEntity<NivelAcessoDTO> createNivelAcesso(NivelAcessoDTO nivelAcessoDTO);

    @ApiOperation(value = "Operação de alteração da Nível de Acesso.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso na alteração da Nível de Acesso."),
            @ApiResponse(code = 400, message = "Erro nos atributos informados ou atributos faltantes."),
            @ApiResponse(code = 404, message = "Nível de Acesso não encontrada.")
    })
    ResponseEntity<NivelAcessoDTO> updateNivelAcesso(NivelAcessoDTO nivelAcessoDTO);

    @ApiOperation(value = "Operação de exclusão da Nível de Acesso.")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Sucesso na exclusão da Nível de Acesso."),
            @ApiResponse(code = 404, message = "Nível de Acesso não encontrada.")
    })
    ResponseEntity<NivelAcessoDTO> deleteNivelAcesso(Long id) throws Exception;

    @ApiOperation(value = "Operação de busca por um Nível de Acesso específico.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso no retorno da Nível de Acesso."),
            @ApiResponse(code = 404, message = "Nível de Acesso não encontrada.")
    })
    ResponseEntity<NivelAcessoDTO> findNivelAcessoById(Long id) throws Exception;

    @ApiOperation(value = "Operação de busca por todos os Nível de Acesso.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso no retorno da Nível de Acesso."),
            @ApiResponse(code = 404, message = "Nível de Acesso não encontrada.")
    })
    ResponseEntity<List<NivelAcessoDTO>> listAllNivelAcesso();
}
