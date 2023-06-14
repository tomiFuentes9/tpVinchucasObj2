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
	Ubicacion cordoba;
	Ubicacion montevideo;
	
	PorFecha filtroXFecha;
	
	Muestra muestra1;
	Muestra muestra2;
	Muestra muestra3;
	Muestra muestra4;
	Muestra muestra5;
	Muestra muestra6;
	Muestra muestra7;
	Muestra muestra8;
	Muestra muestra9;
	Muestra muestra10;
	
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
		cordoba     = new Ubicacion(-31.41350, -64.18105);
		montevideo  = new Ubicacion(-34.90328, -56.18816);
		
		
		muestra1  = new Muestra("imagenA.jpg",EspecieVinchuca.Infestans,buenosAires);
		muestra2  = new Muestra("imagenB.bmp",EspecieVinchuca.Sordida,laPlata);
		muestra3  = new Muestra("imagenC.bmp",EspecieVinchuca.Guasayana,quilmes);
		muestra4  = new Muestra("imagenD.jpg",EspecieVinchuca.Infestans,posadas);
		muestra5  = new Muestra("imagenE.jpg",EspecieVinchuca.Sordida,cordoba);
		muestra6  = new Muestra("imagenF.jpg",EspecieVinchuca.Guasayana,montevideo);
		muestra7  = new Muestra("imagenF.jpg",EspecieVinchuca.Infestans,buenosAires);
		muestra8  = new Muestra("imagenG.jpg",EspecieVinchuca.Sordida,laPlata);
		muestra9  = new Muestra("imagenH.jpg",EspecieVinchuca.Guasayana,quilmes);
		muestra10 = new Muestra("imagenI.jpg",EspecieVinchuca.Infestans,posadas);
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
		willyWonka.agregarMuestra(muestra2);
		willyWonka.agregarMuestra(muestra3);
		willyWonka.agregarMuestra(muestra4);
		willyWonka.agregarMuestra(muestra5);
		willyWonka.agregarMuestra(muestra6);
		willyWonka.agregarMuestra(muestra7);
		willyWonka.agregarMuestra(muestra8);
		willyWonka.agregarMuestra(muestra9);
		willyWonka.agregarMuestra(muestra10);
		
		assertEquals(10,willyWonka.getMisMuestras().size());
		
	}
	@Test
	void opinarMuestra(){
		willyWonka.opinarMuestra(muestra1, TipoOpinion.ImagenPocoClara);
		willyWonka.opinarMuestra(muestra1, TipoOpinion.Vinchuca);// aca no deberia dar error
		willyWonka.opinarMuestra(muestra2, TipoOpinion.ChincheFoliada);
		willyWonka.opinarMuestra(muestra3, TipoOpinion.PhtiaChinche);
		willyWonka.opinarMuestra(muestra4, TipoOpinion.ImagenPocoClara);
		willyWonka.opinarMuestra(muestra5, TipoOpinion.Vinchuca);
		willyWonka.opinarMuestra(muestra6, TipoOpinion.ChincheFoliada);
		willyWonka.opinarMuestra(muestra7, TipoOpinion.PhtiaChinche);
		willyWonka.opinarMuestra(muestra8, TipoOpinion.ImagenPocoClara);
		willyWonka.opinarMuestra(muestra9, TipoOpinion.Vinchuca);
		willyWonka.opinarMuestra(muestra10, TipoOpinion.ChincheFoliada);
		
		
		assertEquals("Basico",willyWonka.estado());	
		
		assertEquals(11,willyWonka.getMisOpiniones().size());
	}
}
