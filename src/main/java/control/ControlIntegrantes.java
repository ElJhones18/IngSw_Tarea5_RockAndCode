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
    /**
     * Integrante que se procesa en el momento de agregarlo, útil para posteriormente agregar sus instrumentos
     */
    private Integrante integranteActual;

    // métodos

    /**
     * Agrega un nuevo integrante a la banda. verificando que no exista
     * @param rol rol del nuevo integrante, viene de una Enumeration
     * @throws IntegranteException cuando ya existe el integrante
     */
    public void agregarIntegrante(String cedula, String nombre, Rol rol) {
        if (buscarIntegrante(cedula)) {
            throw new IntegranteException("El Integrante con la cedula " + cedula + " ya es parte de la banda.");
        }
        integranteActual = new Integrante(cedula, nombre, rol);
        integrantes.put(cedula, integranteActual);
    }

    /**
     * Busca si un integrante se encuentra en la banda
     * @param cedula cedula del integrante a buscar
     * @return true si el integrante existe, false en caso contrario
     */
    public boolean buscarIntegrante(String cedula) {
        Integrante i = integrantes.get(cedula);
        return i != null;
    }

    /**
     * Agrega al integrante actual una lista de instrumentos que sabe tocar
     * Los instrumentos son de una enumeración
     * @param instrumentos lista de instrumentos a agregar
     */
    public void agregarInstrumentos(List<Instrumento> instrumentos) {
        for (Instrumento i: instrumentos) {
            integranteActual.agregarInstrumento(i);
        }
    }

    /**
     * Elimina un integrante de la banda, verificando que este exista
     * @param cedula cedula del integrante a eliminar
     */
    public void eliminarIntegrante(String cedula) {
        if (!buscarIntegrante(cedula)) {
            throw new IntegranteException("El integrante no existe");
        }
        integrantes.remove(cedula);
    }

    /**
     * Arma un string con la información de los integrantes de la banda
     * Si no existen integrantes, se mostrará
     * "Integrantes actuales de Rock and Code:
     * "
     * @return la cadena con la información lista para mostrar al usuario
     */
    public String obtenerInformacion() {
        StringBuilder strIntegrantes = new StringBuilder();
        for (Integrante i: integrantes.values()) {
            strIntegrantes.append(i.toString()).append("\n");
        }
        return "\nIntegrantes actuales de Rock & Code: " + strIntegrantes;
    }

}
