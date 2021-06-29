# Construindo um sistema de controle de ponto e acesso com Spring Boot

Documentação publicada no [Documenter.getPostman]( https://documenter.getpostman.com/view/4791077/TzkyLesL)

Também pode ser visualizado pela implementação do [Swagger 2](http://localhost:8081/swagger-ui.html)

- Além da documentação dos endpoints, foi implementada a documentação da camada de controle como o exemplo abaixo:

```java
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
```

- Também foi implementada a camada DTO (Data Transfer Object) para manter a consistência da arquitetura e integridade das entidades providas pelo banco de dados.

  <img src="D:\controle-ponto\img\esquema.jpg" alt="esquema" style="zoom:50%;" />

  

- No projeto foram implementas classes com identificadores compostos, para estas classes foram utilizados "recursos alternativos" para gerenciamento dos registros, como o exemplo abaixo:

  ```java
  "SERVICE"
  @Transactional
  public BancoHorasDTO save(BancoHorasDTO bancoHorasDTO) {
      if(bancoHorasDTO.getId().getIdBancoHoras() == null){
          Long id = findAll().size() + 1L;
          bancoHorasDTO.getId().setIdBancoHoras(id);
      }
      return new BancoHorasDTO(repository.save(new BancoHoras(bancoHorasDTO)));
  }
  
  "MODEL"
  ...
  @Embeddable
  public static class BancoHorasId implements Serializable {
  
      private Long idBancoHoras;
      private Long idMovimento;
      private Long idUsuario;
  
      public BancoHorasId(BancoHorasDTO.BancoHorasIdDTO bancoHorasIdDTO) {
          this.idBancoHoras = bancoHorasIdDTO.getIdBancoHoras();
          this.idMovimento = bancoHorasIdDTO.getIdMovimento();
          this.idUsuario = bancoHorasIdDTO.getIdUsuario();
  	}
  }
  
  @Id
  @EmbeddedId
  private BancoHorasId id;
  ...
  ```

  

---

###### DESCRIÇÃO

Neste projeto o desafio foi desenvolver uma API Rest para controle de ponto e acesso dos usuários de uma empresa. Foram utilizados Java, Spring Boot, Hibernate Envers e lombok além de documentar toda a API com Swagger.

<span>Spring Boot | Java </span>

##### Especialista

<img  width="80px" src="https://avatars.githubusercontent.com/u/6122791?v=4" />

### Rodolfo Gomes

Desenvolvedor back-end, Sistemap

###### [Digital Innovation One](https://digitalinnovation.one/sign-up?ref=NL9EADWVZW)

---

<a href="https://www.linkedin.com/in/rodolfo-gomes%F0%9F%91%A8%F0%9F%8F%BC%E2%80%8D%F0%9F%92%BB-90497b75/" target="_blank">
<img width="20px" src="https://image.flaticon.com/icons/png/512/174/174857.png"></a>
<span><a href="https://github.com/rodolfogomes" target="_blank">
<img width="20px" src="https://image.flaticon.com/icons/png/512/25/25657.png"></a></span>

