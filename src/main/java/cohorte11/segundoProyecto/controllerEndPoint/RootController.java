package cohorte11.segundoProyecto.controllerEndPoint;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RootController
{

    @GetMapping("/")
    public Map<String, Object> root()
    {
        return Map.of(
                "service", "Aerolinea API",
                "status", "ok",
                "endpoints", Map.of(
                        "pasajeros", "/pasajeros",
                        "vuelos", "/vuelos",
                        "reservas", "/reservas",
                        "swagger", "/swagger-ui/index.html"
                )
        );
    }
}
