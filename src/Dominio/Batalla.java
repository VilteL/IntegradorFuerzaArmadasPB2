package Dominio;

import java.util.HashSet;
import java.util.Set;

public class Batalla {
	
	
	
	private String nombre;
	
	private Double latitud;
	private Double longitud;
	private TipoDeBatalla tipo;
	Set<Vehiculo> vehiculosEnLaBatalla;
	
	
	public Batalla(String nombre, Double latitud, Double longitud, TipoDeBatalla tipo) {
		
		this.nombre= nombre;
		this.latitud= latitud;
		this.longitud=longitud;
		this.tipo=tipo;
		this.vehiculosEnLaBatalla = new HashSet<>();
	}


	public String getNombre() {
		return nombre;
	}
	
	public Double getLatitud() {
		return latitud;
	}
	
	public Double getLongitud() {
		return longitud;
	}
	public void enviarVehiculoALaBatalla(Vehiculo vehiculo) {
		this.vehiculosEnLaBatalla.add(vehiculo);
	}
	public TipoDeBatalla getTipo() {
		return tipo;
	}


	public Set<Vehiculo> getVehiculosEnLaBatalla() {
		return vehiculosEnLaBatalla;
	}
	
	
}
