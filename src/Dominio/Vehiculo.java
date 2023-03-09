package Dominio;

import java.util.Objects;

public class Vehiculo {
	
	private Integer Codigo;
	private String modelo;
	
	public Vehiculo(Integer codigo, String modelo) {
		this.Codigo= codigo;
		this.modelo = modelo;
	}

	public Integer getCodigo() {
		return Codigo;
	}

	public String getModelo() {
		return modelo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(Codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vehiculo other = (Vehiculo) obj;
		return Objects.equals(Codigo, other.Codigo);
	}
	
	
	
	
}
