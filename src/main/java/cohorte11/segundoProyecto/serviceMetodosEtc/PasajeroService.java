package cohorte11.segundoProyecto.serviceMetodosEtc;

import cohorte11.segundoProyecto.modelEntidades.Pasajero;
import cohorte11.segundoProyecto.repositoryComunicacion.PasajeroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PasajeroService {

    private final PasajeroRepository pasajeroRepository;

    public PasajeroService(PasajeroRepository pasajeroRepository) {
        this.pasajeroRepository = pasajeroRepository;
    }

    // CREATE
    public Pasajero guardarPasajero(Pasajero pasajero) {
        return pasajeroRepository.save(pasajero);
    }

    // READ ALL
    public List<Pasajero> obtenerPasajeros() {
        return pasajeroRepository.findAll();
    }

    // READ BY ID
    public Optional<Pasajero> obtenerPasajeroPorId(Long id) {
        return pasajeroRepository.findById(id);
    }

    // UPDATE
    public Pasajero actualizarPasajero(Long id, Pasajero pasajeroActualizado) {

        Pasajero pasajeroExistente = pasajeroRepository.findById(id).orElse(null);

        if (pasajeroExistente != null) {

            pasajeroExistente.setNombre(pasajeroActualizado.getNombre());
            pasajeroExistente.setEmail(pasajeroActualizado.getEmail());

            return pasajeroRepository.save(pasajeroExistente);
        }

        return null;
    }

    // DELETE
    public boolean eliminarPasajero(Long id) {

        if (pasajeroRepository.existsById(id)) {

            pasajeroRepository.deleteById(id);

            return true;
        }

        return false;
    }
}
