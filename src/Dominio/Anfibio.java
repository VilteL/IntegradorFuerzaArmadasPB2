package Dominio;

import Interfaces.Acuatico;
import Interfaces.Terrestre;

public class Anfibio extends Vehiculo implements Terrestre, Acuatico {

	private Double profundidad;
	private Double velocidad;
	
	public Anfibio(Integer codigo, String modelo) {
		super(codigo, modelo);
	}

	@Override
	public Double getProfundidad() {
		return this.profundidad;
	}

	@Override
	public Double getVelocidad() {
		return this.velocidad;
	}
	
}
