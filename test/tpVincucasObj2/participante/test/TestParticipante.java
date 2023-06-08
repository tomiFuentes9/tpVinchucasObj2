package tpVincucasObj2.participante.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpVinchucasObj2.muestra.EspecieVinchuca;
import tpVinchucasObj2.participantes.Participante;
import tpVinchucasObj2.sistema.Sistema;
import tpVinchucasObj2.ubicacion.Ubicacion;

class TestParticipante {
	
	Participante willyWonka;
	Sistema sistemVinchu;
	Ubicacion buenosAires;

	@BeforeEach
	void setUp() throws Exception {
		sistemVinchu = new Sistema();
		willyWonka = new Participante("Tomas",sistemVinchu );
	
		//buenosAires = mock(Ubicacion.class);
		buenosAires = new Ubicacion(-34.61315, -58.37723);
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
	void enviarMuestra() {
		assertEquals(0,sistemVinchu.getMuestras().size());
		willyWonka.enviarMuestra("tomasEnPijamas.jpg", EspecieVinchuca.Infestans,buenosAires);
		assertEquals(1,sistemVinchu.getMuestras().size());
		
	}
}
