package tpVincucasObj2.participante.test;

import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpVinchucasObj2.filtros.PorFecha;
import tpVinchucasObj2.muestra.EspecieVinchuca;
import tpVinchucasObj2.muestra.Muestra;
import tpVinchucasObj2.opinion.TipoOpinion;
import tpVinchucasObj2.participantes.Dinamico;
import tpVinchucasObj2.participantes.ExpertoExterno;
import tpVinchucasObj2.sistema.Sistema;
import tpVinchucasObj2.ubicacion.Ubicacion;

class TestParticipante {
	
	Dinamico willyWonka;
	ExpertoExterno teela;
		
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
	Muestra muestra11;
	Muestra muestra12;
	Muestra muestra13;
	Muestra muestra14;
	Muestra muestra15;
	Muestra muestra16;
	Muestra muestra17;
	Muestra muestra18;
	Muestra muestra19;
	Muestra muestra20;
	
	@BeforeEach
	void setUp() throws Exception {
		sistemVinchu = new Sistema(filtroXFecha);
		
		willyWonka = new Dinamico("Tomas",sistemVinchu); // instancio un participante con estado basico
		
		teela = new ExpertoExterno("Marcela",sistemVinchu); // instancio un participante Experto Externo
	
		//buenosAires = mock(Ubicacion.class);
		buenosAires = new Ubicacion(-34.61315, -58.37723);
		laPlata     = new Ubicacion(-34.92145, -57.95453);
		quilmes     = new Ubicacion(-34.72904, -58.26374);
		posadas     = new Ubicacion(-27.36708, -55.89608);
		cordoba     = new Ubicacion(-31.41350, -64.18105);
		montevideo  = new Ubicacion(-34.90328, -56.18816);
		
		

		muestra1  = new Muestra("imagenA.jpg",EspecieVinchuca.Infestans,buenosAires);
		muestra2  = new Muestra("imagenB.jpg",EspecieVinchuca.Sordida,laPlata);
		muestra3  = new Muestra("imagenC.bmp",EspecieVinchuca.Guasayana,quilmes);
		muestra4  = new Muestra("imagenD.jpg",EspecieVinchuca.Infestans,posadas);
		muestra5  = new Muestra("imagenE.jpg",EspecieVinchuca.Sordida,cordoba);
		muestra6  = new Muestra("imagenF.jpg",EspecieVinchuca.Guasayana,montevideo);
		muestra7  = new Muestra("imagenG.jpg",EspecieVinchuca.Infestans,buenosAires);
		muestra8  = new Muestra("imagenH.jpg",EspecieVinchuca.Sordida,laPlata);
		muestra9  = new Muestra("imagenI.jpg",EspecieVinchuca.Guasayana,quilmes);
		muestra10 = new Muestra("imagenJ.jpg",EspecieVinchuca.Infestans,posadas);
		muestra11 = new Muestra("imagenK.jpg",EspecieVinchuca.Sordida,cordoba);
		muestra12 = new Muestra("imagenL.jpg",EspecieVinchuca.Guasayana,montevideo);
		muestra13 = new Muestra("imagenM.jpg",EspecieVinchuca.Infestans,buenosAires);
		muestra14 = new Muestra("imagenN.jpg",EspecieVinchuca.Sordida,laPlata);
		muestra15 = new Muestra("imagenO.jpg",EspecieVinchuca.Guasayana,quilmes);
		muestra16 = new Muestra("imagenP.jpg",EspecieVinchuca.Infestans,posadas);
		muestra17 = new Muestra("imagenQ.jpg",EspecieVinchuca.Sordida,cordoba);
		muestra18 = new Muestra("imagenR.jpg",EspecieVinchuca.Guasayana,montevideo);
		muestra19 = new Muestra("imagenS.jpg",EspecieVinchuca.Infestans,buenosAires);
		muestra20 = new Muestra("imagenT.jpg",EspecieVinchuca.Sordida,laPlata);
		
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
		willyWonka.agregarMuestra(muestra11);	
		
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
		
		assertEquals(11,willyWonka.getMisMuestras().size());
		
	}
	@Test
	void opinarMuestra(){		
		assertEquals(11,willyWonka.getMisOpiniones().size());
	}
	@Test
	void pasarDeBasicoAExperto(){	
		
		willyWonka.opinarMuestra(muestra11, TipoOpinion.PhtiaChinche);
		willyWonka.opinarMuestra(muestra12, TipoOpinion.ImagenPocoClara);
		willyWonka.opinarMuestra(muestra13, TipoOpinion.Vinchuca);
		willyWonka.opinarMuestra(muestra14, TipoOpinion.ChincheFoliada);
		willyWonka.opinarMuestra(muestra15, TipoOpinion.PhtiaChinche);
		willyWonka.opinarMuestra(muestra16, TipoOpinion.ImagenPocoClara);
		willyWonka.opinarMuestra(muestra17, TipoOpinion.Vinchuca);
		willyWonka.opinarMuestra(muestra18, TipoOpinion.ChincheFoliada);
		willyWonka.opinarMuestra(muestra19, TipoOpinion.PhtiaChinche);
		willyWonka.opinarMuestra(muestra20, TipoOpinion.ImagenPocoClara);
		
		assertEquals("Experto",willyWonka.estado());
	}
	@Test
	void pasarDeExpertoABasico(){	
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaVieja = LocalDate.parse("12/05/2023",fmt);
		willyWonka.getMisOpiniones().get(0).setFechaCreacion(fechaVieja);
		// al cambiarle la fecha al opinion en la posicision 0, el participante deja de 
		// tener 20 opiniones en el ultimo mes por lo cual vuelve al estado Basico
		
		assertEquals("Basico",willyWonka.estado());
	}
	
}
