package senai.sistemaDeSaude.infra;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import senai.sistemaDeSaude.entities.Usuario;

import java.util.Collection;

@RequiredArgsConstructor
public class UsuarioUserDetails extends Usuario implements UserDetails {

    private final Usuario usuario;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return usuario.getAuthorities();
    }

    @Override
    public String getPassword() {
        return usuario.getPassword();
    }

    @Override
    public String getUsername() {
        return usuario.getUsername();
    }
}
