package ifrn.nc.sigaai.servicoimoveis.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.*;

@Data @NoArgsConstructor @AllArgsConstructor
public class ImovelRequestDTO {

    @NotBlank(message = "endereço é obrigatório")
    private String endereco;

    @NotNull @Positive
    private Double valorAluguel;

    @Size(max = 500)
    private String descricao;
}