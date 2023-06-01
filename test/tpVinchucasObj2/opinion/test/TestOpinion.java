package tpVinchucasObj2.opinion.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpVinchucasObj2.opinion.Opinion;
import tpVinchucasObj2.opinion.TipoOpinion;

class TestOpinion {


	Opinion opinion1;
	Opinion opinion2;
	Opinion opinion3;
	

	@BeforeEach
	void setUp() throws Exception {
		opinion1 = new Opinion("Basico",TipoOpinion.ImagenPocoClara);
		opinion2 = new Opinion("Basico",TipoOpinion.Vinchuca);
		opinion3 = new Opinion("Experto",TipoOpinion.Vinchuca);
	}

	@Test
	void test() {
		System.out.print(opinion1.getFechaCreacion());
		
		//assertEquals(27,opinion1.getFechaCreacion().getDay());
	}

}
