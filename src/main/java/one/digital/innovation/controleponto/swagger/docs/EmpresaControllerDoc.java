package one.digital.innovation.controleponto.swagger.docs;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import one.digital.innovation.controleponto.model.dto.EmpresaDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Api("Gerencia a Empresa")
public interface EmpresaControllerDoc {

    @ApiOperation(value = "Operação de criação da Empresa.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Sucesso na criação da Empresa."),
            @ApiResponse(code = 400, message = "Erro nos atributos informados ou atributos faltantes.")
    })
    ResponseEntity<EmpresaDTO> createEmpresa(EmpresaDTO empresaDTO);

    @ApiOperation(value = "Operação de alteração da Empresa.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso na alteração da Empresa."),
            @ApiResponse(code = 400, message = "Erro nos atributos informados ou atributos faltantes."),
            @ApiResponse(code = 404, message = "Empresa não encontrada.")
    })
    ResponseEntity<EmpresaDTO> updateEmpresa(EmpresaDTO empresaDTO);

    @ApiOperation(value = "Operação de exclusão da Empresa.")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Sucesso na exclusão da Empresa."),
            @ApiResponse(code = 404, message = "Empresa não encontrada.")
    })
    ResponseEntity<EmpresaDTO> deleteEmpresa(Long id) throws Exception;

    @ApiOperation(value = "Operação de busca por uma Empresa específico.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso no retorno da Empresa."),
            @ApiResponse(code = 404, message = "Empresa não encontrada.")
    })
    ResponseEntity<EmpresaDTO> findEmpresaById(Long id) throws Exception;

    @ApiOperation(value = "Operação de busca por todos os Empresa.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso no retorno da Empresa."),
            @ApiResponse(code = 404, message = "Empresa não encontrada.")
    })
    ResponseEntity<List<EmpresaDTO>> listAllEmpresa();
}
