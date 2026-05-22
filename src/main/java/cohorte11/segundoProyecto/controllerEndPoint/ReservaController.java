package cohorte11.segundoProyecto.controllerEndPoint;

import cohorte11.segundoProyecto.DTO.ReservaRequestDTO;
import cohorte11.segundoProyecto.DTO.ReservaResponseDTO;
import cohorte11.segundoProyecto.serviceMetodosEtc.ReservaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaService reservaService;

    public ReservaController(ReservaService reservaService) {
        this.reservaService = reservaService;
    }

    @PostMapping
    public ResponseEntity<ReservaResponseDTO> crearReserva(
            @Valid @RequestBody ReservaRequestDTO dto) {

        ReservaResponseDTO response =
                reservaService.crearReserva(dto);

        if (response == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }
}
