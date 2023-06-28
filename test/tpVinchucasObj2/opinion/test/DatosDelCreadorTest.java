package tpVinchucasObj2.opinion.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpVinchucasObj2.filtros.Filtro;
import tpVinchucasObj2.opinion.DatosDelCreador;
import tpVinchucasObj2.participantes.Dinamico;
import tpVinchucasObj2.participantes.ExpertoExterno;
import tpVinchucasObj2.participantes.Participante;
import tpVinchucasObj2.sistema.Sistema;

class DatosDelCreadorTest {
	
	Sistema sistema;
	Filtro filtro;
	
	Participante participante1 ;
	Participante participante2 ;
	
	DatosDelCreador datos1;
	DatosDelCreador datos2;
	
	
	@BeforeEach
	void setUp() throws Exception {
		
		sistema = new Sistema();
		
		sistema.crearParticipanteDinamico("Leandro");
		sistema.crearParticipanteExterno("Tomas");
		
		participante1 = sistema.getParticipantes().get(0);
		participante2 = sistema.getParticipantes().get(1); 
		
		datos1 = new DatosDelCreador();
		datos2 = new DatosDelCreador();
		
	}

	@Test
	void testGetParticipante() {
		datos1.setCreador(participante1);
		datos2.setCreador(participante2);
		assertEquals(participante1,datos1.getParticipante());
		assertEquals(participante2,datos2.getParticipante());
	}
	

	@Test
	void testEstadoDeParticipante() {
		datos1.setEstadoParticipante(participante1.getEstadoParticipante());
		datos2.setEstadoParticipante(participante2.getEstadoParticipante());
		assertEquals("Basico",datos1.estadoDeParticipante().estado());
		assertEquals("Experto",datos2.estadoDeParticipante().estado());
	}

}
