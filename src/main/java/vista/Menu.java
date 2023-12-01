package vista;

import java.util.Scanner;

public class Menu {

    private VentanaBanda ventanaBanda;
    private VentanaAlbumes ventanaAlbumes;
    private VentanaConciertos ventanaConciertos;

    public void start() {
        ventanaBanda = new VentanaBanda();
        ventanaAlbumes = new VentanaAlbumes();
        ventanaConciertos = new VentanaConciertos();
        opciones();
    }

    /**
     * Menú principal con el usuario, aqui se exponen las funcionalidades del programa
     */
    public void opciones() {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;
        int opcion;

        while (!salir) {
            System.out.println("""
                    Bienvenido a Rock & Code
                    1 - Registrar información de la banda
                    2 - Actualizar información de la banda
                    3 - Agregar miembros a la banda
                    4 - Eliminar miembros de la banda
                    5 - Consultar información de la banda
                    6 - Lanzar un nuevo album
                    7 - Agregar canciones al album
                    8 - Consultar las canciones del album
                    9 - Programar un nuevo concierto
                    10 - Consultar conciertos realizados
                    0 - Salir
                    """);

            opcion = scanner.nextInt();
            switch (opcion) {
                case 0 -> {
                    salir = true;
                    System.out.println("Gracias por haber accedido hoy a Rock & Code. Hasta la próxima.");
                }
                case 1 -> ventanaBanda.registrarInformacion();
                case 2 -> ventanaBanda.actualizarInformacion();
                case 3 -> ventanaBanda.agregarMiembros();
                case 4 -> ventanaBanda.eliminarMiembro();
                case 5 -> ventanaBanda.mostrarInformacion();
                case 6 -> ventanaAlbumes.lanzarAlbum();
                case 7 -> ventanaAlbumes.agregarCanciones();
                case 8 -> ventanaAlbumes.consultarCanciones();
                case 9 -> ventanaConciertos.programarConcierto();
                case 10 -> ventanaConciertos.consultarConciertos();

                default -> System.out.println("Ingrese un número en dentro del rango");
            }
        }
    }

}
