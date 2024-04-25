package ar.edu.unju.fi.ejercicio01.main;

import ar.edu.unju.fi.ejercicio01.model.Producto;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		ArrayList<Producto> productos = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("Menú de opciones:");
            System.out.println("1 - Crear Producto");
            System.out.println("2 - Mostrar productos");
            System.out.println("3 - Modificar producto");
            System.out.println("4 - Salir");
            System.out.print("Ingrese una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    crearProducto(scanner, productos);
                    break;
                case 2:
                    mostrarProductos(productos);
                    break;
                case 3:
                    modificarProducto(scanner, productos);
                    break;
                case 4:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        } while (opcion != 4);
    }

    private static void crearProducto(Scanner scanner, ArrayList<Producto> productos) {
        try {
            scanner.nextLine(); // Limpiar buffer de entrada
            System.out.print("Ingrese el código del producto: ");
            String codigo = scanner.nextLine();

            System.out.print("Ingrese la descripción del producto: ");
            String descripcion = scanner.nextLine();

            System.out.print("Ingrese el precio unitario del producto: ");
            double precio = scanner.nextDouble();

            System.out.println("Origen de fabricación:");
            mostrarOrigenesFabricacion();
            System.out.print("Seleccione el origen de fabricación (1-4): ");
            int origenIndex = scanner.nextInt();
            Producto.OrigenFabricacion origenFabricacion = Producto.OrigenFabricacion.values()[origenIndex - 1];

            System.out.println("Categoría:");
            mostrarCategorias();
            System.out.print("Seleccione la categoría (1-4): ");
            int categoriaIndex = scanner.nextInt();
            Producto.Categoria categoria = Producto.Categoria.values()[categoriaIndex - 1];

            productos.add(new Producto(codigo, descripcion, precio, origenFabricacion, categoria));
            System.out.println("Producto creado correctamente.");
        } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Entrada inválida. Por favor, ingrese datos válidos.");
        }
    }

    private static void mostrarProductos(ArrayList<Producto> productos) {
        if (productos.isEmpty()) {
            System.out.println("No hay productos para mostrar.");
        } else {
            System.out.println("Listado de productos:");
            for (Producto producto : productos) {
                System.out.println(producto.getCodigo() + " - " + producto.getDescripcion());
            }
        }
    }

    private static void modificarProducto(Scanner scanner, ArrayList<Producto> productos) {
        try {
            scanner.nextLine(); // Limpiar buffer de entrada
            System.out.print("Ingrese el código del producto a modificar: ");
            String codigoModificar = scanner.nextLine();

            Producto productoModificar = null;
            for (Producto producto : productos) {
                if (producto.getCodigo().equals(codigoModificar)) {
                    productoModificar = producto;
                    break;
                }
            }

            if (productoModificar != null) {
                System.out.println("Producto encontrado:");
                System.out.println(productoModificar);

                System.out.println("Seleccione el campo a modificar:");
                System.out.println("1 - Descripción");
                System.out.println("2 - Precio unitario");
                System.out.println("3 - Origen de fabricación");
                System.out.println("4 - Categoría");
                System.out.print("Ingrese una opción: ");
                int opcionModificacion = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer de entrada

                switch (opcionModificacion) {
                    case 1:
                        System.out.print("Ingrese la nueva descripción: ");
                        String nuevaDescripcion = scanner.nextLine();
                        productoModificar.setDescripcion(nuevaDescripcion);
                        break;
                    case 2:
                        System.out.print("Ingrese el nuevo precio unitario: ");
                        double nuevoPrecio = scanner.nextDouble();
                        productoModificar.setPrecioU(nuevoPrecio);
                        break;
                    case 3:
                        System.out.println("Origen de fabricación:");
                        mostrarOrigenesFabricacion();
                        System.out.print("Seleccione el nuevo origen de fabricación (1-4): ");
                        int nuevoOrigenIndex = scanner.nextInt();
                        Producto.OrigenFabricacion nuevoOrigen = Producto.OrigenFabricacion.values()[nuevoOrigenIndex - 1];
                        productoModificar.setOrigenFabricacion(nuevoOrigen);
                        break;
                    case 4:
                        System.out.println("Categoría:");
                        mostrarCategorias();
                        System.out.print("Seleccione la nueva categoría (1-4): ");
                        int nuevaCategoriaIndex = scanner.nextInt();
                        Producto.Categoria nuevaCategoria = Producto.Categoria.values()[nuevaCategoriaIndex - 1];
                        productoModificar.setCategoria(nuevaCategoria);
                        break;
                    default:
                        System.out.println("Opción no válida. No se realizaron modificaciones.");
                        break;
                }
                System.out.println("Producto modificado correctamente.");
            } else {
                System.out.println("Producto no encontrado con el código ingresado.");
            }
        } catch (InputMismatchException | ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Entrada inválida. Por favor, ingrese datos válidos.");
        }
    }

    private static void mostrarOrigenesFabricacion() {
        System.out.println("1 - Argentina");
        System.out.println("2 - China");
        System.out.println("3 - Brasil");
        System.out.println("4 - Uruguay");
    }

    private static void mostrarCategorias() {
        System.out.println("1 - Telefonía");
        System.out.println("2 - Informática");
        System.out.println("3 - Electrohogar");
        System.out.println("4 - Herramientas");
    }
	
}

