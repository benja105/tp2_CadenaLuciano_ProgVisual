package ar.edu.unju.fi.ejercicio01.model;

public class Producto {
	
	String codigo;
	String descripcion;
	double precioU;
	OrigenFabricacion origenFabricacion;
	Categoria categoria;
	
	
	
	public Producto(String codigo, String descripcion, double precioU, OrigenFabricacion origenFabricacion,
			Categoria categoria) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioU = precioU;
		this.origenFabricacion = origenFabricacion;
		this.categoria = categoria;
	}

	public String getCodigo() {
		return codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public double getPrecioU() {
		return precioU;
	}
	
	public OrigenFabricacion getOrigenFabricacion() {
		return origenFabricacion;
	}

	public Categoria getCategoria() {
		return categoria;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setPrecioU(double precioU) {
		this.precioU = precioU;
	}

	public void setOrigenFabricacion(OrigenFabricacion origenFabricacion) {
		this.origenFabricacion = origenFabricacion;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public enum OrigenFabricacion{
		ARGENTINA, CHINA, BRASIL, URUGUAY
	}
	
	public enum Categoria{
		TELEFONIA, INFORMATICA, ELECTROHOGAR, HERRAMIENTAS
	}
	
}