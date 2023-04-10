package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="TiposPerfil")
public class EntidadTiposPerfil {
    /**
     * The IdPerfil.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer idPerfil;

    private String perfil;

    /**
     * Instantiates a new Customer.
     *
     * @param perfil               the perfil
     */
    public EntidadTiposPerfil(String perfil) {
        this.perfil = perfil;
    }
}
