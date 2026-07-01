package cohorte11.segundoProyecto.controllerEndPoint;

import cohorte11.segundoProyecto.modelEntidades.Pasajero;
import cohorte11.segundoProyecto.serviceMetodosEtc.PasajeroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pasajeros")
public class PasajeroController {

    private final PasajeroService pasajeroService;

    public PasajeroController(PasajeroService pasajeroService)
    {
        this.pasajeroService = pasajeroService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Pasajero> crearPasajero(@Valid@RequestBody Pasajero pasajero)
    {

        Pasajero nuevoPasajero = pasajeroService.guardarPasajero(pasajero);

        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoPasajero);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<Pasajero>> obtenerPasajeros()
    {

        return ResponseEntity.ok(pasajeroService.obtenerPasajeros());
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<Pasajero> obtenerPasajeroPorId(@PathVariable Long id)
    {

        Optional<Pasajero> pasajero = pasajeroService.obtenerPasajeroPorId(id);

        return pasajero.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Pasajero> actualizarPasajero(@PathVariable Long id, @Valid @RequestBody Pasajero pasajero)
    {

        Pasajero pasajeroActualizado =
                pasajeroService.actualizarPasajero(id, pasajero);

        return ResponseEntity.ok(pasajeroActualizado);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPasajero(@PathVariable Long id)
    {

        pasajeroService.eliminarPasajero(id);

        return ResponseEntity.noContent().build();
    }
}
