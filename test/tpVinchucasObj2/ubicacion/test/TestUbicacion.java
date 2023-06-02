package tpVinchucasObj2.ubicacion.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpVinchucasObj2.muestra.Muestra;
import tpVinchucasObj2.ubicacion.Ubicacion;

class TestUbicacion {


	Ubicacion buenosAires ;
	Ubicacion laPlata ;
	Ubicacion montevideo ;
	Ubicacion quilmes ;
	Ubicacion cordoba ;
	Ubicacion posadas ;
	
	
	List<Ubicacion> listaDeUbicaciones ;
	
	Muestra muestraParaComparar ;
	
	Muestra muestra1 ;
	Muestra muestra2 ;
	Muestra muestra3 ;
	Muestra muestra4 ;
	
	
	@BeforeEach
	void setUpUbicaciones() {
		// creamos diferentes ubicaciones
		quilmes     = new Ubicacion(-34.72904, -58.26374);
		
		buenosAires = new Ubicacion(-34.61315, -58.37723);
		laPlata     = new Ubicacion(-34.92145, -57.95453);
		montevideo  = new Ubicacion(-34.90328, -56.18816);
		cordoba     = new Ubicacion(-31.41350, -64.18105);
		posadas     = new Ubicacion(-27.36708, -55.89608);
		
		
	}
	@BeforeEach
	void setUpListaUbicaciones() {
		listaDeUbicaciones = new ArrayList<Ubicacion>();
		// agregar todas las ubicacioens a la lista de ubicaciones creadalistaDeUbicaciones.stream().toArray()
		listaDeUbicaciones.add(buenosAires);
		listaDeUbicaciones.add(laPlata);
		listaDeUbicaciones.add(montevideo);
		listaDeUbicaciones.add(cordoba);
		listaDeUbicaciones.add(posadas);
		
		
	}
	
	@BeforeEach
	void setUpListaUbicaciones() {
		muestra1 = new Muestra();
		muestra2 = new Muestra() ;
		muestra3 = new Muestra() ;
		muestra4 = new Muestra() ;
	}
	
	
	@Test
	void distanciaConTest() {
		// las distancias son en linea recta desde una ubicacion a otra
		assertEquals(16,quilmes.distanciaCon(buenosAires),10);
		assertEquals(35,quilmes.distanciaCon(laPlata),10);
		assertEquals(190,quilmes.distanciaCon(montevideo),10);
		assertEquals(660,quilmes.distanciaCon(cordoba),10);
		assertEquals(850,quilmes.distanciaCon(posadas),10);
	}

	@Test
	void aXDistanciaTest() {
		List<Ubicacion> listaResultante = quilmes.aXDistancia(listaDeUbicaciones, 500);
		assertFalse(quilmes.aXDistancia(listaDeUbicaciones, 500).isEmpty());
		/*assertEquals(3,listaResultante.size());
		assertEquals(buenosAires,listaResultante.get(0));
		assertEquals(laPlata,listaResultante.get(1));
		assertEquals(montevideo,listaResultante.get(2));*/
	}
	
	
	@Test
	void muestraAXMetrosTest() {
		// Si este metodo se usa en ubicacion para que le paso una muestra ? Si le paso un muestra para que me sirve la ubicacion 
		//de donde es llamado el metodo ?
	}
	
	
}
