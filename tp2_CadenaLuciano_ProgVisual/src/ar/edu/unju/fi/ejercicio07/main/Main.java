package ar.edu.unju.fi.ejercicio07.main;

import ar.edu.unju.fi.ejercicio07.model.Producto;
import ar.edu.unju.fi.ejercicio07.model.Producto.Categorias;
import ar.edu.unju.fi.ejercicio07.model.Producto.Origenes;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		List<Producto> productos=new ArrayList<Producto>();
		precargarProductos(productos);
		Scanner sc=new Scanner(System.in);
		int option=0;
		boolean valido=false;
		do{
			do {
				valido=false;
				System.out.print("\n*** MENU ***\n");
				System.out.print("1) Mostrar Productos Disponibles\n");
				System.out.print("2) Mostrar Productos Faltantes\n");
				System.out.print("3) Incrementar Precios un 20%\n");
				System.out.print("4) Mostrar Productos Disponibles de la categoria ElectroHogar\n");
				System.out.print("5) Ordenar Productos por precio de forma descendente\n");
				System.out.print("6) Mostrar Productos con nombres en mayusculas\n");
				System.out.print("7) Salir\n");
				try {
					System.out.print("Opcion: ");
					option=Integer.parseInt(sc.next());
					if(option<1||option>7) {
						System.out.print("\nOpcion no valida\n");
					}else {
						valido=true;
					}
				}catch (NumberFormatException e) {
					System.out.print("\nERROR: Ingrese un numero valido\n");
				}
			}while(valido==false);
			switch(option) {
			case 1:
				mostrarProductosDisponibles(productos);
				break;
			case 2:
				mostrarProductosFaltantes(productos);
				break;
			case 3:
				incrementarPrecios(productos);
				break;
			case 4:
				mostrarProductosElectro(productos);
				break;
			case 5:
				ordenarPorPrecio(productos);
				break;
			case 6:
				mostrarProductosMayusculas(productos);
				break;
			}
		}while(option!=7);
		sc.close();
	}
	private static void precargarProductos(List<Producto> productos) {
		Producto p1=new Producto("01", "PC", 500f, Origenes.ARGENTINA, Categorias.ELECTRO_HOGAR, true);
		Producto p2=new Producto("02", "Destornillador", 1500f, Origenes.BRASIL, Categorias.HERRAMIENTAS, false);
		Producto p3=new Producto("03", "Microfono", 700f, Origenes.CHINA, Categorias.INFORMATICA, false);
		Producto p4=new Producto("04", "Cable", 230f, Origenes.URUGUAY, Categorias.TELEFONIA, true);
		Producto p5=new Producto("05", "TV", 1510f, Origenes.ARGENTINA, Categorias.ELECTRO_HOGAR, false);
		Producto p6=new Producto("06", "Clavo", 90f, Origenes.BRASIL, Categorias.HERRAMIENTAS, true);
		Producto p7=new Producto("07", "Cable", 10f, Origenes.CHINA, Categorias.INFORMATICA, false);
		Producto p8=new Producto("08", "Telefono", 5300f, Origenes.URUGUAY, Categorias.TELEFONIA, true);
		Producto p9=new Producto("09", "Heladera", 5050f, Origenes.ARGENTINA, Categorias.ELECTRO_HOGAR, true);
		Producto p10=new Producto("10", "Oz", 900f, Origenes.BRASIL, Categorias.HERRAMIENTAS, false);
		Producto p11=new Producto("11", "Mouse", 560f, Origenes.CHINA, Categorias.INFORMATICA, true);
		Producto p12=new Producto("12", "Teclas", 190f, Origenes.URUGUAY, Categorias.TELEFONIA, false);
		Producto p13=new Producto("13", "Ventilador", 299f, Origenes.ARGENTINA, Categorias.ELECTRO_HOGAR, true);
		Producto p14=new Producto("14", "Soldador", 412f, Origenes.BRASIL, Categorias.HERRAMIENTAS, true);
		Producto p15=new Producto("15", "Iphone", 397f, Origenes.CHINA, Categorias.INFORMATICA, false);
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
	private static void mostrarProductosDisponibles(List<Producto> productos) {
		Consumer<Producto> mostrar= x -> {
			if(x.isDisponible()) {
				System.out.println("Codigo: "+x.getCodigo());
	            System.out.println("Descripcion: "+x.getDescripcion());
	            System.out.println("Precio Unitario: "+x.getPrecioUnitario()+"$");
	            System.out.println("Origen de Fabricacion: "+x.getOrigenFabricacion());
	            System.out.println("Categoria: "+x.getCategoria()+"\n");
			}
		};
		System.out.println("\nProductos Disponibles\n");
		productos.forEach(mostrar);
	}
	private static void mostrarProductosFaltantes(List<Producto> productos) {
		Predicate<Producto> condicion = x -> x.isDisponible()==false;
		List<Producto> productosAMostrar=new ArrayList<Producto>();
		productosAMostrar=productos.stream().filter(condicion).collect(Collectors.toList());
		System.out.println("\nProductos Faltantes\n");
		for(Producto p : productosAMostrar) {
			System.out.println("Codigo: "+p.getCodigo());
            System.out.println("Descripcion: "+p.getDescripcion());
            System.out.println("Precio Unitario: "+p.getPrecioUnitario()+"$");
            System.out.println("Origen de Fabricacion: "+p.getOrigenFabricacion());
            System.out.println("Categoria: "+p.getCategoria()+"\n");
		}
	}
	private static void incrementarPrecios(List<Producto> productos) {
		Function<Producto,Producto> nuevoPrecio = x -> {
			x.setPrecioUnitario(x.getPrecioUnitario()*1.20f);
			return x;
			};
			@SuppressWarnings("unused")
			List<Producto> productosIncrementados=new ArrayList<Producto>();
			productosIncrementados=productos.stream().map(nuevoPrecio).collect(Collectors.toList());
			System.out.println("\nPrecios Incrementados");
	}
	private static void mostrarProductosElectro(List<Producto> productos) {
		Predicate<Producto> condicion = x -> x.isDisponible()!=false&&x.getCategoria().equals(Producto.Categorias.ELECTRO_HOGAR);
		List<Producto> productosAMostrar=new ArrayList<Producto>();
		productosAMostrar=productos.stream().filter(condicion).collect(Collectors.toList());
		System.out.println("\nProductos Disponibles de Electro Hogar\n");
		for(Producto p : productosAMostrar) {
			System.out.println("Codigo: "+p.getCodigo());
            System.out.println("Descripcion: "+p.getDescripcion());
            System.out.println("Precio Unitario: "+p.getPrecioUnitario()+"$");
            System.out.println("Origen de Fabricacion: "+p.getOrigenFabricacion());
            System.out.println("Categoria: "+p.getCategoria()+"\n");
		}
	}
	private static void ordenarPorPrecio(List<Producto> productos) {
		productos.sort(Comparator.comparing(Producto :: getPrecioUnitario).reversed());
		System.out.println("\nProductos Ordenados");
	}
	private static void mostrarProductosMayusculas(List<Producto> productos) {
		Function<Producto,Producto> mayusculas = x -> {
			x.setDescripcion(x.getDescripcion().toUpperCase());
			return x;
			};
			List<Producto> productosAMostrar=new ArrayList<Producto>();
			productosAMostrar=productos.stream().map(mayusculas).collect(Collectors.toList());
			for(Producto p : productosAMostrar) {
				System.out.println("Codigo: "+p.getCodigo());
	            System.out.println("Descripcion: "+p.getDescripcion());
	            System.out.println("Precio Unitario: "+p.getPrecioUnitario()+"$");
	            System.out.println("Origen de Fabricacion: "+p.getOrigenFabricacion());
	            System.out.println("Categoria: "+p.getCategoria()+"\n");
			}
	}
}