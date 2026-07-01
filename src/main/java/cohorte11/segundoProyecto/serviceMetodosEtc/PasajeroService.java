package cohorte11.segundoProyecto.serviceMetodosEtc;

import cohorte11.segundoProyecto.modelEntidades.Pasajero;
import cohorte11.segundoProyecto.repositoryComunicacion.PasajeroRepository;
import cohorte11.segundoProyecto.web.error.RecursoNoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PasajeroService
{

    private final PasajeroRepository pasajeroRepository;

    public PasajeroService(PasajeroRepository pasajeroRepository)
    {
        this.pasajeroRepository = pasajeroRepository;
    }

    // CREATE
    public Pasajero guardarPasajero(Pasajero pasajero)
    {
        return pasajeroRepository.save(pasajero);
    }

    // READ ALL
    public List<Pasajero> obtenerPasajeros()
    {
        return pasajeroRepository.findAll();
    }

    // READ BY ID
    public Optional<Pasajero> obtenerPasajeroPorId(Long id)
    {
        return pasajeroRepository.findById(id);
    }

    // UPDATE
    public Pasajero actualizarPasajero(Long id, Pasajero pasajeroActualizado)
    {
        Pasajero pasajeroExistente = pasajeroRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "Pasajero no encontrado con id " + id));

        pasajeroExistente.setNombre(pasajeroActualizado.getNombre());
        pasajeroExistente.setApellido(pasajeroActualizado.getApellido());
        pasajeroExistente.setDocumento(pasajeroActualizado.getDocumento());
        pasajeroExistente.setEmail(pasajeroActualizado.getEmail());

        return pasajeroRepository.save(pasajeroExistente);
    }

    // DELETE
    public boolean eliminarPasajero(Long id)
    {
        if (!pasajeroRepository.existsById(id))
        {
            throw new RecursoNoEncontradoException(
                    "Pasajero no encontrado con id " + id);
        }

        pasajeroRepository.deleteById(id);
        return true;
    }
}
