package senai.sistemaDeSaude.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import senai.sistemaDeSaude.DTOs.NutricionistaRequestDTO;
import senai.sistemaDeSaude.DTOs.NutricionistaResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import senai.sistemaDeSaude.services.NutricionistaService;
import senai.sistemaDeSaude.services.TokenService;

import java.util.List;

@RestController
@RequestMapping("/nutricionistas")
public class NutricionistaController {

    @Autowired
    private NutricionistaService nutricionistaService;

    private final TokenService tokenService;

    public NutricionistaController(TokenService tokenService) {
        this.tokenService = tokenService;
    }

    @PostMapping("/criar")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<NutricionistaResponseDTO> criarNutricionista(@RequestBody NutricionistaRequestDTO nutricionistaRequestDTO) {
        NutricionistaResponseDTO nutricionista = nutricionistaService.criarNutricionista(nutricionistaRequestDTO);
        return ResponseEntity.ok(nutricionista);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'NUTRICIONISTA')")
    public ResponseEntity<NutricionistaResponseDTO> atualizarNutricionista(@PathVariable Long id, @RequestBody NutricionistaRequestDTO nutricionistaRequestDTO) {
        NutricionistaResponseDTO nutricionista = nutricionistaService.atualizarNutricionista(id, nutricionistaRequestDTO);
        return ResponseEntity.ok(nutricionista);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Void> deletarNutricionista(@PathVariable Long id) {
        nutricionistaService.deletarNutricionista(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    @PreAuthorize("hasAnyAuthority('ADMIN', 'NUTRICIONISTA')")
    public ResponseEntity<List<NutricionistaResponseDTO>> listarNutricionistas(
            @RequestHeader(name = "Authorization") String token
    ) {
        tokenService.validaToken(token, "NUTRI");


        List<NutricionistaResponseDTO> nutricionistas = nutricionistaService.listarNutricionistas();
        return ResponseEntity.ok(nutricionistas);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'NUTRICIONISTA')")
    public ResponseEntity<NutricionistaResponseDTO> buscarNutricionista(@PathVariable Long id) {
        NutricionistaResponseDTO nutricionista = nutricionistaService.buscarNutricionista(id);
        return ResponseEntity.ok(nutricionista);
    }

    @PutMapping("/{id}/adicionarAno")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'NUTRICIONISTA')")
    public ResponseEntity<NutricionistaResponseDTO> adicionarAnoDeExperiencia(@PathVariable Long id) {
        NutricionistaResponseDTO nutricionista = nutricionistaService.adicionarAnoDeExperiencia(id);
        return ResponseEntity.ok(nutricionista);
    }

    @PutMapping("/{id}/adicionarCertificacao")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'NUTRICIONISTA')")
    public ResponseEntity<NutricionistaResponseDTO> adicionarCertificacao(@PathVariable Long id, @RequestBody String certificacao) {
        NutricionistaResponseDTO nutricionista = nutricionistaService.adicionarCertificacao(id, certificacao);
        return ResponseEntity.ok(nutricionista);
    }
}
