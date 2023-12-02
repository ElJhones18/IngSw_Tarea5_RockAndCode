package control;

import excepciones.IntegranteException;
import modelo.banda.Rol;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControlIntegrantesTest {

    private ControlIntegrantes control;

    @BeforeEach
    void setUp() {
        control = new ControlIntegrantes();
    }

    @Test
    void agregarIntegrante() {
        assertDoesNotThrow(() -> control.agregarIntegrante("1234567890", "Seider", Rol.BAJISTA));
    }

    @Test
    void agregarIntegranteRepetido() {
        control.agregarIntegrante("123", "Seider", Rol.BAJISTA);
        assertThrows(IntegranteException.class, () -> control.agregarIntegrante("123", "Seider", Rol.BAJISTA));
    }

    @Test
    void buscarIntegrante() {
        control.agregarIntegrante("123", "Seider", Rol.BAJISTA);
        assertTrue(control.buscarIntegrante("123"));
    }

    @Test
    void buscarIntegranteNoExistente() {
        control.agregarIntegrante("123", "Seider", Rol.BAJISTA);
        assertFalse(control.buscarIntegrante("1234"));
    }

    @Test
    void eliminarIntegrante() {
        control.agregarIntegrante("123", "Seider", Rol.BAJISTA);
        assertDoesNotThrow( () -> control.eliminarIntegrante("123"));
    }

    @Test
    void eliminarIntegranteNoExistente() {
        control.agregarIntegrante("123", "Seider", Rol.BAJISTA);
        assertThrows(IntegranteException.class, () -> control.eliminarIntegrante("1234"));
    }
}