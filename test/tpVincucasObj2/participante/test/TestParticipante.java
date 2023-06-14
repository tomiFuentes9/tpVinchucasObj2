package tpVincucasObj2.participante.test;

import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpVinchucasObj2.filtros.PorFecha;
import tpVinchucasObj2.muestra.EspecieVinchuca;
import tpVinchucasObj2.muestra.Muestra;
import tpVinchucasObj2.opinion.TipoOpinion;
import tpVinchucasObj2.participantes.Dinamico;

import tpVinchucasObj2.sistema.Sistema;
import tpVinchucasObj2.ubicacion.Ubicacion;

class TestParticipante {
	
	Dinamico willyWonka;
	Dinamico teela;
		
	Sistema sistemVinchu;
	
	Ubicacion buenosAires;
	Ubicacion laPlata;
	Ubicacion quilmes;
	Ubicacion posadas;
	
	PorFecha filtroXFecha;
	
	Muestra muestra1;
	Muestra muestra2;
	Muestra muestra3;
	Muestra muestra4;
	
	@BeforeEach
	void setUp() throws Exception {
		sistemVinchu = new Sistema(filtroXFecha);
		
		willyWonka = new Dinamico("Tomas",sistemVinchu);
		teela = new Dinamico("Marcela",sistemVinchu);
	
		//buenosAires = mock(Ubicacion.class);
		buenosAires = new Ubicacion(-34.61315, -58.37723);
		laPlata     = new Ubicacion(-34.92145, -57.95453);
		quilmes     = new Ubicacion(-34.72904, -58.26374);
		posadas     = new Ubicacion(-27.36708, -55.89608);
		
		
		muestra1 = new Muestra("imagenA.jpg",EspecieVinchuca.Infestans, buenosAires);
		muestra2 = new Muestra("imagenB.bmp",EspecieVinchuca.Guasayana, laPlata);
		muestra3 = new Muestra("imagenC.bmp",EspecieVinchuca.Sordida, quilmes);
		muestra4 = new Muestra("imagenD.jpg",EspecieVinchuca.Infestans, laPlata);
	}

	@Test
	void nombreTest() {
		assertEquals("Tomas",willyWonka.getNombre());
		
	}
	
	@Test
	void estadoInicalBasico() {
		assertEquals("Basico",willyWonka.estado());
		
	}
	@Test
	void cargarMuestras(){
		willyWonka.agregarMuestra(muestra1);
		willyWonka.agregarMuestra(muestra3);
		willyWonka.agregarMuestra(muestra4);
		
		assertEquals(3,willyWonka.getMisMuestras().size());
		
	}
	@Test
	void opinarMuestra(){
		willyWonka.opinarMuestra(muestra1, TipoOpinion.ChincheFoliada);
		willyWonka.opinarMuestra(muestra1, TipoOpinion.PhtiaChinche);// aca no deberia dar error
		assertEquals("Basico",willyWonka.estado());	
		
		assertEquals(2,willyWonka.getMisOpiniones().size());
	}
}
