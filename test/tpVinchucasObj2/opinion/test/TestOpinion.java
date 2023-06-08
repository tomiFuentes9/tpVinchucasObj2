package tpVinchucasObj2.opinion.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpVinchucasObj2.opinion.Opinion;
import tpVinchucasObj2.opinion.TipoOpinion;
import tpVinchucasObj2.participantes.EstadoExperto;
import tpVinchucasObj2.participantes.Participante;

class TestOpinion {


	Opinion opinion1;
	Opinion opinion2;
	Opinion opinion3;
	
	Participante participante1;
	Participante participante2;
	Participante participante3;

	@BeforeEach
	void setUp() throws Exception {
		
		participante1 = new Participante("Leandro");
		participante2 = new Participante("Walter");
		
		participante3 = new Participante("Tomas"); 
		//participante3.actualizarEstado(new EstadoExperto(participante3) );
		
		
		opinion1 = new Opinion(TipoOpinion.ImagenPocoClara,participante1);
		opinion2 = new Opinion(TipoOpinion.Vinchuca,participante2);
		opinion3 = new Opinion(TipoOpinion.Vinchuca,participante3);
	}

	@Test
	void testTipo() {
		assertEquals(TipoOpinion.ImagenPocoClara,opinion1.getTipo());
		assertEquals(TipoOpinion.Vinchuca,opinion2.getTipo());
		assertEquals(TipoOpinion.Vinchuca,opinion3.getTipo());
	}
	
	@Test
	void testCreador() {
		assertEquals(participante1,opinion1.getCreador());
		assertEquals(participante2,opinion2.getCreador());
		assertEquals(participante3,opinion3.getCreador());
	}
	
	@Test
	void testNivelCreador() {
		assertEquals("Basico",opinion1.getEstadoDelCreador());
		assertEquals("Basico",opinion2.getEstadoDelCreador());
		//assertEquals("Experto",opinion3.getEstadoDelCreador());
	}
}
