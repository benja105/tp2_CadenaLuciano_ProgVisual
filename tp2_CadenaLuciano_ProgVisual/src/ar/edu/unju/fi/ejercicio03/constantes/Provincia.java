package ar.edu.unju.fi.ejercicio03.constantes;

public enum  Provincia {
	
	JUJUY(680260, 53219), 
    SALTA(1508233, 155488),
    TUCUMAN(1700305, 22524),
    CATAMARCA(370828, 102602),
    LA_RIOJA(398531, 89680),
    SANTIAGO_DEL_ESTERO(880006, 136351);
	
	private int cantidadPoblacion;
	private int superficie;
	
	private Provincia(int cantidadPoblacion, int superficie) {
		this.cantidadPoblacion = cantidadPoblacion;
		this.superficie = superficie;
	}

	public int getCantidadPoblacion() {
		return cantidadPoblacion;
	}

	public int getSuperficie() {
		return superficie;
	}

	public void setCantidadPoblacion(int cantidadPoblacion) {
		this.cantidadPoblacion = cantidadPoblacion;
	}

	public void setSuperficie(int superficie) {
		this.superficie = superficie;
	}
	
	public double calcularDensidadPoblacional() {
		
		return (double) cantidadPoblacion / superficie;
		
	}
	
}
