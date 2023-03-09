package Test;

import static org.junit.Assert.*;

import org.junit.Test;

import Dominio.Anfibio;
import Dominio.Avion;
import Dominio.Camion;
import Dominio.Destructor;
import Dominio.FuerzaArmada;
import Dominio.Hidroavion;
import Dominio.Portaviones;
import Dominio.Submarino;
import Dominio.Tanque;
import Dominio.TipoDeBatalla;
import Dominio.Vehiculo;
import Excepciones.VehiculoIncompatible;
import Excepciones.VehiculoInexistente;

public class test {

	@Test
	public void queSePuedaCrearUnObjetoVolador() {
		Vehiculo avion = new Avion(1, "A-10");

		assertNotNull(avion);
	}

	@Test
	public void queSePuedaCrearUnObjetoTerrestre() {
		Vehiculo tanque = new Tanque(5, "Renault FT");


		assertNotNull(tanque);
		}

	@Test
	public void queSePuedaCrearUnObjetoAcuatico() {
		Vehiculo submarino = new Submarino(8, "ARA - San Juan");

		assertNotNull(submarino);
	}

	@Test
	public void queSePuedaCrearUnObjetoAnfibio() {
		Vehiculo var = new Anfibio(30, "Anfibio");

		assertNotNull(var);
	}

	@Test
	public void queSePuedaCrearUnHidroavion() {
		Vehiculo ag600 = new Hidroavion(12, "AG600");

		assertNotNull(ag600);
	}

	@Test
	public void queSePuedaArmarElConvoy() {
		FuerzaArmada argentina = new FuerzaArmada("Ejercito argentino");

		argentina.agregarVehiculo(new Avion(1, "A-10"));
		argentina.agregarVehiculo(new Avion(2, "A-10"));
		argentina.agregarVehiculo(new Avion(3, "F-102"));
		argentina.agregarVehiculo(new Avion(4, "F-15"));
		argentina.agregarVehiculo(new Tanque(5, "Renault FT"));
		argentina.agregarVehiculo(new Camion(6, "T-72"));
		argentina.agregarVehiculo(new Camion(7, "T-72"));
		argentina.agregarVehiculo(new Submarino(8, "A-10"));
		argentina.agregarVehiculo(new Portaviones(9, "A-10"));
		argentina.agregarVehiculo(new Destructor(10, "A-10"));
		argentina.agregarVehiculo(new Destructor(11, "A-10"));
		argentina.agregarVehiculo(new Hidroavion(12, "A-10"));
		argentina.agregarVehiculo(new Anfibio(13, "A-10"));
		argentina.agregarVehiculo(new Avion(14, "A-10"));
		argentina.agregarVehiculo(new Avion(15, "A-10"));
		argentina.agregarVehiculo(new Avion(16, "F-102"));
		argentina.agregarVehiculo(new Avion(17, "F-15"));
		argentina.agregarVehiculo(new Tanque(18, "Renault FT"));
		argentina.agregarVehiculo(new Camion(19, "T-72"));
		argentina.agregarVehiculo(new Camion(20, "T-72"));
		argentina.agregarVehiculo(new Submarino(21, "ARA - San Juan"));
		argentina.agregarVehiculo(new Portaviones(22, "A-10"));
		argentina.agregarVehiculo(new Destructor(23, "A-10"));
		argentina.agregarVehiculo(new Destructor(24, "A-10"));
		argentina.agregarVehiculo(new Hidroavion(25, "Mitsubishi F1M"));
		argentina.agregarVehiculo(new Anfibio(26, "LARC-5"));

		assertEquals((Integer)26, argentina.getCapacidadDeDefensa());
	}

	@Test
	public void queSePuedaCrearUnaBatalla() {
		FuerzaArmada argentina = new FuerzaArmada("Ejercito argentino");
		
		argentina.crearBatalla("San Lorenzo", TipoDeBatalla.TERRESTRE, 100.5, 20.3);
		argentina.crearBatalla("San Lorenzo", TipoDeBatalla.TERRESTRE, 100.5, 20.3);	

		assertEquals(100.5, argentina.getBatalla("San Lorenzo").getLatitud(),0.01);
		assertEquals(20.3, argentina.getBatalla("San Lorenzo").getLongitud(),0.01);
	}	

	@Test
	public void queSePuedaPresentarBatallaTerrestre() throws VehiculoInexistente, VehiculoIncompatible {
		FuerzaArmada argentina = new FuerzaArmada("Ejercito Argentino");

		argentina.agregarVehiculo(new Avion(1, "A-10"));
		argentina.agregarVehiculo(new Avion(2, "A-10"));
		argentina.agregarVehiculo(new Avion(3, "F-102"));
		argentina.agregarVehiculo(new Avion(4, "F-15"));
		argentina.agregarVehiculo(new Tanque(5, "Renault FT"));
		argentina.agregarVehiculo(new Camion(6, "T-72"));
		argentina.agregarVehiculo(new Camion(7, "T-72"));
		argentina.agregarVehiculo(new Submarino(8, "A-10"));
		argentina.agregarVehiculo(new Portaviones(9, "A-10"));
		argentina.agregarVehiculo(new Destructor(10, "A-10"));
		argentina.agregarVehiculo(new Destructor(11, "A-10"));
		argentina.agregarVehiculo(new Hidroavion(12, "A-10"));
		argentina.agregarVehiculo(new Anfibio(13, "A-10"));

	

		argentina.crearBatalla("San Lorenzo", TipoDeBatalla.TERRESTRE, 100.5, 20.3);

		assertTrue(argentina.enviarALaBatalla("San Lorenzo", 5));
		assertTrue(argentina.enviarALaBatalla("San Lorenzo", 6));
		assertTrue(argentina.enviarALaBatalla("San Lorenzo", 7));		
	}

	@Test
	public void queSePuedaPresentarBatallaNaval() throws VehiculoInexistente, VehiculoIncompatible {
		FuerzaArmada argentina = new FuerzaArmada("Ejercito Argentino");

		argentina.agregarVehiculo(new Submarino(8, "A-10"));
		argentina.agregarVehiculo(new Portaviones(9, "A-10"));
		argentina.agregarVehiculo(new Destructor(10, "A-10"));
		argentina.agregarVehiculo(new Destructor(11, "A-10"));
		argentina.agregarVehiculo(new Hidroavion(12, "A-10"));
		argentina.agregarVehiculo(new Anfibio(13, "A-10"));

		
		argentina.crearBatalla("Pacifico", TipoDeBatalla.ACUATICA, 200.5, 45.8);

		assertTrue(argentina.enviarALaBatalla("Pacifico", 8));
		assertTrue(argentina.enviarALaBatalla("Pacifico", 9));
		assertTrue(argentina.enviarALaBatalla("Pacifico", 10));
		assertTrue(argentina.enviarALaBatalla("Pacifico", 11));
		assertTrue(argentina.enviarALaBatalla("Pacifico", 12));
		assertTrue(argentina.enviarALaBatalla("Pacifico", 13));	
	}

	@Test (expected = VehiculoIncompatible.class)
	public void queSeNoSePuedaEnviarAUnaBatallaEnTierraUnBarco() throws VehiculoInexistente, VehiculoIncompatible {
		
		FuerzaArmada argentina = new FuerzaArmada("Ejercito Argentino");

		argentina.agregarVehiculo(new Tanque(5, "Renault FT"));
		argentina.agregarVehiculo(new Camion(6, "T-72"));
		argentina.agregarVehiculo(new Camion(7, "T-72"));
		argentina.agregarVehiculo(new Destructor(11, "A-10"));

		argentina.crearBatalla("San Lorenzo", TipoDeBatalla.TERRESTRE, 100.5, 20.3);
		argentina.enviarALaBatalla("San Lorenzo", 11);
		
		

	}

	@Test (expected = VehiculoInexistente.class)
	public void queSeNoSePuedaEnviarAUnaBatallaUnVehiculoQueNoExista() throws VehiculoInexistente, VehiculoIncompatible {
		FuerzaArmada argentina = new FuerzaArmada("Ejercito Argentino");

		argentina.agregarVehiculo(new Tanque(5, "Renault FT"));
		argentina.agregarVehiculo(new Camion(6, "T-72"));
		argentina.agregarVehiculo(new Camion(7, "T-72"));
		argentina.agregarVehiculo(new Destructor(11, "A-10"));

		argentina.crearBatalla("San Lorenzo", TipoDeBatalla.TERRESTRE, 100.5, 20.3);

		assertFalse(argentina.enviarALaBatalla("San Lorenzo", 4));
	}

}
