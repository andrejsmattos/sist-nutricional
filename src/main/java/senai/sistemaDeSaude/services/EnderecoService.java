package senai.sistemaDeSaude.services;
import senai.sistemaDeSaude.DTOs.EnderecoRequestDTO;
import senai.sistemaDeSaude.DTOs.EnderecoResponseDTO;
import senai.sistemaDeSaude.entities.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import senai.sistemaDeSaude.repositories.EnderecoRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public EnderecoResponseDTO criarEndereco(EnderecoRequestDTO enderecoRequestDTO) {
        Endereco endereco = new Endereco();
        endereco.setRua(enderecoRequestDTO.getRua());
        endereco.setCidade(enderecoRequestDTO.getCidade());
        endereco.setEstado(enderecoRequestDTO.getEstado());
        endereco.setCep(enderecoRequestDTO.getCep());

        Endereco salvo = enderecoRepository.save(endereco);

        return new EnderecoResponseDTO(salvo.getId(), salvo.getRua(), salvo.getCidade(), salvo.getEstado(), salvo.getCep());
    }

    public EnderecoResponseDTO atualizarEndereco(Long id, EnderecoRequestDTO enderecoRequestDTO) {
        Endereco endereco = enderecoRepository.findById(id).orElseThrow(() -> new RuntimeException("Endereco não encontrado"));
        endereco.setRua(enderecoRequestDTO.getRua());
        endereco.setCidade(enderecoRequestDTO.getCidade());
        endereco.setEstado(enderecoRequestDTO.getEstado());
        endereco.setCep(enderecoRequestDTO.getCep());

        Endereco salvo = enderecoRepository.save(endereco);

        return new EnderecoResponseDTO(salvo.getId(), salvo.getRua(), salvo.getCidade(), salvo.getEstado(), salvo.getCep());
    }

    public void deletarEndereco(Long id) {
        enderecoRepository.deleteById(id);
    }

    public List<EnderecoResponseDTO> listarEnderecos() {
        return enderecoRepository.findAll().stream()
                .map(endereco -> new EnderecoResponseDTO(endereco.getId(), endereco.getRua(), endereco.getCidade(), endereco.getEstado(), endereco.getCep()))
                .collect(Collectors.toList());
    }

    public EnderecoResponseDTO buscarEndereco(Long id) {
        Endereco endereco = enderecoRepository.findById(id).orElseThrow(() -> new RuntimeException("Endereco não encontrado"));
        return new EnderecoResponseDTO(endereco.getId(), endereco.getRua(), endereco.getCidade(), endereco.getEstado(), endereco.getCep());
    }
}
