package control;

import excepciones.BandaException;
import modelo.banda.InfoBanda;

import java.time.LocalDate;
import java.util.List;

public class ControlBanda {
    private InfoBanda banda;

    /**
     * Registra la información de la banda por primera vez, si ya se ha registrado, solo se podrá actualizar
     * También se usa el método agregarFotos para añadir rutas de fotos a la información de la banda
     * @param rutas rutas de las fotos de la banda
     */
    public void registrarInformacion(String genero, LocalDate fechaCreacion, List<String> rutas) {
        if (this.banda != null) {
            throw new BandaException("La banda ya tiene informacion registrada, prueba a actualizar informacion.");
        }
        banda = new InfoBanda(genero, fechaCreacion);
        agregarFotos(rutas);
    }

    /**
     * Actualiza la información, verificando que ya se haya registrado
     * @param genero género nuevo de la banda, no se pide fecha de creacion, ya que esto solo se puede hacer una vez en la vida
     * @throws BandaException cuando no se ha registrado información
     */
    public void actualizarInformacion(String genero) {
        if (this.banda == null) {
            throw new BandaException("No se puede actualizar por que no se ha registrado informacion");
        }
        banda.setGenero(genero);

    }

    /**
     * Devuelve el toString de la información de la banda
     */
    public String obtenerInformacion() {
        if (banda == null) {
            return "No se ha registrado informacion de Rock & Code";
        }
        return banda.toString();
    }

    /**
     * Añade a la información de la banda una lista de rutas de fotos
     */
    private void agregarFotos(List<String> rutas) {
        for (String foto: rutas) {
            banda.agregarFoto(foto);
        }
    }

}
