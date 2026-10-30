package ifrn.nc.sigaai.servicoimoveis.DTO;

import ifrn.nc.sigaai.servicoimoveis.model.Imovel;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
public class FotoRequestDTO {
    

    @NotNull (message = "O ID da foto é obrigatório")
    private Long id;

    @NotNull(message = "O id do imovel nâo pode ser nulo.")
    private Long imovelId;

    @NotBlank (message = "A URL da foto é obrigatória")
    private String url;
    private String legenda;
    private Boolean principal;

    public FotoRequestDTO(){}
    public FotoRequestDTO(Long id, Long imovelId, String url, String legenda, Boolean principal){
        this.id = id;
        this.imovelId = imovelId;
        this.url = url;
        this.legenda = legenda;
        this.principal = principal;
    }
}
