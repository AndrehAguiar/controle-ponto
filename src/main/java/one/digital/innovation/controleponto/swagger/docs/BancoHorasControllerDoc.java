package one.digital.innovation.controleponto.swagger.docs;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import one.digital.innovation.controleponto.model.dto.BancoHorasDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Api("Gerencia a Banco de Horas")
public interface BancoHorasControllerDoc {

    @ApiOperation(value = "Operação de criação da Banco de Horas.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Sucesso na criação da Banco de Horas."),
            @ApiResponse(code = 400, message = "Erro nos atributos informados ou atributos faltantes.")
    })
    ResponseEntity<BancoHorasDTO> createBancoHoras(BancoHorasDTO BancoHorasDTO);

    @ApiOperation(value = "Operação de alteração da Banco de Horas.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso na alteração da Banco de Horas."),
            @ApiResponse(code = 400, message = "Erro nos atributos informados ou atributos faltantes."),
            @ApiResponse(code = 404, message = "Categoria de Usuário não encontrada.")
    })
    ResponseEntity<BancoHorasDTO> updateBancoHoras(BancoHorasDTO BancoHorasDTO);

    @ApiOperation(value = "Operação de exclusão da Banco de Horas.")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Sucesso na exclusão da Banco de Horas."),
            @ApiResponse(code = 404, message = "Categoria de Usuário não encontrada.")
    })
    ResponseEntity<BancoHorasDTO> deleteBancoHoras(Long idBancoHoras, Long idMovimento, Long idUsuario) throws Exception;

    @ApiOperation(value = "Operação de busca por um Banco de Horas específico.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso no retorno da Banco de Horas."),
            @ApiResponse(code = 404, message = "Categoria de Usuário não encontrada.")
    })
    ResponseEntity<BancoHorasDTO> findBancoHorasById(Long idBancoHoras, Long idMovimento, Long idUsuario) throws Exception;

    @ApiOperation(value = "Operação de busca por todos os Banco de Horas.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso no retorno da Banco de Horas."),
            @ApiResponse(code = 404, message = "Categoria de Usuário não encontrada.")
    })
    ResponseEntity<List<BancoHorasDTO>> listAllBancoHoras();
}
