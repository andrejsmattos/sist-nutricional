package senai.sistemaDeSaude.repositories;

import senai.sistemaDeSaude.entities.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}
