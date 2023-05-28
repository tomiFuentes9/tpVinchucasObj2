package tpVinchucasObj2.muestra.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpVinchucasObj2.muestra.*;


class TestMuestra {

	@BeforeEach
	void setUp() throws Exception {
		//Hacer mocks de Participante y opiniones
		
		Muestra muestra1 = new Muestra("foto.jpg", "ver como poner fecha", Sordida,
				miguel);
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
