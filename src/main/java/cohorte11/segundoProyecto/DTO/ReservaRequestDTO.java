package cohorte11.segundoProyecto.DTO;

import cohorte11.segundoProyecto.modelEntidades.ClaseAsiento;

public class ReservaRequestDTO {

    private Long pasajeroId;

    private Long vueloId;

    private ClaseAsiento claseAsiento;

    public ReservaRequestDTO() {
    }

    public Long getPasajeroId() {
        return pasajeroId;
    }

    public void setPasajeroId(Long pasajeroId) {
        this.pasajeroId = pasajeroId;
    }

    public Long getVueloId() {
        return vueloId;
    }

    public void setVueloId(Long vueloId) {
        this.vueloId = vueloId;
    }

    public ClaseAsiento getClaseAsiento() {
        return claseAsiento;
    }

    public void setClaseAsiento(ClaseAsiento claseAsiento) {
        this.claseAsiento = claseAsiento;
    }
}
