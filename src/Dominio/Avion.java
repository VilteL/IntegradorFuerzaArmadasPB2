package Dominio;

import Interfaces.Volador;

public class Avion extends Vehiculo implements Volador {

	private Double altura;
	
	public Avion(Integer codigo, String modelo) {
		super(codigo, modelo);
	}

	@Override
	public Double getAltura() {
		return this.altura;
	}
	
	
	
	

}
