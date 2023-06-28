package tpVinchucasObj2.filtro;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpVinchucasObj2.filtros.NivelDeVerificacionVerificada;
import tpVinchucasObj2.muestra.EspecieVinchuca;
import tpVinchucasObj2.muestra.Muestra;
import tpVinchucasObj2.opinion.Opinion;
import tpVinchucasObj2.opinion.TipoOpinion;
import tpVinchucasObj2.participantes.ExpertoExterno;
import tpVinchucasObj2.participantes.Participante;
import tpVinchucasObj2.sistema.Sistema;
import tpVinchucasObj2.ubicacion.Ubicacion;

class NivelDeVerificacionVerificadaTest {

	NivelDeVerificacionVerificada sut;
	
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
		sut = new NivelDeVerificacionVerificada();
		
		crazyWally = new ExpertoExterno("Walter Norberto Gomez");
		leanlove = new ExpertoExterno("Leandro Peppe");
		
		quilmes = new Ubicacion(-34.72904, -58.26374);
		vinchuPower = new Sistema();
		listaTest = new ArrayList<Muestra>();
		
		opinion1 = new Opinion(TipoOpinion.ChincheFoliada);
		opinion2 = new Opinion(TipoOpinion.ChincheFoliada);
		
		muestra1 = new Muestra("foto.png", EspecieVinchuca.Sordida, quilmes);
		muestra2 = new Muestra("captura.jpeg", EspecieVinchuca.Infestans, quilmes);
		
		listaTest.add(muestra1);
		listaTest.add(muestra2);
	}

	@Test
	void testFiltrarMuestras() {
		assertEquals(0, sut.filtrarMuestras(listaTest).size());
		crazyWally.opinarMuestra(muestra1, opinion1);
		leanlove.opinarMuestra(muestra1, opinion2);
		assertEquals(1, sut.filtrarMuestras(listaTest).size());
	}

}
