package Dominio;

import java.util.*;

import Excepciones.VehiculoIncompatible;
import Excepciones.VehiculoInexistente;
import Interfaces.Acuatico;
import Interfaces.Terrestre;
import Interfaces.Volador;

public class FuerzaArmada {
	
	private String nombre;
	
	private Set<Vehiculo> convoy;
	private Map<String, Batalla> batallas;
	
	public FuerzaArmada(String nombre) {
		this.nombre= nombre; 
		
		this.convoy = new HashSet <>();
		this.batallas = new HashMap<>();
	}
	
	public void agregarVehiculo(Vehiculo vehiculoNuevo) {
		this.convoy.add(vehiculoNuevo);
	}
	
	public Integer getCapacidadDeDefensa() {
		return this.convoy.size();
	}
	public void crearBatalla(String nombre, TipoDeBatalla tipo, Double latitud, Double longitud) {
		
		Batalla nuevaBatalla = new Batalla(nombre, latitud, longitud, tipo);
		this.batallas.put(nuevaBatalla.getNombre(), nuevaBatalla);
	}



	public Batalla getBatalla(String nombreBatalla) {
		return this.batallas.get(nombreBatalla);
	}

	public Boolean enviarALaBatalla(String nombreDeLaBatalla, Integer IdVehiculo) throws VehiculoInexistente, VehiculoIncompatible {
		
		if(verificarQueElvehiculoExistaEnElConvoy(IdVehiculo)) {
			Vehiculo vehiculoParaBatalla =  agarrarVehiculoDelConvoy(IdVehiculo);
			
			if(verificarQueExisteLaBatalla(nombreDeLaBatalla)) {
				Batalla batalla = this.batallas.get(nombreDeLaBatalla);
				verificarSiElVehiculoEsAptoParaBatalla(vehiculoParaBatalla, batalla);
				return true;
			}
			
			
		}
		return false;
	}
	
	
	private Boolean verificarQueElvehiculoExistaEnElConvoy(Integer idVehiculo) throws VehiculoInexistente {
		
		for (Vehiculo vehiculo : convoy) {
			if(vehiculo.getCodigo().equals(idVehiculo))
				return true;
		}
		throw new VehiculoInexistente();
	}
	private Vehiculo agarrarVehiculoDelConvoy(Integer idVehiculo) throws VehiculoInexistente {
		
		for (Vehiculo vehiculo : convoy) {
			if(vehiculo.getCodigo().equals(idVehiculo)) {
				return vehiculo;
			
			}
		}
		// Esta excepcion no es necesaria
		throw new VehiculoInexistente();	
	}
		
	private Boolean verificarQueExisteLaBatalla(String nombreDeLaBatalla) {
		return this.batallas.containsKey(nombreDeLaBatalla);
	}
	
	
	private void verificarSiElVehiculoEsAptoParaBatalla(Vehiculo vehiculo, Batalla batalla) throws VehiculoIncompatible {
		
		TipoDeBatalla tipoDeBatalla = batalla.getTipo();
		
		switch (tipoDeBatalla) {
				
		case ACUATICA: if(vehiculo instanceof Acuatico) {
						batalla.getVehiculosEnLaBatalla().add(vehiculo);
					}else {
						throw new VehiculoIncompatible();
					}
			break;
		case AEREA: if(vehiculo instanceof Volador) {
				batalla.getVehiculosEnLaBatalla().add(vehiculo);
			}else {
				throw new VehiculoIncompatible();
			}
			break;
		case TERRESTRE: if(vehiculo instanceof Terrestre) {
						batalla.getVehiculosEnLaBatalla().add(vehiculo);
						}
						else {
							throw new VehiculoIncompatible();
							}
						break;
		default : throw new VehiculoIncompatible();
		}
		
		
	}
	
}
