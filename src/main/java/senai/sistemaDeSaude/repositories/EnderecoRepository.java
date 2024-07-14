package senai.sistemaDeSaude.repositories;

import senai.sistemaDeSaude.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {
}
