package senai.sistemaDeSaude.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import senai.sistemaDeSaude.DTOs.LoginRequest;
import senai.sistemaDeSaude.entities.Perfil;
import senai.sistemaDeSaude.entities.Usuario;
import senai.sistemaDeSaude.repositories.UsuarioRepository;

import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final BCryptPasswordEncoder passwordEncoder;
    private final UsuarioRepository usuarioRepository;
    private final PerfilService perfilService;


    public Usuario validaUsuario (LoginRequest loginRequest) {

        Usuario usuario = usuarioRepository
                .findByUsername(loginRequest.username())
                .orElseThrow(
                        () -> new RuntimeException("Usuário não existe com o nome " + loginRequest.username())
                );

        if (!passwordEncoder.matches(loginRequest.password(), usuario.getPassword())) {
            throw new RuntimeException("Senha incorreta para o usuário: " + loginRequest.username());
        }
        return usuario;
    }

    public void cadastraUsuario(LoginRequest loginRequest) {
        if (usuarioRepository.findByUsername(loginRequest.username()).isPresent()) {
            throw new RuntimeException("Usuário já existe com o nome: " + loginRequest.username());
        }

        Perfil perfil = perfilService.validaPerfil(loginRequest.nomePerfil());

        Usuario usuario = new Usuario();
        usuario.setUsername(loginRequest.username());
        usuario.setPassword(passwordEncoder.encode(loginRequest.password()));
        usuario.setPerfilList(Set.of(perfil));

        usuarioRepository.save(usuario);
    }

}
