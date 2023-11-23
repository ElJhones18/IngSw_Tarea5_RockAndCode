package modelo.banda;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InfoBanda {

    private String genero;
    private LocalDate fechaCreacion;
    private List<Foto> fotos;


    public InfoBanda(String genero, LocalDate fechaCreacion) {
        this.genero = genero;
        this.fechaCreacion = fechaCreacion;
        this.fotos = new ArrayList<>();
    }

    public void agregarFoto(String ruta) {
        fotos.add(new Foto(ruta));
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    @Override
    public String toString() {
        StringBuilder fotosSB;
        fotosSB = new StringBuilder();
        for (Foto foto: fotos) {
            fotosSB.append("\n - ").append(foto.getRuta());
        }
        return "Rock & Code" +
                "\nGenero: " + genero +
                "\nFecha de creación: " + fechaCreacion +
                "\nFotos: " + fotosSB;
    }
}
