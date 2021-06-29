package one.digital.innovation.controleponto.swagger.docs;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import one.digital.innovation.controleponto.model.dto.UsuarioDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Api("Gerencia o Usuario")
public interface UsuarioControllerDoc {

    @ApiOperation(value = "Operação de criação da Usuario.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Sucesso na criação da Usuario."),
            @ApiResponse(code = 400, message = "Erro nos atributos informados ou atributos faltantes.")
    })
    ResponseEntity<UsuarioDTO> createUsuario(UsuarioDTO usuarioDTO);

    @ApiOperation(value = "Operação de alteração da Usuario.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso na alteração da Usuario."),
            @ApiResponse(code = 400, message = "Erro nos atributos informados ou atributos faltantes."),
            @ApiResponse(code = 404, message = "Usuario não encontrada.")
    })
    ResponseEntity<UsuarioDTO> updateUsuario(UsuarioDTO usuarioDTO);

    @ApiOperation(value = "Operação de exclusão da Usuario.")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Sucesso na exclusão da Usuario."),
            @ApiResponse(code = 404, message = "TUsuario não encontrada.")
    })
    ResponseEntity<UsuarioDTO> deleteUsuario(Long id) throws Exception;

    @ApiOperation(value = "Operação de busca por um Usuario específico.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso no retorno da Usuario."),
            @ApiResponse(code = 404, message = "Usuario não encontrada.")
    })
    ResponseEntity<UsuarioDTO> findUsuarioById(Long id) throws Exception;

    @ApiOperation(value = "Operação de busca por todos os Usuario.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso no retorno da Usuario."),
            @ApiResponse(code = 404, message = "Usuario não encontrada.")
    })
    ResponseEntity<List<UsuarioDTO>> listAllUsuario();
}
