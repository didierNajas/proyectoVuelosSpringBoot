package cohorte11.segundoProyecto.DTO;

import cohorte11.segundoProyecto.modelEntidades.ClaseAsiento;
import jakarta.validation.constraints.NotBlank;

public class ReservaResponseDTO {

    private Long reservaId;

    @NotBlank
    private String nombrePasajero;
    @NotBlank
    private String origenVuelo;
    @NotBlank
    private String destinoVuelo;
    @NotBlank
    private ClaseAsiento claseAsiento;

    public ReservaResponseDTO() {
    }

    public Long getReservaId() {
        return reservaId;
    }

    public void setReservaId(Long reservaId) {
        this.reservaId = reservaId;
    }

    public String getNombrePasajero() {
        return nombrePasajero;
    }

    public void setNombrePasajero(String nombrePasajero) {
        this.nombrePasajero = nombrePasajero;
    }

    public String getOrigenVuelo() {
        return origenVuelo;
    }

    public void setOrigenVuelo(String origenVuelo) {
        this.origenVuelo = origenVuelo;
    }

    public String getDestinoVuelo() {
        return destinoVuelo;
    }

    public void setDestinoVuelo(String destinoVuelo) {
        this.destinoVuelo = destinoVuelo;
    }

    public ClaseAsiento getClaseAsiento() {
        return claseAsiento;
    }

    public void setClaseAsiento(ClaseAsiento claseAsiento) {
        this.claseAsiento = claseAsiento;
    }
}
