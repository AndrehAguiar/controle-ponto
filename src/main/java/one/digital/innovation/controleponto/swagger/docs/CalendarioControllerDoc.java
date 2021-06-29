package one.digital.innovation.controleponto.swagger.docs;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import one.digital.innovation.controleponto.model.dto.CalendarioDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Api("Gerencia a Calendario")
public interface CalendarioControllerDoc {

    @ApiOperation(value = "Operação de criação da Calendario.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Sucesso na criação da Calendario."),
            @ApiResponse(code = 400, message = "Erro nos atributos informados ou atributos faltantes.")
    })
    ResponseEntity<CalendarioDTO> createCalendario(CalendarioDTO calendarioDTO);

    @ApiOperation(value = "Operação de alteração da Calendario.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso na alteração da Calendário."),
            @ApiResponse(code = 400, message = "Erro nos atributos informados ou atributos faltantes."),
            @ApiResponse(code = 404, message = "Calendário não encontrada.")
    })
    ResponseEntity<CalendarioDTO> updateCalendario(CalendarioDTO calendarioDTO);

    @ApiOperation(value = "Operação de exclusão da Calendário.")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Sucesso na exclusão da Calendário."),
            @ApiResponse(code = 404, message = "Calendário não encontrada.")
    })
    ResponseEntity<CalendarioDTO> deleteCalendario(Long id) throws Exception;

    @ApiOperation(value = "Operação de busca por um Calendário específico.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso no retorno da Calendário."),
            @ApiResponse(code = 404, message = "Calendário não encontrada.")
    })
    ResponseEntity<CalendarioDTO> findCalendarioById(Long id) throws Exception;

    @ApiOperation(value = "Operação de busca por todos os Calendário.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso no retorno da Calendário."),
            @ApiResponse(code = 404, message = "Calendário não encontrada.")
    })
    ResponseEntity<List<CalendarioDTO>> listAllCalendario();
}
