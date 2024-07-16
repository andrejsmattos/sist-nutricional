package senai.sistemaDeSaude.entities;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

@Entity
@Table(name = "perfil")
@Data
public class Perfil implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "perfil_id")
    private Long id;

    private String nomePerfil;


    @Override
    public String getAuthority() {
        return this.nomePerfil;
    }
}
