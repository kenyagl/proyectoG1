package repositories;

import entities.EntidadPreguntas;
import org.springframework.data.repository.CrudRepository;

public interface RepositorioPreguntas extends CrudRepository<EntidadPreguntas, Long> {

}
