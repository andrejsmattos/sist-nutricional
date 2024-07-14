package senai.sistemaDeSaude.services;

import org.springframework.transaction.annotation.Transactional;
import senai.sistemaDeSaude.DTOs.EnderecoResponseDTO;
import senai.sistemaDeSaude.DTOs.PacienteRequestDTO;
import senai.sistemaDeSaude.DTOs.PacienteResponseDTO;
import senai.sistemaDeSaude.entities.Endereco;
import senai.sistemaDeSaude.entities.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import senai.sistemaDeSaude.repositories.EnderecoRepository;
import senai.sistemaDeSaude.repositories.PacienteRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Transactional
    public PacienteResponseDTO criarPaciente(PacienteRequestDTO pacienteRequestDTO) {
        Endereco endereco = new Endereco();
        if (pacienteRequestDTO.getEndereco() != null) {
            endereco.setRua(pacienteRequestDTO.getEndereco().getRua());
            endereco.setCidade(pacienteRequestDTO.getEndereco().getCidade());
            endereco.setEstado(pacienteRequestDTO.getEndereco().getEstado());
            endereco.setCep(pacienteRequestDTO.getEndereco().getCep());
            endereco = enderecoRepository.save(endereco);
        }

        Paciente paciente = new Paciente();
        paciente.setNome(pacienteRequestDTO.getNome());
        paciente.setIdade(pacienteRequestDTO.getIdade());
        paciente.setEndereco(endereco);
        Paciente salvo = pacienteRepository.save(paciente);

        return new PacienteResponseDTO(salvo.getId(), salvo.getNome(), salvo.getIdade(), new EnderecoResponseDTO(salvo.getEndereco().getId(), salvo.getEndereco().getRua(), salvo.getEndereco().getCidade(), salvo.getEndereco().getEstado(), salvo.getEndereco().getCep()));
    }

    @Transactional
    public PacienteResponseDTO atualizarPaciente(Long id, PacienteRequestDTO pacienteRequestDTO) {
        Paciente paciente = pacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        Endereco endereco = new Endereco();
        if (pacienteRequestDTO.getEndereco() != null) {
            endereco.setRua(pacienteRequestDTO.getEndereco().getRua());
            endereco.setCidade(pacienteRequestDTO.getEndereco().getCidade());
            endereco.setEstado(pacienteRequestDTO.getEndereco().getEstado());
            endereco.setCep(pacienteRequestDTO.getEndereco().getCep());
            endereco = enderecoRepository.save(endereco);
        }

        paciente.setNome(pacienteRequestDTO.getNome());
        paciente.setIdade(pacienteRequestDTO.getIdade());
        paciente.setEndereco(endereco);

        Paciente salvo = pacienteRepository.save(paciente);

        return new PacienteResponseDTO(salvo.getId(), salvo.getNome(), salvo.getIdade(), new EnderecoResponseDTO(salvo.getEndereco().getId(), salvo.getEndereco().getRua(), salvo.getEndereco().getCidade(), salvo.getEndereco().getEstado(), salvo.getEndereco().getCep()));
    }

    public void deletarPaciente(Long id) {
        pacienteRepository.deleteById(id);
    }

    public List<PacienteResponseDTO> listarPacientes() {
        return pacienteRepository.findAll().stream()
                .map(paciente -> new PacienteResponseDTO(paciente.getId(), paciente.getNome(), paciente.getIdade(), new EnderecoResponseDTO(paciente.getEndereco().getId(), paciente.getEndereco().getRua(), paciente.getEndereco().getCidade(), paciente.getEndereco().getEstado(), paciente.getEndereco().getCep())))
                .collect(Collectors.toList());
    }

    public PacienteResponseDTO buscarPaciente(Long id) {
        Paciente paciente = pacienteRepository.findById(id).orElseThrow(() -> new RuntimeException("Paciente não encontrado"));
        return new PacienteResponseDTO(paciente.getId(), paciente.getNome(), paciente.getIdade(), new EnderecoResponseDTO(paciente.getEndereco().getId(), paciente.getEndereco().getRua(), paciente.getEndereco().getCidade(), paciente.getEndereco().getEstado(), paciente.getEndereco().getCep()));
    }
}
