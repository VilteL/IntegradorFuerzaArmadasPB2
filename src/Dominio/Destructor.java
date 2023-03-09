package Dominio;

import Interfaces.Acuatico;

public class Destructor extends Vehiculo implements Acuatico {
	
	private Double profundidad;
	
	public Destructor(Integer codigo, String modelo) {
		super(codigo, modelo);
	}

	@Override
	public Double getProfundidad() {
		return this.profundidad;
	}

	
	
	
	
}
