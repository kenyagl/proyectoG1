package repositories;

import entities.CategoriaEjercicios;
import entities.EjercicioOpMul;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EjerciciosRepository extends JpaRepository<EjercicioOpMul, Integer> {
}
