package control;

import excepciones.BandaException;
import modelo.banda.InfoBanda;

import java.time.LocalDate;
import java.util.List;

public class ControlBanda {
    private InfoBanda banda;

    public void registrarInformacion(String genero, LocalDate fechaCreacion, List<String> rutas) {
        if (this.banda != null) {
            throw new BandaException("La banda ya tiene informacion registrada, prueba a actualizar informacion.");
        }
        banda = new InfoBanda(genero, fechaCreacion);
        agregarFotos(rutas);
    }

    public void actualizarInformacion(String genero) {
        if (this.banda == null) {
            throw new BandaException("No se puede actualizar por que no se ha registrado informacion");
        }
        banda.setGenero(genero);

    }

    public String obtenerInformacion() {
        if (banda == null) {
            return "No se ha registrado informacion de Rock & Code";
        }
        return banda.toString();
    }

    private void agregarFotos(List<String> rutas) {
        for (String foto: rutas) {
            banda.agregarFoto(foto);
        }
    }

}
