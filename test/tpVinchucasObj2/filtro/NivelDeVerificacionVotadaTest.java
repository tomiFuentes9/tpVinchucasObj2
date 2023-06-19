package tpVinchucasObj2.filtro;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpVinchucasObj2.filtros.*;
import tpVinchucasObj2.muestra.*;
import tpVinchucasObj2.opinion.DatosDelCreador;
import tpVinchucasObj2.opinion.Opinion;
import tpVinchucasObj2.opinion.TipoOpinion;
import tpVinchucasObj2.participantes.*;
import tpVinchucasObj2.sistema.*;
import tpVinchucasObj2.ubicacion.*;

class NivelDeVerificacionVotadaTest {
	NivelDeVerificacionVotada sut;
	
	Muestra muestra1;
	Muestra muestra2;
	Opinion opinion1;
	Opinion opinion2;
	
	Participante crazyWally;
	Participante leanlove;
	Ubicacion quilmes;
	Sistema vinchuPower;
	
	List<Muestra> listaTest;
	
	@BeforeEach
	void setUp() throws Exception {
		sut = new NivelDeVerificacionVotada();
		crazyWally = new Dinamico("Walter Norberto Gomez");
		leanlove = new Dinamico("Leandro Peppe");
		quilmes = new Ubicacion(-34.72904, -58.26374);
		vinchuPower = new Sistema();
		listaTest = new ArrayList<Muestra>();
		
		opinion1 = new Opinion(TipoOpinion.ImagenPocoClara, new DatosDelCreador(leanlove, new EstadoBasico()));
		opinion2 = new Opinion(TipoOpinion.ChincheFoliada, new DatosDelCreador(leanlove, new EstadoBasico()));
		
		muestra1 = new Muestra("foto.png", EspecieVinchuca.Sordida, quilmes);
		muestra2 = new Muestra("captura.jpeg", EspecieVinchuca.Infestans, quilmes);
		
		listaTest.add(muestra1);
		listaTest.add(muestra2);
		
		
	}

	@Test
	void testFiltrarMuestras() {
		assertEquals(0, sut.filtrarMuestras(listaTest).size());
		muestra2.aniadirOpinion(opinion1);
		assertEquals(1, sut.filtrarMuestras(listaTest).size());
	}

}
