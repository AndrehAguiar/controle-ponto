package one.digital.innovation.controleponto.swagger.docs;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import one.digital.innovation.controleponto.model.dto.CategoriaUsuarioDTO;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Api("Gerencia a Categoria de Usuário")
public interface CategoriaControllerDoc {

    @ApiOperation(value = "Operação de criação da Categoria de Usuário.")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Sucesso na criação da Categoria de Usuário."),
            @ApiResponse(code = 400, message = "Erro nos atributos informados ou atributos faltantes.")
    })
    ResponseEntity<CategoriaUsuarioDTO> createCategoria(CategoriaUsuarioDTO categoriaUsuarioDTO);

    @ApiOperation(value = "Operação de alteração da Categoria de Usuário.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso na alteração da Categoria de Usuário."),
            @ApiResponse(code = 400, message = "Erro nos atributos informados ou atributos faltantes."),
            @ApiResponse(code = 404, message = "Categoria de Usuário não encontrada.")
    })
    ResponseEntity<CategoriaUsuarioDTO> updateCategoria(CategoriaUsuarioDTO categoriaUsuarioDTO);

    @ApiOperation(value = "Operação de exclusão da Categoria de Usuário.")
    @ApiResponses(value = {
            @ApiResponse(code = 204, message = "Sucesso na exclusão da Categoria de Usuário."),
            @ApiResponse(code = 404, message = "Categoria de Usuário não encontrada.")
    })
    ResponseEntity<CategoriaUsuarioDTO> deleteCategoria(Long id) throws Exception;

    @ApiOperation(value = "Operação de busca por uma categoria de usuário específica.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso no retorno da Categoria de Usuário."),
            @ApiResponse(code = 404, message = "Categoria de Usuário não encontrada.")
    })
    ResponseEntity<CategoriaUsuarioDTO> findCategoriaById(Long id) throws Exception;

    @ApiOperation(value = "Operação de busca por todas as categorias de usuários.")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Sucesso no retorno da Categoria de Usuário."),
            @ApiResponse(code = 404, message = "Categoria de Usuário não encontrada.")
    })
    ResponseEntity<List<CategoriaUsuarioDTO>> listAllCategoria();
}
