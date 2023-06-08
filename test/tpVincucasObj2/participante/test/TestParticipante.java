package tpVincucasObj2.participante.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpVinchucasObj2.participantes.Participante;

class TestParticipante {
	
	Participante willyWonka;

	@BeforeEach
	void setUp() throws Exception {
		willyWonka = new Participante("Tomas");
		
	}

	@Test
	void nombreTest() {
		assertEquals("Tomas",willyWonka.getNombre());
		
	}
	
	@Test
	void estadoInicalBasico() {
		assertEquals("Basico",willyWonka.estado());
		
	}
}
