package modelo.musica;

import java.time.LocalDate;

public class Concierto {
    private String nombre;
    private String lugar;
    private LocalDate fecha;
    private int hora;
    private int capacidad;


    public Concierto(String nombre, String lugar, LocalDate fecha, int hora, int capacidad) {
        this.nombre = nombre;
        this.lugar = lugar;
        this.fecha = fecha;
        this.hora = hora;
        this.capacidad = capacidad;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "\nnombre: " + nombre +
                " - lugar: " + lugar +
                " - fecha: " + fecha +
                " - hora: " + hora +
                " - capacidad: " + capacidad;
    }
}
