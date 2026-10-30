package ifrn.nc.sigaai.servicoimoveis.DTO;
import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor
public class ImovelResponseDTO {
    
    private Long id;
    private String endereco;
    private Double valorAluguel;
   
}