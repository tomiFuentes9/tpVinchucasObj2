package tpVincucasObj2.participante.test;

import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.mock;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpVinchucasObj2.muestra.EspecieVinchuca;
import tpVinchucasObj2.muestra.Muestra;
import tpVinchucasObj2.opinion.Opinion;
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
	
	Opinion opinion1;
	Opinion opinion2;
	Opinion opinion3;
	Opinion opinion4;
	Opinion opinion5;
	Opinion opinion6;
	Opinion opinion7;
	Opinion opinion8;
	Opinion opinion9;
	Opinion opinion10;
	
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		
		willyWonka = new Dinamico("Tomas"); // instancio un participante con estado basico
		

		
		
		
		
		teela = new ExpertoExterno("Marcela"); // instancio un participante Experto Externo
	
		
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
		willyWonka.incorpararMuestra(muestra1);
		willyWonka.incorpararMuestra(muestra2);
		willyWonka.incorpararMuestra(muestra3);
		willyWonka.incorpararMuestra(muestra4);
		willyWonka.incorpararMuestra(muestra5);
		willyWonka.incorpararMuestra(muestra6);
		willyWonka.incorpararMuestra(muestra7);
		willyWonka.incorpararMuestra(muestra8);
		willyWonka.incorpararMuestra(muestra9);
		willyWonka.incorpararMuestra(muestra10);
		willyWonka.incorpararMuestra(muestra11);	
		
		// Le agregamos al participante teela un par de muestras
		teela.incorpararMuestra(muestra12);
		teela.incorpararMuestra(muestra13);
		teela.incorpararMuestra(muestra14);
		teela.incorpararMuestra(muestra15);
		teela.incorpararMuestra(muestra16);
		teela.incorpararMuestra(muestra17);
		teela.incorpararMuestra(muestra18);
		teela.incorpararMuestra(muestra19);
		teela.incorpararMuestra(muestra20);
		teela.incorpararMuestra(muestra21);
		teela.incorpararMuestra(muestra22);
		
		opinion1 = new Opinion(TipoOpinion.ImagenPocoClara);
		opinion2 = new Opinion(TipoOpinion.ChincheFoliada);
		opinion3 = new Opinion(TipoOpinion.PhtiaChinche);
		opinion4 = new Opinion(TipoOpinion.ImagenPocoClara);
		opinion5 = new Opinion(TipoOpinion.Vinchuca);
		opinion6 = new Opinion(TipoOpinion.ChincheFoliada);
		opinion7 = new Opinion(TipoOpinion.PhtiaChinche);
		opinion8 = new Opinion(TipoOpinion.ImagenPocoClara);
		opinion9 = new Opinion(TipoOpinion.Vinchuca);
		opinion10 = new Opinion(TipoOpinion.ChincheFoliada);
		
		// el participante willyWonka opina sobre algunas muestras
		willyWonka.opinarMuestra(muestra1, opinion1);
		willyWonka.opinarMuestra(muestra2, opinion2);
		willyWonka.opinarMuestra(muestra3, opinion3);
		willyWonka.opinarMuestra(muestra4, opinion4);
		willyWonka.opinarMuestra(muestra5, opinion5);
		willyWonka.opinarMuestra(muestra6, opinion6);
		willyWonka.opinarMuestra(muestra7, opinion7);
		willyWonka.opinarMuestra(muestra8, opinion8);
		willyWonka.opinarMuestra(muestra9, opinion9);
		willyWonka.opinarMuestra(muestra10, opinion10);
		
		// el participante willyWonka opina sobre algunas muestras
		teela.opinarMuestra(muestra1, opinion1);
		teela.opinarMuestra(muestra2, opinion2);
		teela.opinarMuestra(muestra3, opinion3);
		teela.opinarMuestra(muestra4, opinion4);
		teela.opinarMuestra(muestra5, opinion5);
		teela.opinarMuestra(muestra6, opinion6);
		teela.opinarMuestra(muestra7, opinion7);
		teela.opinarMuestra(muestra8, opinion8);
		teela.opinarMuestra(muestra9, opinion9);
		teela.opinarMuestra(muestra10, opinion10);
		

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
		//assertEquals(10,teela.getMisOpiniones().size());
	}
	@Test
	void verificarQueUnParticipanteBasicoPasaASerExperto(){	
		
		assertEquals("Basico",willyWonka.estado()); // Estado inicial de participante
		
		willyWonka.opinarMuestra(muestra11, opinion3);
		willyWonka.opinarMuestra(muestra12, opinion1);
		willyWonka.opinarMuestra(muestra13, opinion5);
		willyWonka.opinarMuestra(muestra14, opinion2);
		willyWonka.opinarMuestra(muestra15, opinion7);
		willyWonka.opinarMuestra(muestra16, opinion4);
		willyWonka.opinarMuestra(muestra17, opinion9);
		willyWonka.opinarMuestra(muestra18, opinion6);
		willyWonka.opinarMuestra(muestra19, opinion7);
		willyWonka.opinarMuestra(muestra20, opinion8);
		
		assertEquals(11,willyWonka.getMisMuestras().size());
		assertEquals(20,willyWonka.getMisOpiniones().size());
		
		assertEquals("Experto",willyWonka.estado());
	}
	@Test
	void verificarQueUnParticipanteExpertoPasaASerBasico(){	
		
		assertEquals("Basico",willyWonka.estado()); // Estado inicial de participante
		
		willyWonka.opinarMuestra(muestra11, opinion3);
		willyWonka.opinarMuestra(muestra12, opinion1);
		willyWonka.opinarMuestra(muestra13, opinion5);
		willyWonka.opinarMuestra(muestra14, opinion2);
		willyWonka.opinarMuestra(muestra15, opinion7);
		willyWonka.opinarMuestra(muestra16, opinion4);
		willyWonka.opinarMuestra(muestra17, opinion9);
		willyWonka.opinarMuestra(muestra18, opinion6);
		willyWonka.opinarMuestra(muestra19, opinion7);
		willyWonka.opinarMuestra(muestra20, opinion8);
		
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
		
		teela.opinarMuestra(muestra11, opinion3);
		teela.opinarMuestra(muestra12, opinion1);
		teela.opinarMuestra(muestra13, opinion5);
		teela.opinarMuestra(muestra14, opinion2);
		teela.opinarMuestra(muestra15, opinion7);
		teela.opinarMuestra(muestra16, opinion4);
		teela.opinarMuestra(muestra17, opinion9);
		teela.opinarMuestra(muestra18, opinion6);
		teela.opinarMuestra(muestra19, opinion7);
		teela.opinarMuestra(muestra20, opinion8);
		
		//assertEquals(20,teela.getMisOpiniones().size());
		assertEquals(11,teela.getMisMuestras().size());
		
		teela.getEstadoParticipante().cambiarEstado(teela);
		
		assertEquals("Experto",teela.estado());
	}

	
	
}
