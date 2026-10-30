package ifrn.nc.sigaai.servicoimoveis.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "imoveis") // Nome da tabela[cite: 96]
@Data @NoArgsConstructor @AllArgsConstructor
public class Imovel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String endereco;
    private Double valorAluguel;
    private String descricao;
}