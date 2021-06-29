package one.digital.innovation.controleponto.swagger.docs;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import one.digital.innovation.controleponto.model.dto.JornadaTrabalhoDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Api("Gerencia a Jornada de Trabalho")
public interface JornadaControllerDoc {

    @ApiOperation(value = "Operação de criação da Jornada de trabalho.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Sucesso na criação da jornada de trabalho."),
            @ApiResponse(code = 400, message = "Erro nos atributos informados ou atributos faltantes.")
    })
    ResponseEntity<JornadaTrabalhoDTO> createJornada(JornadaTrabalhoDTO JornadaTrabalhoDTO);

    @ApiOperation(value = "Operação de alteração da Jornada de trabalho.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso na alteração da jornada de trabalho."),
            @ApiResponse(code = 400, message = "Erro nos atributos informados ou atributos faltantes."),
            @ApiResponse(code = 404, message = "Jornada de trabalho não encontrada.")
    })
    ResponseEntity<JornadaTrabalhoDTO> updateJornada(JornadaTrabalhoDTO JornadaTrabalhoDTO);

    @ApiOperation(value = "Operação de exclusão da Jornada de trabalho.")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Sucesso na exclusão da jornada de trabalho."),
            @ApiResponse(code = 404, message = "Jornada de trabalho não encontrada.")
    })
    ResponseEntity<JornadaTrabalhoDTO> deleteJornada(Long id) throws Exception;

    @ApiOperation(value = "Operação de busca de uma Jornada de trabalho específica.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso no retorno da jornada de trabalho."),
            @ApiResponse(code = 404, message = "Jornada de trabalho não encontrada.")
    })
    ResponseEntity<JornadaTrabalhoDTO> findJornadaById(Long id) throws Exception;

    @ApiOperation(value = "Operação de busca de todas as Jornadas de trabalho.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso no retorno da jornada de trabalho."),
            @ApiResponse(code = 404, message = "Jornada de trabalho não encontrada.")
    })
    ResponseEntity<List<JornadaTrabalhoDTO>> listAllJornada();
}
