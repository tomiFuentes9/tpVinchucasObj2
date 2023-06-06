package tpVinchucasObj2.ubicacion.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpVinchucasObj2.muestra.EspecieVinchuca;
import tpVinchucasObj2.muestra.Muestra;
import tpVinchucasObj2.participantes.Participante;
import tpVinchucasObj2.ubicacion.Ubicacion;

class TestUbicacion {


	Ubicacion buenosAires ;
	Ubicacion laPlata ;
	Ubicacion montevideo ;
	Ubicacion quilmes ;
	Ubicacion cordoba ;
	Ubicacion posadas ;
	
	
	List<Ubicacion> listaDeUbicaciones ;
	List<Muestra> listaDeMuestras ;
	
	Muestra muestraParaComparar ;
	
	Muestra muestra1 ;
	Muestra muestra2 ;
	Muestra muestra3 ;
	Muestra muestra4 ;
	
	Participante participante1 ;
	
	
	@BeforeEach
	void setUp() {
		// creamos diferentes ubicaciones
		//Quilmes es la ubicacion central la cual vamos a realizar comparaciones y otras cosas.
		quilmes     = new Ubicacion(-34.72904, -58.26374);
		
		//5 Ubicaciones que van a ser comparables con Quilmes
		buenosAires = new Ubicacion(-34.61315, -58.37723);
		laPlata     = new Ubicacion(-34.92145, -57.95453);
		montevideo  = new Ubicacion(-34.90328, -56.18816);
		cordoba     = new Ubicacion(-31.41350, -64.18105);
		posadas     = new Ubicacion(-27.36708, -55.89608);
		
		
		// Creamos una lista de ubicaciones para poder compararlas.
		listaDeUbicaciones = new ArrayList<Ubicacion>();
		List<Ubicacion> listaDeUbicaciones = Arrays.asList(buenosAires,laPlata,montevideo,cordoba,posadas);
		// Agregamos todas las ubicacioens a la lista de ubicaciones creadalistaDeUbicaciones.stream().toArray()
		listaDeUbicaciones.add(buenosAires);
		listaDeUbicaciones.add(laPlata);
		listaDeUbicaciones.add(montevideo);
		listaDeUbicaciones.add(cordoba);
		listaDeUbicaciones.add(posadas);
		
		// Parcipante 
		
		participante1 = mock(Participante.class);
		
		// Instanciamos 4 muestras que van a ser comparas con la muestraParaComparar 
		// La muestra 1 y 2 van a estar cerca de la muestra a comparar. La Muestra 3 y 4 no 
		
		muestraParaComparar = new Muestra("Foto", EspecieVinchuca.Infestans ,participante1, buenosAires);
		
		muestra1 = new Muestra("Foto", EspecieVinchuca.Infestans ,participante1, posadas);
		muestra2 = new Muestra("Foto", EspecieVinchuca.Infestans ,participante1, laPlata);
		muestra3 = new Muestra("Foto", EspecieVinchuca.Infestans ,participante1, montevideo);
		muestra4 = new Muestra("Foto", EspecieVinchuca.Infestans ,participante1, cordoba);
		
		
		listaDeMuestras = new ArrayList<Muestra>();
		List<Muestra> listaDeMuestras = Arrays.asList(muestra1,muestra2,muestra3,muestra4);
		
		
		
		
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
		
		assertFalse(listaResultante.isEmpty());
		assertEquals(3,listaResultante.size());
		assertEquals(buenosAires,listaResultante.get(0));
		assertEquals(laPlata,listaResultante.get(1));
		assertEquals(montevideo,listaResultante.get(2));
	}
	
	
	@Test
	void muestraAXMetrosTest() {
		assertEquals(4,listaDeMuestras.size());
		// Si este metodo se usa en ubicacion para que le paso una muestra ? Si le paso un muestra para que me sirve la ubicacion 
		//de donde es llamado el metodo ?
		
		//muestra.muestraAXMetros( 500, todas las muestras del sistema);
			
						
	}
	
	
}
