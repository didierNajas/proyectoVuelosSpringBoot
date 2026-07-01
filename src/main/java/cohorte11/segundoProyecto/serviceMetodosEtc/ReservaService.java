package cohorte11.segundoProyecto.serviceMetodosEtc;

import cohorte11.segundoProyecto.DTO.ReservaRequestDTO;
import cohorte11.segundoProyecto.DTO.ReservaResponseDTO;
import cohorte11.segundoProyecto.modelEntidades.Pasajero;
import cohorte11.segundoProyecto.modelEntidades.Reserva;
import cohorte11.segundoProyecto.modelEntidades.Vuelo;
import cohorte11.segundoProyecto.repositoryComunicacion.PasajeroRepository;
import cohorte11.segundoProyecto.repositoryComunicacion.ReservaRepository;
import cohorte11.segundoProyecto.repositoryComunicacion.VueloRepository;
import cohorte11.segundoProyecto.web.error.RecursoNoEncontradoException;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {

    private final ReservaRepository reservaRepository;
    private final PasajeroRepository pasajeroRepository;
    private final VueloRepository vueloRepository;

    public ReservaService(
            ReservaRepository reservaRepository,
            PasajeroRepository pasajeroRepository,
            VueloRepository vueloRepository) {

        this.reservaRepository = reservaRepository;
        this.pasajeroRepository = pasajeroRepository;
        this.vueloRepository = vueloRepository;
    }

    public ReservaResponseDTO crearReserva(ReservaRequestDTO dto) {

        Pasajero pasajero = pasajeroRepository.findById(dto.getPasajeroId())
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "Pasajero no encontrado con id " + dto.getPasajeroId()));

        Vuelo vuelo = vueloRepository.findById(dto.getVueloId())
                .orElseThrow(() -> new RecursoNoEncontradoException(
                        "Vuelo no encontrado con id " + dto.getVueloId()));

        Reserva reserva = new Reserva();

        reserva.setPasajero(pasajero);
        reserva.setVuelo(vuelo);
        reserva.setClaseAsiento(dto.getClaseAsiento());

        Reserva reservaGuardada = reservaRepository.save(reserva);

        ReservaResponseDTO response = new ReservaResponseDTO();

        response.setReservaId(reservaGuardada.getId());
        response.setNombrePasajero(
                reservaGuardada.getPasajero().getNombre());

        response.setOrigenVuelo(
                reservaGuardada.getVuelo().getOrigen());

        response.setDestinoVuelo(
                reservaGuardada.getVuelo().getDestino());

        response.setClaseAsiento(
                reservaGuardada.getClaseAsiento());

        return response;
    }
}
