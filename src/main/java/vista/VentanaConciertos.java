package vista;

import control.ControlConciertos;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class VentanaConciertos {
    private ControlConciertos controlConciertos = new ControlConciertos();

    // funcionalidades

    public void programarConcierto() {
        String nombre = "Ingrese el nombre del concierto";
        String lugar = "Ingrese el lugar del concierto";
        String capacidad = "Ingrese la capacidad del concierto";
        controlConciertos.programarConcierto(leerString(nombre), leerString(lugar), leerFecha(), leerHora(), leerEntero(capacidad));
    }

    public void consultarConciertos() {
        System.out.println(controlConciertos.obtenerInformacionConciertos());
    }

    // lectura de datos

    private String leerString(String mensaje) {
        Scanner sc = new Scanner(System.in);
        System.out.println(mensaje);
        return sc.next();
    }

    private int leerHora() {
        System.out.println("Ingrese la hora del concierto (formato 24HH)");
        int numero = 0;
        boolean valido = false;
        while (!valido) {
            try {
                Scanner sc = new Scanner(System.in);
                numero = sc.nextInt();

                if ((numero > 24 || numero < 1)) {
                    System.err.println("Ingrese la hora en el rango correcto.");
                } else {
                    valido = true;
                }
            } catch (NoSuchElementException e) {
                System.err.println("Ingrese un número entero por favor");
            }
        }

        return numero;
    }

    private int leerEntero(String mensaje) {
        System.out.println(mensaje);
        int numero = 0;
        boolean valido = false;
        while (!valido) {
            try {
                Scanner sc = new Scanner(System.in);
                numero = sc.nextInt();
                valido = true;
            } catch (NoSuchElementException e) {
                System.err.println("Ingrese un número entero por favor");
            }
        }

        return numero;
    }

    private LocalDate leerFecha() {
        System.out.println("Ingrese la fecha del concierto");
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
