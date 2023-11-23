package control;

import excepciones.ConciertoException;
import modelo.musica.Concierto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ControlConciertos {
    private List<Concierto> conciertos = new ArrayList<>();

    public void programarConcierto(String nombre, String lugar, LocalDate fecha, int hora, int capacidad) {
        if (buscarConcierto(nombre, fecha) != null) {
            throw new ConciertoException("El concierto ya existe");
        }
        conciertos.add(new Concierto(nombre, lugar, fecha, hora, capacidad));
    }

    public Concierto buscarConcierto(String nombre, LocalDate fecha) {
        for (Concierto c: conciertos) {
            if (Objects.equals(c.getNombre(), nombre) && c.getFecha() == fecha) {
                return c;
            }
        }
        return null;
    }

    public String obtenerInformacionConciertos() {
        StringBuilder strConciertos = new StringBuilder();
        for (Concierto c: conciertos) {
            strConciertos.append(c.toString()).append("\n");
        }
        return "\nConciertos realizados por Rock & Code: " + strConciertos;
    }
}
