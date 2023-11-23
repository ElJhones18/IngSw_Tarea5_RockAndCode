package vista;

import control.ControlBanda;
import control.ControlIntegrantes;
import modelo.banda.Instrumento;
import modelo.banda.Rol;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class VentanaBanda {

    ControlBanda controlBanda = new ControlBanda();
    ControlIntegrantes controlIntegrantes = new ControlIntegrantes();

    // funcionalidades

    public void registrarInformacion() {
        String mensaje = "Ingrese el genero musical actual de Rock & Code";
        controlBanda.registrarInformacion(leerString(mensaje), leerFecha(), leerFotos());
    }

    public void actualizarInformacion() {
        String mensaje = "Ingrese el genero musical actual de Rock & Code";
        controlBanda.actualizarInformacion(leerString(mensaje));

    }

    public void agregarMiembros() {
        String cedula = "Ingrese la cédula";
        String nombre = "Ingrese el nombre";
        controlIntegrantes.agregarIntegrante(leerString(cedula), leerString(nombre), leerRol());

        controlIntegrantes.agregarInstrumentos(leerInstrumentos());
    }

    public void eliminarMiembro() {
        String mensaje = "Ingrese la cédula del integrante a borrar";
        controlIntegrantes.eliminarIntegrante(leerString(mensaje));
    }

    public void mostrarInformacion() {
        System.out.println(controlBanda.obtenerInformacion());
        System.out.println(controlIntegrantes.obtenerInformacion());
    }


    // lectura de datos

    private String leerString(String mensaje) {
        Scanner sc = new Scanner(System.in);
        System.out.println(mensaje);
        return sc.next();
    }

    private List<Instrumento> leerInstrumentos() {
        boolean salir = false;
        List<Instrumento> instrumentos = new ArrayList<>();
        while (!salir) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Escoja el instrumento a agregar (0 para terminar): ");
            boolean valido = false;
            while (!valido) {
                for (Instrumento instrumentoEnum : Instrumento.values()) {
                    System.out.println(" - " + instrumentoEnum);
                }
                String instrumentoStr = sc.next();
                try {
                    if (instrumentoStr.equals("0")) {
                        salir = true;
                    } else {
                        instrumentos.add(Instrumento.valueOf(instrumentoStr.toUpperCase()));
                    }
                    valido = true;
                } catch (IllegalArgumentException e) {
                    System.err.println("Vuelva a intentarlo");
                }

            }
        }
        return instrumentos;
    }

    private Rol leerRol() {
        boolean valido = false;
        Rol rol = null;
        while (!valido) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Escoja el rol: ");
            for (Rol rolEnum: Rol.values()) {
                System.out.println(" - " + rolEnum);
            }
            String rolStr = sc.next();
            try {
                rol = Rol.valueOf(rolStr.toUpperCase());
                valido = true;
            } catch (IllegalArgumentException e) {
                System.err.println("Vuelva a intentarlo");
            }

        }
        return rol;
    }

    private List<String> leerFotos() {
        Scanner sc = new Scanner(System.in);
        List<String> rutas = new ArrayList<>();
        String opcion;
        boolean salir = false;
        while (!salir) {
            System.out.println("Ingrese la ruta de una foto a agregar (0 para terminar)");
            opcion = sc.next();
            if (opcion.equals("0")) {
                salir = true;
            }
            rutas.add(opcion);
        }
        return rutas;
    }

    private LocalDate leerFecha() {
        System.out.println("Ingrese la fecha de creacion de Rock & Code");
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



}
