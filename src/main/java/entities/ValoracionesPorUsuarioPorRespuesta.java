package entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="ValoracionesPorUsuarioPorRespuesta")
public class ValoracionesPorUsuarioPorRespuesta {
   @Id
    private Long idUsuario;
   @Id
    private Long idRespuesta;

   private Boolean puntuacion;
   private String texto;

   private Boolean aviso;
}
