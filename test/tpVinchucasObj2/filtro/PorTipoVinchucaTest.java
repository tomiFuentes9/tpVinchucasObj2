package tpVinchucasObj2.filtro;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpVinchucasObj2.filtros.*;
import tpVinchucasObj2.muestra.*;
import tpVinchucasObj2.opinion.*;
import tpVinchucasObj2.participantes.*;
import tpVinchucasObj2.sistema.*;
import tpVinchucasObj2.ubicacion.*;

class PorTipoVinchucaTest {

	PorTipoVinchuca sut;
	
	Muestra muestra1;
	Muestra muestra2;
	Muestra muestra3;
	Muestra muestra4;
	
	Participante crazyWally;
	Ubicacion quilmes;
	Sistema vinchuPower;
	
	List<Muestra> listaTest = new ArrayList<Muestra>();
	
	@BeforeEach
	void setUp() throws Exception {
		sut = new PorTipoVinchuca(EspecieVinchuca.Infestans);
		crazyWally = new Dinamico("Walter Norberto Gomez");
		quilmes = new Ubicacion(-34.72904, -58.26374);
		vinchuPower = new Sistema(sut);
		
		muestra1 = new Muestra("foto.png", EspecieVinchuca.Sordida, quilmes);
	
		muestra2 = new Muestra("captura.jpeg", EspecieVinchuca.Infestans, quilmes);
		
		muestra3 = new Muestra("ft124586.jpeg", EspecieVinchuca.Guasayana, quilmes);
		muestra4 = new Muestra("fotis.jpeg", EspecieVinchuca.Guasayana, quilmes);
		
		listaTest.add(muestra1);
		listaTest.add(muestra2);
		listaTest.add(muestra3);
	}
	@Test
	void testFiltrarMuestras() {
		assertEquals(muestra2, sut.filtrarMuestras(listaTest).get(0));
		listaTest.add(muestra4);
		sut.cambiarTipoFiltro(EspecieVinchuca.Guasayana);
		assertEquals(2, sut.filtrarMuestras(listaTest).size());
	}

	@Test
	void testCambiarTipoFiltro() {
		assertEquals(EspecieVinchuca.Infestans, sut.getTipoFiltro());
		sut.cambiarTipoFiltro(EspecieVinchuca.Sordida);
		assertEquals(EspecieVinchuca.Sordida, sut.getTipoFiltro());
	}

}
