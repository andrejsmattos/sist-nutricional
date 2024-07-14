package senai.sistemaDeSaude.controllers;

import senai.sistemaDeSaude.DTOs.ConsultaRequestDTO;
import senai.sistemaDeSaude.DTOs.ConsultaResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import senai.sistemaDeSaude.services.ConsultaService;

import java.util.List;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
    @Autowired
    private ConsultaService consultaService;

    @PostMapping("/criar")
    public ResponseEntity<ConsultaResponseDTO> criarConsulta(@RequestBody ConsultaRequestDTO consultaRequestDTO) {
        ConsultaResponseDTO consulta = consultaService.criarConsulta(consultaRequestDTO);
        return ResponseEntity.ok(consulta);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ConsultaResponseDTO> atualizarConsulta(@PathVariable Long id, @RequestBody ConsultaRequestDTO consultaRequestDTO) {
        ConsultaResponseDTO consulta = consultaService.atualizarConsulta(id, consultaRequestDTO);
        return ResponseEntity.ok(consulta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarConsulta(@PathVariable Long id) {
        consultaService.deletarConsulta(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<ConsultaResponseDTO>> listarConsultas() {
        List<ConsultaResponseDTO> consultas = consultaService.listarConsultas();
        return ResponseEntity.ok(consultas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConsultaResponseDTO> buscarConsulta(@PathVariable Long id) {
        ConsultaResponseDTO consulta = consultaService.buscarConsulta(id);
        return ResponseEntity.ok(consulta);
    }
}
