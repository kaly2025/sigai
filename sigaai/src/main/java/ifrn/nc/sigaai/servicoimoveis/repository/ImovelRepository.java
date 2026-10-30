package ifrn.nc.sigaai.servicoimoveis.repository;

import ifrn.nc.sigaai.servicoimoveis.model.Imovel;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ImovelRepository extends JpaRepository<Imovel, Long> {
    List<Imovel> findByEndereco(String endereco);
    List<Imovel> findByValorAluguelLessThan(Double valorAluguel);
    List<Imovel> findByEnderecoContainingIgnoreCase(String trecho);

}