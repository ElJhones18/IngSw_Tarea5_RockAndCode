package control;

import excepciones.IntegranteException;
import modelo.banda.Instrumento;
import modelo.banda.Integrante;
import modelo.banda.Rol;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControlIntegrantes {

    private Map<String, Integrante> integrantes = new HashMap<>();
    private Integrante integranteActual;

    // métodos

    public void agregarIntegrante(String cedula, String nombre, Rol rol) {
        if (buscarIntegrante(cedula)) {
            throw new IntegranteException("El Integrante con la cedula " + cedula + " ya es parte de la banda.");
        }
        integranteActual = new Integrante(cedula, nombre, rol);
        integrantes.put(cedula, integranteActual);
    }

    public boolean buscarIntegrante(String cedula) {
        Integrante i = integrantes.get(cedula);
        return i != null;
    }

    public void agregarInstrumentos(List<Instrumento> instrumentos) {
        for (Instrumento i: instrumentos) {
            integranteActual.agregarInstrumento(i);
        }
    }

    public void eliminarIntegrante(String cedula) {
        if (!buscarIntegrante(cedula)) {
            throw new IntegranteException("El integrante no existe");
        }
        integrantes.remove(cedula);
    }

    public String obtenerInformacion() {
        StringBuilder strIntegrantes = new StringBuilder();
        for (Integrante i: integrantes.values()) {
            strIntegrantes.append(i.toString()).append("\n");
        }
        return "\nIntegrantes actuales de Rock & Code: " + strIntegrantes;
    }

}
