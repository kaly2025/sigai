package ifrn.nc.sigaai.servicoimoveis.model;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "fotos")
@Data
public class Foto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "imovel_id", nullable = false)
    private Imovel imovel;
    private String url;
    private String legenda;
    private Boolean principal;

    public Foto(){}
    public Foto(Long id, Imovel imovel, String url, String legenda, Boolean principal){
        this.id = id;
        this.imovel = imovel;
        this.url = url;
        this.legenda = legenda;
        this.principal = principal;
    }
}


