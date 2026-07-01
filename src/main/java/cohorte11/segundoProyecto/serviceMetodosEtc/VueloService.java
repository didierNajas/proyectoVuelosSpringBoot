package cohorte11.segundoProyecto.serviceMetodosEtc;

import cohorte11.segundoProyecto.modelEntidades.Vuelo;
import cohorte11.segundoProyecto.repositoryComunicacion.VueloRepository;
import cohorte11.segundoProyecto.web.error.RecursoNoEncontradoException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VueloService {

    private final VueloRepository vueloRepository;

    public VueloService(VueloRepository vueloRepository) {
        this.vueloRepository = vueloRepository;
    }

    // CREATE
    public Vuelo guardarVuelo(Vuelo vuelo) {
        return vueloRepository.save(vuelo);
    }

    // READ ALL
    public List<Vuelo> obtenerVuelos() {
        return vueloRepository.findAll();
    }

    // READ BY ID
    public Optional<Vuelo> obtenerVueloPorId(Long id) {
        return vueloRepository.findById(id);
    }

    // UPDATE
    public Vuelo actualizarVuelo(Long id, Vuelo vueloActualizado) {
        Vuelo vueloExistente = vueloRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "Vuelo no encontrado con id " + id));

        vueloExistente.setOrigen(vueloActualizado.getOrigen());
        vueloExistente.setDestino(vueloActualizado.getDestino());
        vueloExistente.setFechaHora(vueloActualizado.getFechaHora());
        vueloExistente.setEstado(vueloActualizado.getEstado());

        return vueloRepository.save(vueloExistente);
    }

    // DELETE
    public boolean eliminarVuelo(Long id) {
        if (!vueloRepository.existsById(id)) {
            throw new RecursoNoEncontradoException(
                    "Vuelo no encontrado con id " + id);
        }

        vueloRepository.deleteById(id);
        return true;
    }
}
