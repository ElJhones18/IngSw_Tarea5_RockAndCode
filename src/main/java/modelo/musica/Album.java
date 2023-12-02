package modelo.musica;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase Album que también es la entrada a la clase Canción
 */
public class Album {

    private String nombre;
    private LocalDate fechaLanzamiento;
    private List<Cancion> canciones;

    public Album(String nombre, LocalDate fechaLanzamiento) {
        this.nombre = nombre;
        this.fechaLanzamiento = fechaLanzamiento;
        this.canciones = new ArrayList<>();
    }

    public void agregarCancion(Cancion cancion) {
        this.canciones.add(cancion);
    }

    /**
     * Arma un String con la información de las canciones del album, esta información viene del método toString de Canción
     */
    public String getCanciones() {
        StringBuilder cancionesStr = new StringBuilder();
        for (Cancion c: canciones) {
            cancionesStr.append(c.toString());
        }
        return nombre + ":\n" + cancionesStr;
    }

    public String getNombre() {
        return nombre;
    }
}
