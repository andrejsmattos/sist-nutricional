package senai.sistemaDeSaude.controllers;

import senai.sistemaDeSaude.DTOs.EnderecoRequestDTO;
import senai.sistemaDeSaude.DTOs.EnderecoResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import senai.sistemaDeSaude.services.EnderecoService;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoService enderecoService;

    @PostMapping("/criar")
    public ResponseEntity<EnderecoResponseDTO> createEndereco(@RequestBody EnderecoRequestDTO enderecoRequest) {
        EnderecoResponseDTO createdEndereco = enderecoService.criarEndereco(enderecoRequest);
        return ResponseEntity.ok(createdEndereco);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoResponseDTO> atualizarEndereco(@PathVariable Long id, @RequestBody EnderecoRequestDTO enderecoRequestDTO) {
        EnderecoResponseDTO endereco = enderecoService.atualizarEndereco(id, enderecoRequestDTO);
        return ResponseEntity.ok(endereco);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarEndereco(@PathVariable Long id) {
        enderecoService.deletarEndereco(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<EnderecoResponseDTO>> listarEnderecos() {
        List<EnderecoResponseDTO> enderecos = enderecoService.listarEnderecos();
        return ResponseEntity.ok(enderecos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoResponseDTO> buscarEndereco(@PathVariable Long id) {
        EnderecoResponseDTO endereco = enderecoService.buscarEndereco(id);
        return ResponseEntity.ok(endereco);
    }
}
