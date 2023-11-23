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

    public void lanzarAlbum(String nombre, LocalDate fechaLanzamiento) {
        if (buscarAlbum(nombre) != null) {
            throw new AlbumException("El album ya se ha lanzado");
        }

        albumes.add(new Album(nombre, fechaLanzamiento));
    }

    public Album buscarAlbum(String nombre) {
        for (Album a: albumes) {
            if (Objects.equals(a.getNombre(), nombre)) {
                return a;
            }
        }
        return null;
    }

    public void agregarCanciones(String nombreAlbum, List<Cancion> canciones) {
        Album album = buscarAlbum(nombreAlbum);
        if (album == null) {
            throw new AlbumException("El album no existe");
        }

        for (Cancion cancion:canciones) {
            album.agregarCancion(cancion);
        }
    }

    public String obtenerCanciones(String nombreAlbum) {
        if (buscarAlbum(nombreAlbum) == null) {
            return "No se ha lanzado el album" + nombreAlbum;
        }
        return buscarAlbum(nombreAlbum).getCanciones();
    }
}
