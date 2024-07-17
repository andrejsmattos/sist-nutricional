package senai.sistemaDeSaude.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import senai.sistemaDeSaude.DTOs.PacienteRequestDTO;
import senai.sistemaDeSaude.DTOs.PacienteResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import senai.sistemaDeSaude.services.PacienteService;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @PostMapping("/criar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<PacienteResponseDTO> criarPaciente(@RequestBody PacienteRequestDTO pacienteRequestDTO) {
        PacienteResponseDTO paciente = pacienteService.criarPaciente(pacienteRequestDTO);
        return ResponseEntity.ok(paciente);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN', 'PACIENTE')")
    public ResponseEntity<PacienteResponseDTO> atualizarPaciente(@PathVariable Long id, @RequestBody PacienteRequestDTO pacienteRequestDTO) {
        PacienteResponseDTO paciente = pacienteService.atualizarPaciente(id, pacienteRequestDTO);
        return ResponseEntity.ok(paciente);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> deletarPaciente(@PathVariable Long id) {
        pacienteService.deletarPaciente(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'NUTRICIONISTA')")
    public ResponseEntity<List<PacienteResponseDTO>> listarPacientes() {
        List<PacienteResponseDTO> pacientes = pacienteService.listarPacientes();
        return ResponseEntity.ok(pacientes);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'NUTRICIONISTA', 'PACIENTE)")
    public ResponseEntity<PacienteResponseDTO> buscarPaciente(@PathVariable Long id) {
        PacienteResponseDTO paciente = pacienteService.buscarPaciente(id);
        return ResponseEntity.ok(paciente);
    }
}