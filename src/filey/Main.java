package filey;

import filey.datos.EstadoStand;
import filey.datos.Stand;
import filey.datos.StandRepositoryMemoria;
import filey.negocio.StandService;
import java.util.Scanner;

public class Main {
    private static final Scanner entrada = new Scanner(System.in);
    private static final StandService servicio = new StandService(new StandRepositoryMemoria());

    public static void main(String[] args) {
        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero("Selecciona una opcion: ");
            try {
                switch (opcion) {
                    case 1 -> registrar();
                    case 2 -> listar();
                    case 3 -> consultar();
                    case 4 -> cambiarEstado();
                    case 5 -> eliminar();
                    case 0 -> System.out.println("Programa finalizado.");
                    default -> System.out.println("Opcion no valida.");
                }
            } catch (RuntimeException e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println();
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("=== SISTEMA DE STANDS FILEY ===");
        System.out.println("1. Registrar stand");
        System.out.println("2. Listar stands");
        System.out.println("3. Consultar stand");
        System.out.println("4. Cambiar estado");
        System.out.println("5. Eliminar stand disponible");
        System.out.println("0. Salir");
    }

    private static void registrar() {
        int id = leerEntero("Identificador: ");
        double ancho = leerDouble("Ancho en metros: ");
        double largo = leerDouble("Largo en metros: ");
        double precio = leerDouble("Precio por metro cuadrado: ");
        servicio.registrarStand(id, ancho, largo, precio);
        System.out.println("Stand registrado correctamente.");
    }

    private static void listar() {
        if (servicio.listarStands().isEmpty()) {
            System.out.println("No hay stands registrados.");
            return;
        }
        for (Stand stand : servicio.listarStands()) System.out.println(stand);
    }

    private static void consultar() {
        System.out.println(servicio.consultarStand(leerEntero("Identificador: ")));
    }

    private static void cambiarEstado() {
        int id = leerEntero("Identificador del stand: ");
        System.out.println("1. DISPONIBLE  2. RESERVADO  3. VENDIDO");
        int estado = leerEntero("Nuevo estado: ");
        EstadoStand nuevo = switch (estado) {
            case 1 -> EstadoStand.DISPONIBLE;
            case 2 -> EstadoStand.RESERVADO;
            case 3 -> EstadoStand.VENDIDO;
            default -> throw new IllegalArgumentException("Estado no valido.");
        };
        servicio.cambiarEstado(id, nuevo);
        System.out.println("Estado actualizado.");
    }

    private static void eliminar() {
        servicio.eliminarStand(leerEntero("Identificador del stand: "));
        System.out.println("Stand eliminado.");
    }

    private static int leerEntero(String mensaje) {
        System.out.print(mensaje);
        int valor = entrada.nextInt();
        return valor;
    }

    private static double leerDouble(String mensaje) {
        System.out.print(mensaje);
        return entrada.nextDouble();
    }
}
