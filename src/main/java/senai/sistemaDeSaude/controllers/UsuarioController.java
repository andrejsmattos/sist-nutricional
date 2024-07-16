package senai.sistemaDeSaude.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import senai.sistemaDeSaude.DTOs.LoginRequest;
import senai.sistemaDeSaude.services.UsuarioService;

@RestController
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/cadastro")
    public ResponseEntity<String> cadastraUsuario(@RequestBody LoginRequest loginRequest) {
/*        if (loginRequest.nomePerfil() == null || loginRequest.nomePerfil().isBlank()) {
            return new ResponseEntity<>("O nome do perfil não pode ser nulo ou vazio", HttpStatus.BAD_REQUEST);
        }*/

        usuarioService.cadastraUsuario(loginRequest);
        return new ResponseEntity<>("Usuário criado", HttpStatus.CREATED);
    }
}