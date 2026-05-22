package cohorte11.segundoProyecto.controllerEndPoint;

import cohorte11.segundoProyecto.modelEntidades.Vuelo;
import cohorte11.segundoProyecto.serviceMetodosEtc.VueloService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vuelos")
public class VueloController {

    private final VueloService vueloService;

    public VueloController(VueloService vueloService) {
        this.vueloService = vueloService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Vuelo> crearVuelo(@RequestBody Vuelo vuelo) {

        Vuelo nuevoVuelo = vueloService.guardarVuelo(vuelo);

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoVuelo);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Vuelo>> obtenerVuelos() {

        return ResponseEntity.ok(vueloService.obtenerVuelos());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Vuelo> obtenerVueloPorId(@PathVariable Long id) {

        Optional<Vuelo> vuelo = vueloService.obtenerVueloPorId(id);

        return vuelo.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Vuelo> actualizarVuelo(
            @PathVariable Long id,
            @Valid @RequestBody Vuelo vuelo) {

        Vuelo vueloActualizado = vueloService.actualizarVuelo(id, vuelo);

        if (vueloActualizado != null) {
            return ResponseEntity.ok(vueloActualizado);
        }

        return ResponseEntity.notFound().build();
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarVuelo(@PathVariable Long id) {

        boolean eliminado = vueloService.eliminarVuelo(id);

        if (eliminado) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }
}
