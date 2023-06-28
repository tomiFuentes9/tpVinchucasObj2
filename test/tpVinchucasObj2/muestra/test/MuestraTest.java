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
		
		
		opinion1 = new Opinion(TipoOpinion.ImagenPocoClara);
		
		opinion2 = new Opinion(TipoOpinion.PhtiaChinche);
		
		opinion3 = new Opinion(TipoOpinion.PhtiaChinche);
		
		sut = new Muestra("foto.png", EspecieVinchuca.Sordida, quilmes);
		sut.setFechaCreacion(LocalDate.parse("01/05/2005",fmt));

		
	}

	@Test
	void testVerificarMuestraSinDosOpsDeExps() {
		assertEquals("Inicial", sut.estadoActual());
		crazyWally.opinarMuestra(sut, opinion1);
		assertNotEquals("Verificada", sut.estadoActual());
	}
	
	@Test
	void testVerificarMuestraConDosOpsDeExps() {
		assertNotEquals("Verificada", sut.estadoActual());
		michael.opinarMuestra(sut, opinion2);
		thomas.opinarMuestra(sut, opinion3);
		assertEquals("Verificada", sut.estadoActual());
	}

	@Test
	void testActualizarResultadoEmpate() {
		assertEquals(TipoOpinion.NoDefinida, sut.getResultadoActual());
		thomas.opinarMuestra(sut, opinion3);
		assertEquals(TipoOpinion.NoDefinida, sut.getResultadoActual());
	}
	
	@Test
	void testActualizarResultadoPhtiaCh() {
		assertEquals(TipoOpinion.NoDefinida, sut.getResultadoActual());
		michael.opinarMuestra(sut, opinion2);
		thomas.opinarMuestra(sut, opinion3);
		assertEquals(TipoOpinion.PhtiaChinche, sut.getResultadoActual());
	}

	@Test
	void testAniadirOpinionMuestraNoVerificada() {
		crazyWally.opinarMuestra(sut, opinion2);
		assertEquals(1, sut.getOpiniones().size());
		leanLove.opinarMuestra(sut, opinion1);
		assertEquals(2,sut.getOpiniones().size());
	}
	
	@Test
	void testEstadoMuestraSemiVerificada() {
		crazyWally.opinarMuestra(sut, opinion2);
		assertEquals("Inicial", sut.estadoActual());
		michael.opinarMuestra(sut, opinion1);
		assertEquals("Semiverificada",sut.estadoActual());
	}
	
	@Test
	void testAniadirOpinionMuestraSemiVerificada() {
		thomas.opinarMuestra(sut, opinion2);
		assertEquals(1, sut.getOpiniones().size());
		try {
			leanLove.opinarMuestra(sut, opinion1);
		   }
		   catch (Exception e) {
		      e.getMessage();//Para imprimir el error si se quiere
		   }
	}
	
	@Test
	void testAniadirOpinionMuestraVerificada() {
		thomas.opinarMuestra(sut, opinion2);
		michael.opinarMuestra(sut, opinion3);
		assertEquals(2, sut.getOpiniones().size());
		
	}
	
	@Test
	void testEstadoVerificada() {
		thomas.opinarMuestra(sut, opinion2);
		michael.opinarMuestra(sut, opinion3);
		assertEquals(2, sut.getOpiniones().size());
		sut.getEstado().actualizarResultado(sut);
		sut.getEstado().verificarOpiniones(sut);
		sut.getEstado().cambiarEstado(sut);
		michael.cambiarEstado();		       //  Hecho para llamar metodos void que no son  
		michael.setEstadoParticipante(null);   // llamados a traves de otros metodos    
	}
	
	@Test
	void testAniadirOpinionOpinoParticipante() {
		crazyWally.opinarMuestra(sut, opinion2);
		assertEquals(1, sut.getOpiniones().size());
		leanLove.opinarMuestra(sut, opinion1);
		assertEquals(2,sut.getOpiniones().size());
	}

}
