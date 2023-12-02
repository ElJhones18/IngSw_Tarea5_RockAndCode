package control;

import excepciones.ConciertoException;
import modelo.musica.Concierto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ControlConciertosTest {

    private ControlConciertos control;

    @BeforeEach
    void setUp() {
        control = new ControlConciertos();
    }

    @Test
    void programarConcierto() {
        LocalDate fecha = LocalDate.of(2022, 12, 12);

        assertDoesNotThrow(() -> control.programarConcierto("HellFest", "California", fecha, 20, 1000));
    }

    @Test
    void programarConciertoExistente() {
        LocalDate fecha = LocalDate.of(2022, 12, 12);
        control.programarConcierto("HellFest", "California", fecha, 20, 1000);
        assertThrows(ConciertoException.class, () -> control.programarConcierto("HellFest", "California", fecha, 20, 1000));
    }

    @Test
    void buscarConcierto() {
        LocalDate fecha = LocalDate.of(2022, 12, 12);
        String nombre = "HellFest";
        control.programarConcierto(nombre, "California", fecha, 20, 1000);

        assertInstanceOf(Concierto.class, control.buscarConcierto(nombre, fecha));
    }

    @Test
    void buscarConciertoNoExistente() {
        LocalDate fecha = LocalDate.of(2022, 12, 12);

        assertNull(control.buscarConcierto("prueba", fecha));
    }

}