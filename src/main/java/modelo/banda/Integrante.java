package modelo.banda;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Clase Integrante que a su vez es la puerta de entrada de instrumentos
 */
public class Integrante {

    private String cedula;
    private String nombre;
    private Rol rol;
    private List<Instrumento> instrumentos;

    public Integrante(String cedula, String nombre, Rol rol) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.rol = rol;
        this.instrumentos = new ArrayList<>();
    }

    public void agregarInstrumento(Instrumento instrumento) {
        instrumentos.add(instrumento);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Integrante that = (Integrante) o;
        return Objects.equals(cedula, that.cedula) && Objects.equals(nombre, that.nombre) && rol == that.rol && Objects.equals(instrumentos, that.instrumentos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cedula);
    }

    /**
     * Arma toda la información del integrante incluyendo los instrumentos que toca
     * Si no toca ningún instrumento, por ejemplo, por que es el manager, el campo instrumentos saldrá vacío
     */
    @Override
    public String toString() {
        StringBuilder strInstrumentos = new StringBuilder("{  ");
        for (Instrumento i: this.instrumentos) {
            strInstrumentos.append(i).append("  ");
        }
        strInstrumentos.append("}");
        return "\nCédula: " + cedula +
                " - Nombre: " + nombre +
                " - Rol: " + rol +
                " - Instrumentos: " + strInstrumentos;
    }
}
