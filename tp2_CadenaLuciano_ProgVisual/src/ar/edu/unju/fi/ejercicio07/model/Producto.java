package ar.edu.unju.fi.ejercicio07.model;

public class Producto {
	
	public enum Origenes{
		ARGENTINA,CHINA,BRASIL,URUGUAY;
	}
	public enum Categorias{
		TELEFONIA,INFORMATICA,ELECTRO_HOGAR,HERRAMIENTAS;
	}
	
	private String codigo;
	private String descripcion;
	private float precioUnitario;
	private Origenes origenFabricacion;
	private Categorias categoria;
	private boolean disponible;
	
	public Producto(String codigo, String descripcion, float precioUnitario, Origenes origenFabricacion, Categorias categoria, boolean disponible) {
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.precioUnitario = precioUnitario;
		this.origenFabricacion = origenFabricacion;
		this.categoria = categoria;
		this.disponible = disponible;
	}
	
	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public float getPrecioUnitario() {
		return precioUnitario;
	}
	
	public void setPrecioUnitario(float precioUnitario) {
		this.precioUnitario = precioUnitario;
	}
	
	public Origenes getOrigenFabricacion() {
		return origenFabricacion;
	}
	
	public void setOrigenFabricacion(Origenes origenFabricacion) {
		this.origenFabricacion = origenFabricacion;
	}
	
	public Categorias getCategoria() {
		return categoria;
	}
	
	public void setCategoria(Categorias categoria) {
		this.categoria = categoria;
	}
	
	public boolean isDisponible() {
		return disponible;
	}
	
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
	@Override
	public String toString() {
		return "Producto [codigo=" + codigo + ", descripcion=" + descripcion + ", precioUnitario=" + precioUnitario
				+ ", origenFabricacion=" + origenFabricacion + ", categoria=" + categoria + ", disponible=" + disponible
				+ "]";
	}
}
