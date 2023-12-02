package control;


import excepciones.BandaException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ControlBandaTest {

    private ControlBanda control;

    @BeforeEach
    void setUp() {
        control = new ControlBanda();
    }

    @Test
    void registrarInfo() {
        LocalDate fechaCreacion = LocalDate.of(2000, 12, 12);
        List<String> fotos = new ArrayList<>();
        fotos.add("foto1");
        fotos.add("foto2");

        assertDoesNotThrow(() -> control.registrarInformacion("Metal", fechaCreacion, fotos));
    }

    @Test
    void registrarInfoDosVeces() {
        LocalDate fechaCreacion = LocalDate.of(2000, 12, 12);
        List<String> fotos = new ArrayList<>();
        fotos.add("foto1");
        fotos.add("foto2");

        control.registrarInformacion("Metal", fechaCreacion, fotos);

        assertThrows(BandaException.class, () -> control.registrarInformacion("Metal", fechaCreacion, fotos));
    }

    @Test
    void actualizarInfo() {
        LocalDate fechaCreacion = LocalDate.of(2000, 12, 12);
        List<String> fotos = new ArrayList<>();
        fotos.add("foto1");
        fotos.add("foto2");

        control.registrarInformacion("Metal", fechaCreacion, fotos);

        assertDoesNotThrow(() -> control.actualizarInformacion("Rock"));
    }

    @Test
    void actualizarInfoSinRegistrarAntes() {
        assertThrows(BandaException.class, () -> control.actualizarInformacion("Rock"));
    }

    @Test
    void obtenerInfoSinRegistrarInfo() {
        String resultado = control.obtenerInformacion();
        assertEquals("No se ha registrado informacion de Rock & Code", resultado);
    }
}