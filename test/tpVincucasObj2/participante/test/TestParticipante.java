package tpVincucasObj2.participante.test;

import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpVinchucasObj2.muestra.EspecieVinchuca;
import tpVinchucasObj2.muestra.Muestra;
import tpVinchucasObj2.opinion.TipoOpinion;
import tpVinchucasObj2.participantes.Dinamico;
import tpVinchucasObj2.participantes.ExpertoExterno;

import tpVinchucasObj2.ubicacion.Ubicacion;

class TestParticipante {
	
	// Declaracion de Participantes
	Dinamico willyWonka;
	ExpertoExterno teela;
		
	// Declaracion de ubicaciones	
	Ubicacion buenosAires;
	Ubicacion laPlata;
	Ubicacion quilmes;
	Ubicacion posadas;
	Ubicacion cordoba;
	Ubicacion montevideo;	
	
	// Declarcion de Muestras
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
	Muestra muestra21;
	Muestra muestra22;
	
	@BeforeEach
	void setUp() throws Exception {
		
		
		willyWonka = new Dinamico("Tomas"); // instancio un participante con estado basico
		
		teela = new ExpertoExterno("Marcela"); // instancio un participante Experto Externo
	
		//buenosAires = mock(Ubicacion.class);
		// instanciamos algunas ubicaciones
		buenosAires = new Ubicacion(-34.61315, -58.37723);
		laPlata     = new Ubicacion(-34.92145, -57.95453);
		quilmes     = new Ubicacion(-34.72904, -58.26374);
		posadas     = new Ubicacion(-27.36708, -55.89608);
		cordoba     = new Ubicacion(-31.41350, -64.18105);
		montevideo  = new Ubicacion(-34.90328, -56.18816);

		// instanciamos algunas muestras
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
		muestra21 = new Muestra("imagenUjpg",EspecieVinchuca.Guasayana,quilmes);
		muestra22 = new Muestra("imagenUjpg",EspecieVinchuca.Infestans,posadas);
		
		// Le agregamos al participante willyWonka un par de muestras
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
		
		// Le agregamos al participante teela un par de muestras
		teela.agregarMuestra(muestra12);
		teela.agregarMuestra(muestra13);
		teela.agregarMuestra(muestra14);
		teela.agregarMuestra(muestra15);
		teela.agregarMuestra(muestra16);
		teela.agregarMuestra(muestra17);
		teela.agregarMuestra(muestra18);
		teela.agregarMuestra(muestra19);
		teela.agregarMuestra(muestra20);
		teela.agregarMuestra(muestra21);
		teela.agregarMuestra(muestra22);
		
		// el participante willyWonka opina sobre algunas muestras
		willyWonka.opinarMuestra(muestra1, TipoOpinion.ImagenPocoClara);
		willyWonka.opinarMuestra(muestra2, TipoOpinion.ChincheFoliada);
		willyWonka.opinarMuestra(muestra3, TipoOpinion.PhtiaChinche);
		willyWonka.opinarMuestra(muestra4, TipoOpinion.ImagenPocoClara);
		willyWonka.opinarMuestra(muestra5, TipoOpinion.Vinchuca);
		willyWonka.opinarMuestra(muestra6, TipoOpinion.ChincheFoliada);
		willyWonka.opinarMuestra(muestra7, TipoOpinion.PhtiaChinche);
		willyWonka.opinarMuestra(muestra8, TipoOpinion.ImagenPocoClara);
		willyWonka.opinarMuestra(muestra9, TipoOpinion.Vinchuca);
		willyWonka.opinarMuestra(muestra10, TipoOpinion.ChincheFoliada);
		
		// el participante willyWonka opina sobre algunas muestras
		teela.opinarMuestra(muestra1, TipoOpinion.ImagenPocoClara);
		teela.opinarMuestra(muestra2, TipoOpinion.ChincheFoliada);
		teela.opinarMuestra(muestra3, TipoOpinion.PhtiaChinche);
		teela.opinarMuestra(muestra4, TipoOpinion.ImagenPocoClara);
		teela.opinarMuestra(muestra5, TipoOpinion.Vinchuca);
		teela.opinarMuestra(muestra6, TipoOpinion.ChincheFoliada);
		teela.opinarMuestra(muestra7, TipoOpinion.PhtiaChinche);
		teela.opinarMuestra(muestra8, TipoOpinion.ImagenPocoClara);
		teela.opinarMuestra(muestra9, TipoOpinion.Vinchuca);
		teela.opinarMuestra(muestra10, TipoOpinion.ChincheFoliada);
		

	}

	@Test
	void nombreDeLoParticipantes() {
		assertEquals("Tomas",willyWonka.getNombre());
		assertEquals("Marcela",teela.getNombre());
		
	}
	
	@Test
	void estadoInicalDeLosParticipantes() {
		
		assertEquals("Basico",willyWonka.estado());
		assertEquals("Experto",teela.estado());
		
	}
	@Test
	void cantidadDeMuestrasCargadas(){
		
		assertEquals(11,willyWonka.getMisMuestras().size());
		assertEquals(11,teela.getMisMuestras().size());
		
	}
	@Test
	void cantidadDeMuestrasOpinadas(){		
		assertEquals(10,willyWonka.getMisOpiniones().size());
		assertEquals(10,teela.getMisOpiniones().size());
	}
	@Test
	void verificarQueUnParticipanteBasicoPasaASerExperto(){	
		
		assertEquals("Basico",willyWonka.estado()); // Estado inicial de participante
		
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
		
		assertEquals(11,willyWonka.getMisMuestras().size());
		assertEquals(20,willyWonka.getMisOpiniones().size());
		
		assertEquals("Experto",willyWonka.estado());
	}
	@Test
	void verificarQueUnParticipanteExpertoPasaASerBasico(){	
		
		assertEquals("Basico",willyWonka.estado()); // Estado inicial de participante
		
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
		
		assertEquals(11,willyWonka.getMisMuestras().size());
		assertEquals(20,willyWonka.getMisOpiniones().size());
		
		
		assertEquals("Experto",willyWonka.estado()); // comprobamos que cambio de estado
		
		// cambiamos la fecha de algunas opiniones 
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaVieja = LocalDate.parse("12/05/2022",fmt);
		willyWonka.getMisOpiniones().get(0).setFechaCreacion(fechaVieja);
		willyWonka.getMisOpiniones().get(1).setFechaCreacion(fechaVieja);
		willyWonka.getMisOpiniones().get(2).setFechaCreacion(fechaVieja);
		willyWonka.getMisOpiniones().get(3).setFechaCreacion(fechaVieja);	
		
		assertEquals(fechaVieja,willyWonka.getMisOpiniones().get(0).getFechaCreacion());
		assertEquals(fechaVieja,willyWonka.getMisOpiniones().get(1).getFechaCreacion());
		
		willyWonka.getEstadoParticipante().cambiarEstado(willyWonka); // pedimos actualizar el estado del participante
		assertEquals("Basico",willyWonka.estado());
		
	}
	@Test
	void verificarQueUnParticipanteExpertoExternoNoCambiaSuEstado(){	
		
		teela.opinarMuestra(muestra11, TipoOpinion.PhtiaChinche);
		teela.opinarMuestra(muestra12, TipoOpinion.ImagenPocoClara);
		teela.opinarMuestra(muestra13, TipoOpinion.Vinchuca);
		teela.opinarMuestra(muestra14, TipoOpinion.ChincheFoliada);
		teela.opinarMuestra(muestra15, TipoOpinion.PhtiaChinche);
		teela.opinarMuestra(muestra16, TipoOpinion.ImagenPocoClara);
		teela.opinarMuestra(muestra17, TipoOpinion.Vinchuca);
		teela.opinarMuestra(muestra18, TipoOpinion.ChincheFoliada);
		teela.opinarMuestra(muestra19, TipoOpinion.PhtiaChinche);
		teela.opinarMuestra(muestra20, TipoOpinion.ImagenPocoClara);
		
		assertEquals(20,teela.getMisOpiniones().size());
		assertEquals(11,teela.getMisMuestras().size());
		
		teela.getEstadoParticipante().cambiarEstado(teela);
		
		assertEquals("Experto",teela.estado());
	}

	
	
}
