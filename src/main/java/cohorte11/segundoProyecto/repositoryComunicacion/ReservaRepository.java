package cohorte11.segundoProyecto.repositoryComunicacion;

import cohorte11.segundoProyecto.modelEntidades.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva, Long>
{
}
