package Dominio;

import Interfaces.Terrestre;

public class Tanque extends Vehiculo implements Terrestre{

	private Double velocidad;
	
	public Tanque(Integer codigo, String modelo) {
		super(codigo, modelo);
	}

	@Override
	public Double getVelocidad() {
		return this.velocidad;
	}

	
	
}
