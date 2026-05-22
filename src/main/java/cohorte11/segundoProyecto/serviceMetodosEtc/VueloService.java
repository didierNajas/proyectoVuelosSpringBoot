package cohorte11.segundoProyecto.serviceMetodosEtc;

import cohorte11.segundoProyecto.modelEntidades.Vuelo;
import cohorte11.segundoProyecto.repositoryComunicacion.VueloRepository;
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

        Vuelo vueloExistente = vueloRepository.findById(id).orElse(null);

        if (vueloExistente != null) {

            vueloExistente.setOrigen(vueloActualizado.getOrigen());
            vueloExistente.setDestino(vueloActualizado.getDestino());
            vueloExistente.setFechaHora(vueloActualizado.getFechaHora());

            return vueloRepository.save(vueloExistente);
        }

        return null;
    }

    // DELETE
    public boolean eliminarVuelo(Long id) {

        if (vueloRepository.existsById(id)) {
            vueloRepository.deleteById(id);
            return true;
        }

        return false;
    }
}
