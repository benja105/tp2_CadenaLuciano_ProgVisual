package ar.edu.unju.fi.ejercicio02.main;

import ar.edu.unju.fi.ejercicio02.model.Efemeride;
import ar.edu.unju.fi.ejercicio02.constantes.Mes;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		ArrayList<Efemeride> efemerides = new ArrayList<>();
		Scanner scanner = new Scanner(System.in);
		
		int opcion;
        do {
            System.out.println("Menú de acciones:");
            System.out.println("1 - Crear efeméride");
            System.out.println("2 - Mostrar efemérides");
            System.out.println("3 - Eliminar efeméride");
            System.out.println("4 - Modificar efeméride");
            System.out.println("5 - Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    crearEfemeride(scanner, efemerides);
                    break;
                case 2:
                    mostrarEfemerides(efemerides);
                    break;
                case 3:
                    eliminarEfemeride(scanner, efemerides);
                    break;
                case 4:
                    modificarEfemeride(scanner, efemerides);
                    break;
                case 5:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 5);
    }

    private static void crearEfemeride(Scanner scanner, ArrayList<Efemeride> efemerides) {
        try {
            scanner.nextLine();
            System.out.print("Ingrese el código de la efeméride: ");
            String codigo = scanner.nextLine();

            System.out.print("Ingrese el mes de la efeméride (1-12): ");
            int mesIndex = scanner.nextInt();
            if (mesIndex < 1 || mesIndex > 12) {
                System.out.println("Mes no válido. Debe ser un número entre 1 y 12.");
                return;
            }
            Mes mes = Mes.values()[mesIndex - 1];

            System.out.print("Ingrese el día de la efeméride: ");
            int dia = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Ingrese el detalle de la efeméride: ");
            String detalle = scanner.nextLine();

            efemerides.add(new Efemeride(codigo, mes, dia, detalle));
            System.out.println("Efeméride creada correctamente.");
        } catch (InputMismatchException e) {
            System.out.println("Error: Entrada inválida. Por favor, ingrese datos válidos.");
        }
    }

    private static void mostrarEfemerides(ArrayList<Efemeride> efemerides) {
        if (efemerides.isEmpty()) {
            System.out.println("No hay efemérides para mostrar.");
        } else {
            System.out.println("Listado de efemérides:");
            for (Efemeride efemeride : efemerides) {
                System.out.println(efemeride);
            }
        }
    }

    private static void eliminarEfemeride(Scanner scanner, ArrayList<Efemeride> efemerides) {
        try {
            scanner.nextLine();
            System.out.print("Ingrese el código de la efeméride a eliminar: ");
            String codigoEliminar = scanner.nextLine();

            boolean eliminado = false;
            for (Efemeride efemeride : efemerides) {
                if (efemeride.getCodigo().equals(codigoEliminar)) {
                    efemerides.remove(efemeride);
                    eliminado = true;
                    break;
                }
            }

            if (eliminado) {
                System.out.println("Efeméride eliminada correctamente.");
            } else {
                System.out.println("No se encontró ninguna efeméride con el código ingresado.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Entrada inválida. Por favor, ingrese un código válido.");
        }
    }

    private static void modificarEfemeride(Scanner scanner, ArrayList<Efemeride> efemerides) {
        try {
            scanner.nextLine();
            System.out.print("Ingrese el código de la efeméride a modificar: ");
            String codigoModificar = scanner.nextLine();

            boolean encontrado = false;
            for (Efemeride efemeride : efemerides) {
                if (efemeride.getCodigo().equals(codigoModificar)) {
                    encontrado = true;

                    System.out.println("Modificando efeméride:");
                    System.out.println(efemeride);
                    System.out.println("Ingrese los nuevos datos:");

                    System.out.print("Nuevo código: ");
                    String nuevoCodigo = scanner.nextLine();
                    efemeride.setCodigo(nuevoCodigo);

                    System.out.print("Nuevo mes (1-12): ");
                    int mesIndex = scanner.nextInt();
                    if (mesIndex < 1 || mesIndex > 12) {
                        System.out.println("Mes no válido. Debe ser un número entre 1 y 12.");
                        return;
                    }
                    Mes nuevoMes = Mes.values()[mesIndex - 1];
                    efemeride.setMes(nuevoMes);

                    System.out.print("Nuevo día: ");
                    int nuevoDia = scanner.nextInt();
                    efemeride.setDia(nuevoDia);
                    scanner.nextLine();

                    System.out.print("Nuevo detalle: ");
                    String nuevoDetalle = scanner.nextLine();
                    efemeride.setDetalle(nuevoDetalle);

                    System.out.println("Efeméride modificada correctamente.");
                    break;
                }
            }

            if (!encontrado) {
                System.out.println("No se encontró ninguna efeméride con el código ingresado.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Entrada inválida. Por favor, ingrese datos válidos.");
        }
        
	}
    
}
