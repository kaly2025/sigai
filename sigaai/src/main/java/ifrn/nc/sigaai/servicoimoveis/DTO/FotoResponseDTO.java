package ifrn.nc.sigaai.servicoimoveis.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import ifrn.nc.sigaai.servicoimoveis.model.Imovel;

@Data

public class FotoResponseDTO {

    public FotoResponseDTO(){}
    public FotoResponseDTO(Long id, long imovelId, String url, String legenda, Boolean principal) {
        this.id = id;
        this.imovelId = imovelId;
        this.url = url;
        this.legenda = legenda;
        this.principal = principal;
    }

    private Long id;

    private long imovelId;
    private String url;
    private String legenda;
    private Boolean principal;

}
