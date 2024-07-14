package senai.sistemaDeSaude.services;

import senai.sistemaDeSaude.DTOs.NutricionistaRequestDTO;
import senai.sistemaDeSaude.DTOs.NutricionistaResponseDTO;
import senai.sistemaDeSaude.entities.Nutricionista;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import senai.sistemaDeSaude.repositories.NutricionistaRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NutricionistaService {
    @Autowired
    private NutricionistaRepository nutricionistaRepository;

    public NutricionistaResponseDTO criarNutricionista(NutricionistaRequestDTO nutricionistaRequestDTO) {
        if (nutricionistaRepository.findByNome(nutricionistaRequestDTO.getNome()).isPresent()) {
            throw new RuntimeException("Nome do nutricionista já existe");
        }

        Nutricionista nutricionista = new Nutricionista();
        nutricionista.setNome(nutricionistaRequestDTO.getNome());
        nutricionista.setAnosDeExperiencia(nutricionistaRequestDTO.getAnosDeExperiencia());
        nutricionista.setCertificacoes(nutricionistaRequestDTO.getCertificacoes());

        Nutricionista salvo = nutricionistaRepository.save(nutricionista);

        return new NutricionistaResponseDTO(salvo.getId(), salvo.getNome(), salvo.getAnosDeExperiencia(), salvo.getCertificacoes());
    }

    public NutricionistaResponseDTO atualizarNutricionista(Long id, NutricionistaRequestDTO nutricionistaRequestDTO) {
        Nutricionista nutricionista = nutricionistaRepository.findById(id).orElseThrow(() -> new RuntimeException("Nutricionista não encontrado"));

        if (!nutricionista.getNome().equals(nutricionistaRequestDTO.getNome()) &&
                nutricionistaRepository.findByNome(nutricionistaRequestDTO.getNome()).isPresent()) {
            throw new RuntimeException("Nome do nutricionista já existe");
        }

        nutricionista.setNome(nutricionistaRequestDTO.getNome());
        nutricionista.setAnosDeExperiencia(nutricionistaRequestDTO.getAnosDeExperiencia());

        Nutricionista salvo = nutricionistaRepository.save(nutricionista);

        return new NutricionistaResponseDTO(salvo.getId(), salvo.getNome(), salvo.getAnosDeExperiencia(), salvo.getCertificacoes());
    }

    public void deletarNutricionista(Long id) {
        nutricionistaRepository.deleteById(id);
    }

    public List<NutricionistaResponseDTO> listarNutricionistas() {
        return nutricionistaRepository.findAll().stream()
                .map(nutricionista -> new NutricionistaResponseDTO(nutricionista.getId(), nutricionista.getNome(), nutricionista.getAnosDeExperiencia(), nutricionista.getCertificacoes()))
                .collect(Collectors.toList());
    }

    public NutricionistaResponseDTO buscarNutricionista(Long id) {
        Nutricionista nutricionista = nutricionistaRepository.findById(id).orElseThrow(() -> new RuntimeException("Nutricionista não encontrado"));
        return new NutricionistaResponseDTO(nutricionista.getId(), nutricionista.getNome(), nutricionista.getAnosDeExperiencia(), nutricionista.getCertificacoes());
    }

    public NutricionistaResponseDTO adicionarAnoDeExperiencia(Long id) {
        Nutricionista nutricionista = nutricionistaRepository.findById(id).orElseThrow(() -> new RuntimeException("Nutricionista não encontrado"));
        nutricionista.setAnosDeExperiencia(nutricionista.getAnosDeExperiencia() + 1);
        Nutricionista salvo = nutricionistaRepository.save(nutricionista);
        return new NutricionistaResponseDTO(salvo.getId(), salvo.getNome(), salvo.getAnosDeExperiencia(), salvo.getCertificacoes());
    }

    public NutricionistaResponseDTO adicionarCertificacao(Long id, String certificacao) {
        Nutricionista nutricionista = nutricionistaRepository.findById(id).orElseThrow(() -> new RuntimeException("Nutricionista não encontrado"));
        nutricionista.getCertificacoes().add(certificacao);
        Nutricionista salvo = nutricionistaRepository.save(nutricionista);
        return new NutricionistaResponseDTO(salvo.getId(), salvo.getNome(), salvo.getAnosDeExperiencia(), salvo.getCertificacoes());
    }
}
