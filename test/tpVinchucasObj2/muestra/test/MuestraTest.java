package tpVinchucasObj2.muestra.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpVinchucasObj2.muestra.*;
import tpVinchucasObj2.opinion.*;
import tpVinchucasObj2.participantes.*;
import tpVinchucasObj2.sistema.*;
import tpVinchucasObj2.ubicacion.*;

class MuestraTest {
DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	Muestra sut;
	
	Participante crazyWally;
	Participante leanLove;
	Participante thomas;
	Participante michael;
	Ubicacion quilmes;
	Sistema vinchuPower;
	Opinion opinion1;
	Opinion opinion2;
	Opinion opinion3;
	HashMap<TipoOpinion, Integer> test;

	@BeforeEach
	void setUp() throws Exception {
		crazyWally = new Dinamico("Walter Norberto Gomez");
		leanLove = new Dinamico("Leandro Peppe");
		thomas = new ExpertoExterno("Tomas Fuentes");
		michael = new ExpertoExterno("Michael");
		quilmes = new Ubicacion(-34.72904, -58.26374);
		test = new HashMap<TipoOpinion, Integer>();
		
		
		opinion1 = new Opinion(TipoOpinion.ImagenPocoClara, new DatosDelCreador(crazyWally, new EstadoBasico()));
		
		test.put(TipoOpinion.ImagenPocoClara, 1);
		test.put(TipoOpinion.ChincheFoliada, 1);
		test.put(TipoOpinion.PhtiaChinche, 1);
		
		sut = new Muestra("foto.png", EspecieVinchuca.Sordida, quilmes);
		sut.setFechaCreacion(LocalDate.parse("01/05/2005",fmt));
		sut.aniadirOpinion(opinion1);
		
	}

	@Test
	void testVerificarMuestraSinDosOpsDeExps() {
		assertFalse(sut.getIsVerificada());
		sut.verificarMuestra();
		assertFalse(sut.getIsVerificada());
	}
	
	@Test
	void testVerificarMuestraConDosOpsDeExps() {
		assertFalse(sut.getIsVerificada());
		michael.opinarMuestra(sut, TipoOpinion.PhtiaChinche);
		thomas.opinarMuestra(sut, TipoOpinion.PhtiaChinche);
		sut.actualizarResultado();
		assertTrue(sut.getIsVerificada());
	}

	@Test
	void testActualizarResultadoEmpate() {
		assertEquals(TipoOpinion.NoDefinida, sut.getResultadoActual());
		thomas.opinarMuestra(sut, TipoOpinion.PhtiaChinche);
		sut.actualizarResultado();
		assertEquals(TipoOpinion.NoDefinida, sut.getResultadoActual());
	}
	
	@Test
	void testActualizarResultadoPhtiaCh() {
		assertEquals(TipoOpinion.NoDefinida, sut.getResultadoActual());
		michael.opinarMuestra(sut, TipoOpinion.PhtiaChinche);
		thomas.opinarMuestra(sut, TipoOpinion.PhtiaChinche);
		sut.actualizarResultado();
		assertEquals(TipoOpinion.PhtiaChinche, sut.getResultadoActual());
	}

	@Test
	void testAniadirOpinionMuestraNoVerificada() {
		assertEquals(1, sut.getOpiniones().size());
		leanLove.opinarMuestra(sut, TipoOpinion.ChincheFoliada);
		assertEquals(2,sut.getOpiniones().size());
	}
	
	@Test
	void testAniadirOpinionMuestraVerificada() {
		assertEquals(1, sut.getOpiniones().size());
		thomas.opinarMuestra(sut, TipoOpinion.ImagenPocoClara);
		try {
			leanLove.opinarMuestra(sut, TipoOpinion.ChincheFoliada);;
		   }
		   catch (Exception e) {
		      e.getMessage();//Para imprimir el error si se quiere
		   }
	}
	
	@Test
	void testAniadirOpinionOpinoParticipante() {
		assertEquals(1, sut.getOpiniones().size());
		leanLove.opinarMuestra(sut, TipoOpinion.ChincheFoliada);
		assertEquals(2,sut.getOpiniones().size());
		try {
			leanLove.opinarMuestra(sut, TipoOpinion.ImagenPocoClara);;
		   }
		   catch (Exception e) {
		      System.out.print(e.getMessage());//Para imprimir el error si se quiere
		   }
	}

}
