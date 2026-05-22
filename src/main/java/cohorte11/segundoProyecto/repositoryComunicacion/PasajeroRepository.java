package cohorte11.segundoProyecto.repositoryComunicacion;

import cohorte11.segundoProyecto.modelEntidades.Pasajero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PasajeroRepository extends JpaRepository<Pasajero, Long>
{

}
