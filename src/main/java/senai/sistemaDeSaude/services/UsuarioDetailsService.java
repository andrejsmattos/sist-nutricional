package senai.sistemaDeSaude.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import senai.sistemaDeSaude.infra.UsuarioUserDetails;
import senai.sistemaDeSaude.repositories.UsuarioRepository;

@Service
@RequiredArgsConstructor
public class UsuarioDetailsService implements UserDetailsService {

    private final UsuarioRepository repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return repository.findByUsername(username)
                .map(UsuarioUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("Nome do usuário não encontrado: " + username));
    }
}
