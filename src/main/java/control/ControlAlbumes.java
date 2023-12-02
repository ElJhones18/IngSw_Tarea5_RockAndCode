package control;

import excepciones.AlbumException;
import modelo.musica.Album;
import modelo.musica.Cancion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ControlAlbumes {

    private List<Album> albumes = new ArrayList<>();

    /**
     * Agrega un album a la lista de albumes lanzados por la banda, verificando que no se haya lanzado ya
     * Se verífica también con la fecha, ya que en ocasiones se lanzan versiones nuevas del mismo album
     * @throws AlbumException cuando ya se ha lanzado el album
     */
    public void lanzarAlbum(String nombre, LocalDate fechaLanzamiento) {
        if (buscarAlbum(nombre) != null) {
            throw new AlbumException("El album ya se ha lanzado");
        }

        albumes.add(new Album(nombre, fechaLanzamiento));
    }

    /**
     * Busca un album por su nombre
     * @return el album encontrado, o null si no se encuentra lanzado
     */
    public Album buscarAlbum(String nombre) {
        for (Album a: albumes) {
            if (Objects.equals(a.getNombre(), nombre)) {
                return a;
            }
        }
        return null;
    }

    /**
     * Se agrega una lista de canciones a un album
     * @param nombreAlbum nombre del album al que se agregarán las canciones
     * @throws AlbumException cuando no se encuentra el album al que se le quieren añadir las canciones
     */
    public void agregarCanciones(String nombreAlbum, List<Cancion> canciones) {
        Album album = buscarAlbum(nombreAlbum);
        if (album == null) {
            throw new AlbumException("El album no existe");
        }

        for (Cancion cancion:canciones) {
            album.agregarCancion(cancion);
        }
    }

    /**
     * Devuelve un String con la información de las canciones del album ingresado como parámetro
     * En caso de que no exista el album, devuelve una cadena para mostrar por pantalla que no se ha lanzado dicho album
     * @return la cadena con las canciones, que viene del método getCanciones del album encontrado
     */
    public String obtenerCanciones(String nombreAlbum) {
        if (buscarAlbum(nombreAlbum) == null) {
            return "No se ha lanzado el album" + nombreAlbum;
        }
        return buscarAlbum(nombreAlbum).getCanciones();
    }
}
