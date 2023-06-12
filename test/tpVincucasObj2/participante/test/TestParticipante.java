package tpVincucasObj2.participante.test;

import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpVinchucasObj2.filtros.PorFecha;
import tpVinchucasObj2.participantes.Dinamico;

import tpVinchucasObj2.sistema.Sistema;
import tpVinchucasObj2.ubicacion.Ubicacion;

class TestParticipante {
	
	Dinamico willyWonka;
	Sistema sistemVinchu;
	Ubicacion buenosAires;
	PorFecha filtroXFecha;

	@BeforeEach
	void setUp() throws Exception {
		sistemVinchu = new Sistema(filtroXFecha);
		willyWonka = new Dinamico("Tomas",sistemVinchu );
	
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

}
