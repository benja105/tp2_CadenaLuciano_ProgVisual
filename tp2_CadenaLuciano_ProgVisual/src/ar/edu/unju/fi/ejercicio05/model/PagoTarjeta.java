package ar.edu.unju.fi.ejercicio05.model;

import java.time.LocalDate;

import ar.edu.unju.fi.ejercicio05.interfaces.Pago;

public class PagoTarjeta implements Pago{
	private String numeroTarjeta;
	private LocalDate fechaPago;
	private double montoPagado;
	public void realizarPago(double monto) {
		montoPagado=monto+(monto*0.15);
	}
	public void imprimirRecibo() {
		System.out.println("Numero de Tarjeta: "+numeroTarjeta);
		System.out.println("Fecha de pago: "+fechaPago);
		System.out.println("Monto pagado: "+montoPagado);
	}
	public PagoTarjeta(String numeroTarjeta, LocalDate fechaPago) {
		this.numeroTarjeta = numeroTarjeta;
		this.fechaPago = fechaPago;
	}
}