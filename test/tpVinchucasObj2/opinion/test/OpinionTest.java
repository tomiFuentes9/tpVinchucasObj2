package tpVinchucasObj2.opinion.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpVinchucasObj2.muestras.opinion.Opinion;

class TestOpinion {


	Opinion opinion1;
	Opinion opinion2;
	Opinion opinion3;
	

	@BeforeEach
	void setUp() throws Exception {
		opinion1 = new Opinion("Basico");
		opinion2 = new Opinion("Basico");
		opinion3 = new Opinion("Experto");
	}

	@Test
	void test() {
		System.out.print(opinion1.getFechaCreacion());
		
		//assertEquals(27,opinion1.getFechaCreacion().getDay());
	}

}
