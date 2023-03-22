package repositories;
import entities.EntidadEtiquetas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
public interface RepositorioEtiquetas extends CrudRepository<EntidadEtiquetas, Integer> {

    List<EntidadEtiquetas> findByName(@Param("nombre") String nombre);
}
