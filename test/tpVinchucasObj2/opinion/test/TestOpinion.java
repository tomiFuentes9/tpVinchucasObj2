package tpVinchucasObj2.opinion.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpVinchucasObj2.filtros.Filtro;
import tpVinchucasObj2.muestra.EspecieVinchuca;
import tpVinchucasObj2.muestra.Muestra;
import tpVinchucasObj2.opinion.DatosDelCreador;
import tpVinchucasObj2.opinion.Opinion;
import tpVinchucasObj2.opinion.TipoOpinion;
import tpVinchucasObj2.participantes.Dinamico;
import tpVinchucasObj2.participantes.EstadoExperto;
import tpVinchucasObj2.participantes.ExpertoExterno;
import tpVinchucasObj2.participantes.Participante;
import tpVinchucasObj2.sistema.Sistema;
import tpVinchucasObj2.ubicacion.Ubicacion;

class TestOpinion {

	Sistema sistema;
	
	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	Opinion opinion1;
	Opinion opinion2;
	Opinion opinion3;
	
	Participante participante1;
	Participante participante2;
	Participante participante3;
	
	Muestra muestra ;
	
	Ubicacion posadas;

	@BeforeEach
	void setUp()  {
		
		sistema = new Sistema();
		
		sistema.crearParticipanteDinamico("Leandro");
		sistema.crearParticipanteDinamico("Walter");
		sistema.crearParticipanteExterno("Tomas");
		
		participante1 = sistema.getParticipantes().get(0);
		participante2 = sistema.getParticipantes().get(1); 
		participante3 = sistema.getParticipantes().get(2); 
		
		
		opinion1 = new Opinion(TipoOpinion.ImagenPocoClara); //,new DatosDelCreador(participante1,participante1.getEstadoParticipante()));
		opinion2 = new Opinion(TipoOpinion.Vinchuca); //,new DatosDelCreador(participante2,participante2.getEstadoParticipante()));
		opinion3 = new Opinion(TipoOpinion.Vinchuca); //,new DatosDelCreador(participante3,participante3.getEstadoParticipante()));
		
		muestra = new Muestra("Foto", EspecieVinchuca.Infestans , posadas);
	}
	
	@Test
	void setFechaCreacion() {
		LocalDate fecha = LocalDate.parse("22/01/2023",fmt);
		opinion1.setFechaCreacion(fecha);
		assertEquals(fecha,opinion1.getFechaCreacion());
	}

	@Test
	void testTipo() {
		assertEquals(TipoOpinion.ImagenPocoClara,opinion1.getTipo());
		assertEquals(TipoOpinion.Vinchuca,opinion2.getTipo());
		assertEquals(TipoOpinion.Vinchuca,opinion3.getTipo());
	}
	
	@Test
	void testDatosCreador() {
		participante1.opinarMuestra(muestra, opinion1);
		participante2.opinarMuestra(muestra, opinion2);
		participante3.opinarMuestra(muestra, opinion3);
		assertEquals(participante1,opinion1.getDatosCreador().getParticipante());
		assertEquals(participante2,opinion2.getDatosCreador().getParticipante());
		assertEquals(participante3,opinion3.getDatosCreador().getParticipante());
		
		assertEquals("Basico",opinion1.getDatosCreador().estadoDeParticipante().estado());
		assertEquals("Basico",opinion2.getDatosCreador().estadoDeParticipante().estado());
		assertEquals("Experto",opinion3.getDatosCreador().estadoDeParticipante().estado());
	}
	
	
}
