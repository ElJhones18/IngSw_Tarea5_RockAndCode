package vista;

import control.ControlAlbumes;
import modelo.musica.Cancion;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class VentanaAlbumes {
    private ControlAlbumes controlAlbumes = new ControlAlbumes();

    // funcionalidades
    public void lanzarAlbum() {
        controlAlbumes.lanzarAlbum(leerNomAlbum(), leerFecha());
    }

    public void agregarCanciones() {
        controlAlbumes.agregarCanciones(leerNomAlbum(), leerCanciones());
    }

    public void consultarCanciones() {
        System.out.println(controlAlbumes.obtenerCanciones(leerNomAlbum()));
    }

    // lectura de datos
    private String leerNomAlbum() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del album: ");
        return sc.next();
    }

    private LocalDate leerFecha() {
        System.out.println("Ingrese la fecha de lanzamiento del Album");
        int ano = 0;
        int mes = 0;
        int dia = 0;
        boolean valido = false;
        while(!valido) {
            try  {
                Scanner sc = new Scanner(System.in);
                System.out.println("Año: ");
                ano = sc.nextInt();
                System.out.println("Mes: ");
                mes = sc.nextInt();
                System.out.println("Dia: ");
                dia = sc.nextInt();

                if ((mes > 12 || mes < 1) || (dia < 1 || dia > 31)) {
                    System.err.println("Ingrese el mes o dia en el rango correcto.");
                } else {
                    valido = true;
                }

            } catch (NoSuchElementException e) {
                System.err.println("Por favor ingrese elementos válidos");
            } catch (DateTimeException dateException) {
                System.err.println("Verifique el rango de días del més ingresado.");
            }
        }
        return LocalDate.of(ano, mes, dia);
    }

    private List<Cancion> leerCanciones() {
        boolean salir = false;
        List<Cancion> canciones = new ArrayList<>();
        while (!salir) {
            try {

                Scanner sc = new Scanner(System.in);
                System.out.println("Ingrese el nombre de la cancion a agregar (0 para terminar): ");
                String nombreCancion = sc.next();

                if (nombreCancion.equals("0")) {
                    salir = true;
                } else {

                    System.out.println("Ingrese la duracion en segundos: ");
                    int duracion = sc.nextInt();
                    Cancion c = new Cancion(nombreCancion, duracion);
                    canciones.add(c);

                }

            } catch (NoSuchElementException e) {
                System.err.println("Se canceló la inserción de esta cancion, por favor ingrese un número entero");
            }

        }
        return canciones;
    }
}
