package senai.sistemaDeSaude.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import senai.sistemaDeSaude.entities.Perfil;

import java.util.Optional;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Long>{
    Optional<Perfil> findByNomePerfil(String nomePerfil);
}
