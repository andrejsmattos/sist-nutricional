package senai.sistemaDeSaude.services;

import senai.sistemaDeSaude.DTOs.*;
import senai.sistemaDeSaude.entities.Consulta;
import senai.sistemaDeSaude.entities.Nutricionista;
import senai.sistemaDeSaude.entities.Paciente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import senai.sistemaDeSaude.repositories.ConsultaRepository;
import senai.sistemaDeSaude.repositories.NutricionistaRepository;
import senai.sistemaDeSaude.repositories.PacienteRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ConsultaService {
    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private NutricionistaRepository nutricionistaRepository;

    @Autowired
    private PacienteRepository pacienteRepository;

    public ConsultaResponseDTO criarConsulta(ConsultaRequestDTO consultaRequestDTO) {
        Nutricionista nutricionista = nutricionistaRepository.findById(consultaRequestDTO.getNutricionistaId())
                .orElseThrow(() -> new RuntimeException("Nutricionista não encontrado"));

        Paciente paciente = pacienteRepository.findById(consultaRequestDTO.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        Consulta consulta = new Consulta();
        consulta.setDataHora(consultaRequestDTO.getDataHora());
        consulta.setNutricionista(nutricionista);
        consulta.setPaciente(paciente);

        Consulta salvo = consultaRepository.save(consulta);

        return getConsultaResponseDTO(salvo);
    }

    public ConsultaResponseDTO atualizarConsulta(Long id, ConsultaRequestDTO consultaRequestDTO) {
        Consulta consulta = consultaRepository.findById(id).orElseThrow(() -> new RuntimeException("Consulta não encontrada"));

        Nutricionista nutricionista = nutricionistaRepository.findById(consultaRequestDTO.getNutricionistaId())
                .orElseThrow(() -> new RuntimeException("Nutricionista não encontrado"));

        Paciente paciente = pacienteRepository.findById(consultaRequestDTO.getPacienteId())
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado"));

        consulta.setDataHora(consultaRequestDTO.getDataHora());
        consulta.setNutricionista(nutricionista);
        consulta.setPaciente(paciente);

        Consulta salvo = consultaRepository.save(consulta);

        return getConsultaResponseDTO(salvo);
    }

    public void deletarConsulta(Long id) {
        consultaRepository.deleteById(id);
    }

    public List<ConsultaResponseDTO> listarConsultas() {
        return consultaRepository.findAll().stream()
                .map(consulta -> new ConsultaResponseDTO(consulta.getId(), consulta.getDataHora(), new NutricionistaResponseDTO(consulta.getNutricionista().getId(), consulta.getNutricionista().getNome(), consulta.getNutricionista().getAnosDeExperiencia(), consulta.getNutricionista().getCertificacoes()), new PacienteResponseDTO(consulta.getPaciente().getId(), consulta.getPaciente().getNome(), consulta.getPaciente().getIdade(), new EnderecoResponseDTO(consulta.getPaciente().getEndereco().getId(), consulta.getPaciente().getEndereco().getRua(), consulta.getPaciente().getEndereco().getCidade(), consulta.getPaciente().getEndereco().getEstado(), consulta.getPaciente().getEndereco().getCep()))))
                .collect(Collectors.toList());
    }

    public ConsultaResponseDTO buscarConsulta(Long id) {
        Consulta consulta = consultaRepository.findById(id).orElseThrow(() -> new RuntimeException("Consulta não encontrada"));
        return getConsultaResponseDTO(consulta);
    }

    private ConsultaResponseDTO getConsultaResponseDTO(Consulta consulta) {
        return new ConsultaResponseDTO(consulta.getId(), consulta.getDataHora(), new NutricionistaResponseDTO(consulta.getNutricionista().getId(), consulta.getNutricionista().getNome(), consulta.getNutricionista().getAnosDeExperiencia(), consulta.getNutricionista().getCertificacoes()), new PacienteResponseDTO(consulta.getPaciente().getId(), consulta.getPaciente().getNome(), consulta.getPaciente().getIdade(), new EnderecoResponseDTO(consulta.getPaciente().getEndereco().getId(), consulta.getPaciente().getEndereco().getRua(), consulta.getPaciente().getEndereco().getCidade(), consulta.getPaciente().getEndereco().getEstado(), consulta.getPaciente().getEndereco().getCep())));
    }
}