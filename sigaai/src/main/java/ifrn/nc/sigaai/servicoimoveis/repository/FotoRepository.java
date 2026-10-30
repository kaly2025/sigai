package ifrn.nc.sigaai.servicoimoveis.repository;

import ifrn.nc.sigaai.servicoimoveis.model.Foto;
import org.springframework.data.jpa.repository.JpaRepository;


public interface FotoRepository extends JpaRepository<Foto, Long> {
    
}
