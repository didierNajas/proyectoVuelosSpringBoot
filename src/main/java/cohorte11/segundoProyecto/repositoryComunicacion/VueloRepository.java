package cohorte11.segundoProyecto.repositoryComunicacion;

import cohorte11.segundoProyecto.modelEntidades.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Long>
{

}
