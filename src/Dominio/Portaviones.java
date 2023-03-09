package Dominio;

import Interfaces.Acuatico;

public class Portaviones extends Vehiculo implements Acuatico {

	private Double profundidad;
	
	public Portaviones(Integer codigo, String modelo) {
		super(codigo, modelo);
	}

	@Override
	public Double getProfundidad() {
		return this.profundidad;
	}

}
