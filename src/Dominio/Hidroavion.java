package Dominio;

import Interfaces.Acuatico;
import Interfaces.Volador;

public class Hidroavion extends Vehiculo implements Volador, Acuatico{

	private Double altura;
	private Double profundidad;
	
	
	public Hidroavion(Integer codigo, String modelo) {
		super(codigo, modelo);
	}

	@Override
	public Double getProfundidad() {
		return this.profundidad;
	}

	@Override
	public Double getAltura() {
		return this.altura;
	}

}
