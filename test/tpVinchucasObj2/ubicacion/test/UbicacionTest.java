package tpVinchucasObj2.ubicacion.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpVinchucasObj2.ubicacion.Ubicacion;

class UbicacionTest {


	Ubicacion ubicacion1 ;
	Ubicacion ubicacion2 ;
	Ubicacion ubicacion3 ;
	Ubicacion ubicacion4 ;
	Ubicacion ubicacion5 ;
	Ubicacion ubicacion6 ;
	
	Ubicacion ubicacionAComparar;
	
	List<Ubicacion> listaDeUbicaciones ;
	
	Muestra muestraParaComparar ;
	@BeforeEach
	void setUp() throws Exception {
		listaDeUbicaciones = new ArrayList<Ubicacion>();
		// agregar todas las ubicacioens a la lista de ubicaciones creadalistaDeUbicaciones.stream().toArray()
		listaDeUbicaciones.add(ubicacion1);
		listaDeUbicaciones.add(ubicacion2);
		listaDeUbicaciones.add(ubicacion3);
		listaDeUbicaciones.add(ubicacion4);
		listaDeUbicaciones.add(ubicacion5);
		listaDeUbicaciones.add(ubicacion6);
		
		
	}
	
	@Test
	void distanciaConTest() {
		assertEquals(0/*Distancia resultado*/,ubicacionAComparar.distanciaCon(ubicacion1));
	}

	@Test
	void aXDistanciaTest() {
		
		assertEquals(0/*Lista resultante*/,ubicacionAComparar.aXDistancia(listaDeUbicaciones, 0 /*Distancia*/));
	}
	
	@Test
	void muestraAXMetrosTest() {
		fail("Not yet implemented");
	}
	
	@Test
	void muestraAXKilometrosTest() {
		fail("Not yet implemented");
	}

}
