package modelo.musica;

public class Cancion {

    private String nombre;
    private int duracion;


    public Cancion(String nombre, int duracion) {
        this.nombre = nombre;
        this.duracion = duracion;
    }


    @Override
    public String toString() {
        return "\nNombre: " + nombre + " - Duracion(segundos): " + duracion;
    }
}
