package Dominio;

import Interfaces.Acuatico;

public class Submarino extends Vehiculo implements Acuatico{

	private Double profundidad;
	
	public Submarino(Integer codigo, String modelo) {
		super(codigo, modelo);
	}

	@Override
	public Double getProfundidad() {
		return this.profundidad;
	}
	
}
