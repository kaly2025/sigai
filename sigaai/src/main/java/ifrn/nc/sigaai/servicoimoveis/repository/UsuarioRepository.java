package ifrn.nc.sigaai.servicoimoveis.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import ifrn.nc.sigaai.servicoimoveis.model.Usuario;
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username);        
    
}
