package tpVinchucasObj2.opinion.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpVinchucasObj2.opinion.DatosDelCreador;
import tpVinchucasObj2.participantes.Dinamico;
import tpVinchucasObj2.participantes.ExpertoExterno;
import tpVinchucasObj2.participantes.Participante;
import tpVinchucasObj2.sistema.Sistema;

class DatosDelCreadorTest {
	
	Sistema sistema;
	
	Participante participante1 ;
	Participante participante2 ;
	
	DatosDelCreador datos1;
	DatosDelCreador datos2;
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		participante1 = new ExpertoExterno("Tomas",sistema); 
		participante2 = new Dinamico("Walter",sistema);
		
		datos1 = new DatosDelCreador(participante1,participante1.getEstadoParticipante());
		datos2 = new DatosDelCreador(participante2,participante2.getEstadoParticipante());
		
	}

	@Test
	void testGetParticipante() {
		assertEquals(participante1,datos1.getParticipante());
		assertEquals(participante2,datos2.getParticipante());
	}
	

	@Test
	void testEstadoDeParticipante() {
		assertEquals("Experto",datos1.estadoDeParticipante().estado());
		assertEquals("Basico",datos2.estadoDeParticipante().estado());
	}

}
