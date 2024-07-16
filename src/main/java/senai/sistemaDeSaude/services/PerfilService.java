package senai.sistemaDeSaude.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import senai.sistemaDeSaude.DTOs.PerfilRequest;
import senai.sistemaDeSaude.entities.Perfil;
import senai.sistemaDeSaude.repositories.PerfilRepository;

@Service
@RequiredArgsConstructor
public class PerfilService {

    private final PerfilRepository repository;

    public void cadastraPerfil(PerfilRequest perfilRequest) {
        if(repository.findByNomePerfil(perfilRequest.nomePerfil()).isPresent()){
            throw new RuntimeException("Perfil já existe com o nome: " + perfilRequest.nomePerfil());
        }

        Perfil perfil = new Perfil();
        perfil.setNomePerfil(perfilRequest.nomePerfil());
        repository.save(perfil);
    }


    public Perfil validaPerfil(String nomePerfil) {
        Perfil perfil = repository.findByNomePerfil(nomePerfil)
                .orElseThrow(
                        () -> new RuntimeException("Perfil não existe com o nome: " + nomePerfil)
                );
        return perfil;
    }
}
