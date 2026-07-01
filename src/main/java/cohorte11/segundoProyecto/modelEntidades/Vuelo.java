package cohorte11.segundoProyecto.modelEntidades;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name= "aerolinea")
public class Vuelo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank
    private String origen;
    @NotBlank
    private String destino;
    @NotNull
    @Column(nullable = false)
    private LocalDateTime fechaHora;

    @Enumerated(EnumType.STRING)
    @NotNull
    private EstadoVuelo estado;

    public Vuelo()
    {
    }

    public Vuelo(Long id, String origen, String destino, LocalDateTime fechaHora, EstadoVuelo estado)
    {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.fechaHora = fechaHora;
        this.estado = estado;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getOrigen()
    {
        return origen;
    }

    public void setOrigen(String origen)
    {
        this.origen = origen;
    }

    public String getDestino()
    {
        return destino;
    }

    public void setDestino(String destino)
    {
        this.destino = destino;
    }

    public LocalDateTime getFechaHora()
    {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora)
    {
        this.fechaHora = fechaHora;
    }

    public EstadoVuelo getEstado()
    {
        return estado;
    }

    public void setEstado(EstadoVuelo estado)
    {
        this.estado = estado;
    }
}
