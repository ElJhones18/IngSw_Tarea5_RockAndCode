package control;

import excepciones.ConciertoException;
import modelo.musica.Concierto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ControlConciertos {
    private List<Concierto> conciertos = new ArrayList<>();

    /**
     * Crea un nuevo concierto con los parámetros entrantes, si el concierto ya existe, lanza excepción
     * @throws ConciertoException cuando el concierto ya existe
     */
    public void programarConcierto(String nombre, String lugar, LocalDate fecha, int hora, int capacidad) {
        if (buscarConcierto(nombre, fecha) != null) {
            throw new ConciertoException("El concierto ya existe");
        }
        conciertos.add(new Concierto(nombre, lugar, fecha, hora, capacidad));
    }

    /**
     * Busca un concierto por su nombre y fecha, esto por que puede haber un mismo concierto pero en fechas diferentes
     * por ejemplo: HellFest 2022 y HellFest 2023
     * @return Null si no se encuentra, o el concierto encontrado
     */
    public Concierto buscarConcierto(String nombre, LocalDate fecha) {
        for (Concierto c: conciertos) {
            if (Objects.equals(c.getNombre(), nombre) && c.getFecha() == fecha) {
                return c;
            }
        }
        return null;
    }

    /**
     * Arma un String con todos los conciertos realizados por la banda, la información de cada uno
     * viene del método toString del concierto
     */
    public String obtenerInformacionConciertos() {
        StringBuilder strConciertos = new StringBuilder();
        for (Concierto c: conciertos) {
            strConciertos.append(c.toString()).append("\n");
        }
        return "\nConciertos realizados por Rock & Code: " + strConciertos;
    }
}
