package control;

import excepciones.AlbumException;
import modelo.musica.Album;
import modelo.musica.Cancion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ControlAlbumesTest {

    private ControlAlbumes control;

    @BeforeEach
    void setUp() {
        control = new ControlAlbumes();
    }

    @Test
    void lanzarAlbum() {
        LocalDate fecha = LocalDate.of(2022, 12, 12);
        assertDoesNotThrow(() -> control.lanzarAlbum("Ocean Planet", fecha));
    }

    @Test
    void lanzarAlbumRepetido() {
        LocalDate fecha = LocalDate.of(2022, 12, 12);
        control.lanzarAlbum("Ocean Planet", fecha);
        assertThrows(AlbumException.class, () -> control.lanzarAlbum("Ocean Planet", fecha));
    }

    @Test
    void buscarAlbum() {
        LocalDate fecha = LocalDate.of(2022, 12, 12);
        control.lanzarAlbum("Ocean Planet", fecha);
        assertInstanceOf(Album.class, control.buscarAlbum("Ocean Planet"));
    }

    @Test
    void buscarAlbumNoExistente() {
        assertNull(control.buscarAlbum("Ocean Planet"));
    }

    @Test
    void obtenerCancionesSinAgregarlas() {
        String nombreAlbum = "Ocean Planet";
        assertEquals("No se ha lanzado el album" + nombreAlbum, control.obtenerCanciones(nombreAlbum));
    }

    @Test
    void agregarCanciones() {
        LocalDate fecha = LocalDate.of(2022, 12, 12);
        control.lanzarAlbum("Ocean Planet", fecha);

        List<Cancion> canciones = new ArrayList<>();
        canciones.add(new Cancion("Flying Whales", 120));
        canciones.add(new Cancion("From the Sky", 200));

        assertDoesNotThrow(()-> control.agregarCanciones("Ocean Planet", canciones));
    }

    @Test
    void agregarCancionesAAlbumNoExistente() {
        LocalDate fecha = LocalDate.of(2022, 12, 12);
        control.lanzarAlbum("Ocean Planet", fecha);

        List<Cancion> canciones = new ArrayList<>();
        canciones.add(new Cancion("Flying Whales", 120));
        canciones.add(new Cancion("From the Sky", 200));

        assertThrows(AlbumException.class, ()-> control.agregarCanciones("prueba", canciones));
    }
}