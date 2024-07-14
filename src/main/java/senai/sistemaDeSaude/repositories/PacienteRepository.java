package senai.sistemaDeSaude.repositories;

import senai.sistemaDeSaude.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
