package senai.sistemaDeSaude.repositories;

import senai.sistemaDeSaude.entities.Nutricionista;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface NutricionistaRepository extends JpaRepository<Nutricionista, Long> {
    Optional<Nutricionista> findByNome(String nome);
}