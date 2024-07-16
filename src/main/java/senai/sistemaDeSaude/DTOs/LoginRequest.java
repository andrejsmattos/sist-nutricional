package senai.sistemaDeSaude.DTOs;

public record LoginRequest(
        String username,
        String password,
        String nomePerfil
) {
}
