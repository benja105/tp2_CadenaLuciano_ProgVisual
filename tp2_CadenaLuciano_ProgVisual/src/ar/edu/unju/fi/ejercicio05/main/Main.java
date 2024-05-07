package ar.edu.unju.fi.ejercicio05.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.fi.ejercicio05.model.PagoEfectivo;
import ar.edu.unju.fi.ejercicio05.model.PagoTarjeta;
import ar.edu.unju.fi.ejercicio05.model.Producto;
import ar.edu.unju.fi.ejercicio05.model.Producto.Categorias;
import ar.edu.unju.fi.ejercicio05.model.Producto.Origenes;

public class Main {
    public static void main(String[] args) {
        List<Producto> productos = new ArrayList<>();
        precargarProductos(productos);
        List<Producto> productosDisponibles = new ArrayList<>();
        filtrarProductos(productosDisponibles, productos);
        Scanner sc = new Scanner(System.in);
        int option = 0;
        boolean valido = false;
        do {
            do {
                valido = false;
                System.out.print("\n*** MENU ***\n");
                System.out.print("1) Mostrar Productos Disponibles\n");
                System.out.print("2) Realizar una Compra\n");
                System.out.print("3) Salir\n");
                try {
                    System.out.print("Opcion: ");
                    option = Integer.parseInt(sc.next());
                    if (option < 1 || option > 3) {
                        System.out.print("\nOpcion no valida\n");
                    } else {
                        valido = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.print("\nERROR: Ingrese un numero valido\n");
                }
            } while (valido == false);
            switch (option) {
                case 1:
                    mostrarProductosDisponibles(productosDisponibles);
                    break;
                case 2:
                    realizarCompra(productosDisponibles, valido, sc);
                    break;
            }
        } while (option != 3);
        sc.close();
    }

    private static void precargarProductos(List<Producto> productos) {
        Producto p1 = new Producto("01", "PC", 500f, Origenes.ARGENTINA, Categorias.ELECTRO_HOGAR, true);
        Producto p2 = new Producto("02", "Destornillador", 1500f, Origenes.BRASIL, Categorias.HERRAMIENTAS, false);
        Producto p3 = new Producto("03", "Microfono", 700f, Origenes.CHINA, Categorias.INFORMATICA, false);
        Producto p4 = new Producto("04", "Cable", 230f, Origenes.URUGUAY, Categorias.TELEFONIA, true);
        Producto p5 = new Producto("05", "TV", 1510f, Origenes.ARGENTINA, Categorias.ELECTRO_HOGAR, false);
        Producto p6 = new Producto("06", "Clavo", 90f, Origenes.BRASIL, Categorias.HERRAMIENTAS, true);
        Producto p7 = new Producto("07", "Cable", 10f, Origenes.CHINA, Categorias.INFORMATICA, false);
        Producto p8 = new Producto("08", "Telefono", 5300f, Origenes.URUGUAY, Categorias.TELEFONIA, true);
        Producto p9 = new Producto("09", "Heladera", 5050f, Origenes.ARGENTINA, Categorias.ELECTRO_HOGAR, true);
        Producto p10 = new Producto("10", "Oz", 900f, Origenes.BRASIL, Categorias.HERRAMIENTAS, false);
        Producto p11 = new Producto("11", "Mouse", 560f, Origenes.CHINA, Categorias.INFORMATICA, true);
        Producto p12 = new Producto("12", "Teclas", 190f, Origenes.URUGUAY, Categorias.TELEFONIA, false);
        Producto p13 = new Producto("13", "Ventilador", 299f, Origenes.ARGENTINA, Categorias.ELECTRO_HOGAR, true);
        Producto p14 = new Producto("14", "Soldador", 412f, Origenes.BRASIL, Categorias.HERRAMIENTAS, true);
        Producto p15 = new Producto("15", "Iphone", 397f, Origenes.CHINA, Categorias.INFORMATICA, false);
        productos.add(p1);
        productos.add(p2);
        productos.add(p3);
        productos.add(p4);
        productos.add(p5);
        productos.add(p6);
        productos.add(p7);
        productos.add(p8);
        productos.add(p9);
        productos.add(p10);
        productos.add(p11);
        productos.add(p12);
        productos.add(p13);
        productos.add(p14);
        productos.add(p15);
    }

    private static void filtrarProductos(List<Producto> productosDisponibles, List<Producto> productos) {
        for (Producto producto : productos) {
            if (producto.isDisponible()) {
                productosDisponibles.add(producto);
            }
        }
    }

    private static void mostrarProductosDisponibles(List<Producto> productosDisponibles) {
        System.out.println("\n*** Productos Disponibles ***\n");
        for (Producto producto : productosDisponibles) {
            System.out.println("Codigo: " + producto.getCodigo());
            System.out.println("Descripcion: " + producto.getDescripcion());
            System.out.println("Precio Unitario: " + producto.getPrecioUnitario() + "$");
            System.out.println("Origen de Fabricacion: " + producto.getOrigenFabricacion());
            System.out.println("Categoria: " + producto.getCategoria() + "\n");
        }
    }

    private static void realizarCompra(List<Producto> productosDisponibles, boolean valido, Scanner sc) {
        List<Producto> productosParaComprar = new ArrayList<Producto>();
        int option = 0;
        double monto = 0d;
        valido = false;
        while (option != 4) {
            do {
                valido = false;
                monto = calcularMontoDelCarro(productosParaComprar);
                System.out.print("\n*** MENU ***\n");
                System.out.println("Monto Total: " + monto);
                System.out.print("1) Agregar un producto\n");
                System.out.print("2) Pago Efectivo (-10%)\n");
                System.out.print("3) Pago con Tarjeta (+15%)\n");
                System.out.print("4) Cancelar\n");
                try {
                    System.out.print("Opcion: ");
                    option = Integer.parseInt(sc.next());
                    if (option < 1 || option > 4) {
                        System.out.print("\nOpcion no valida\n");
                    } else {
                        valido = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.print("\nERROR: Ingrese un numero valido\n");
                }
            } while (valido == false);
            switch (option) {
                case 1:
                    agregarProductoAlCarro(productosDisponibles, sc, productosParaComprar, valido);
                    break;
                case 2:
                    pagarConEfectivo(productosParaComprar, monto);
                    productosParaComprar.clear();
                    break;
                case 3:
                    pagarConTarjeta(productosParaComprar, monto);
                    productosParaComprar.clear();
                    break;
                case 4:
                    productosParaComprar.clear();
                    break;
            }
        }
    }

    private static double calcularMontoDelCarro(List<Producto> productosParaComprar) {
        double monto = 0;
        for (Producto producto : productosParaComprar) {
            monto += producto.getPrecioUnitario();
        }
        return monto;
    }

    private static void agregarProductoAlCarro(List<Producto> productosDisponibles, Scanner sc,
            List<Producto> productosParaComprar, boolean valido) {
        String codigo;
        valido = false;
        System.out.print("Ingrese el codigo del producto: ");
        codigo = sc.next();
        for (Producto producto : productosDisponibles) {
            if (codigo.equals(producto.getCodigo())) {
                valido = true;
                productosParaComprar.add(producto);
            }
        }
        if (valido) {
            System.out.println("\nProducto Agregado Al Carro\n");
        } else {
            System.out.println("\nProducto Inexistente o No Disponible\n");
        }
    }

    private static void pagarConEfectivo(List<Producto> productosParaComprar, double monto) {
        PagoEfectivo pagoEfectivo = new PagoEfectivo(LocalDate.now());
        pagoEfectivo.realizarPago(monto);
        pagoEfectivo.imprimirRecibo();
    }

    private static void pagarConTarjeta(List<Producto> productosParaComprar, double monto) {
        PagoTarjeta pagoTarjeta = new PagoTarjeta("0123456789", LocalDate.now());
        pagoTarjeta.realizarPago(monto);
        pagoTarjeta.imprimirRecibo();
    }
}