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

        usuarioService.cadastraUsuario(loginRequest);
        return new ResponseEntity<>("Usuário criado", HttpStatus.CREATED);
    }
}