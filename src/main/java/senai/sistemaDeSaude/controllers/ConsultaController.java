package senai.sistemaDeSaude.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasAnyAuthority('ADMIN', 'NUTRICIONISTA')")
    public ResponseEntity<ConsultaResponseDTO> criarConsulta(@RequestBody ConsultaRequestDTO consultaRequestDTO) {
        ConsultaResponseDTO consulta = consultaService.criarConsulta(consultaRequestDTO);
        return ResponseEntity.ok(consulta);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<ConsultaResponseDTO> atualizarConsulta(@PathVariable Long id, @RequestBody ConsultaRequestDTO consultaRequestDTO) {
        ConsultaResponseDTO consulta = consultaService.atualizarConsulta(id, consultaRequestDTO);
        return ResponseEntity.ok(consulta);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'NUTRICIONISTA')")
    public ResponseEntity<Void> deletarConsulta(@PathVariable Long id) {
        consultaService.deletarConsulta(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'NUTRICIONISTA')")
    public ResponseEntity<List<ConsultaResponseDTO>> listarConsultas() {
        List<ConsultaResponseDTO> consultas = consultaService.listarConsultas();
        return ResponseEntity.ok(consultas);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'NUTRICIONISTA', 'PACIENTE')")
    public ResponseEntity<ConsultaResponseDTO> buscarConsulta(@PathVariable Long id) {
        ConsultaResponseDTO consulta = consultaService.buscarConsulta(id);
        return ResponseEntity.ok(consulta);
    }
}
