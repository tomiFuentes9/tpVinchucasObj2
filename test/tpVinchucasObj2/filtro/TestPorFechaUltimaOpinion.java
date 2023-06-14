package tpVinchucasObj2.filtro;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpVinchucasObj2.filtros.PorFecha;
import tpVinchucasObj2.muestra.EspecieVinchuca;
import tpVinchucasObj2.muestra.Muestra;
import tpVinchucasObj2.participantes.Dinamico;
import tpVinchucasObj2.participantes.Participante;
import tpVinchucasObj2.sistema.Sistema;
import tpVinchucasObj2.ubicacion.Ubicacion;

class TestPorFechaUltimaOpinion {
DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	PorFecha sut;
	Muestra muestra1;
	Muestra muestra2;
	Muestra muestra3;
	Participante crazyWally;
	Ubicacion quilmes;
	Sistema vinchuPower;
	List<Muestra> listaTest = new ArrayList<Muestra>();
	
	@BeforeEach
	void setUp() throws Exception {
		sut = new PorFecha(LocalDate.parse("11/06/2023",fmt));
		crazyWally = new Dinamico("Walter Norberto Gomez", vinchuPower);
		quilmes = new Ubicacion(-34.72904, -58.26374);
		vinchuPower = new Sistema(sut);
		
		
		muestra1 = new Muestra("foto.png", EspecieVinchuca.Sordida, quilmes);
		muestra1.setFechaCreacion(LocalDate.parse("01/05/2005",fmt));
		
		muestra2 = new Muestra("captura.jpeg", EspecieVinchuca.Infestans, quilmes);
		muestra2.setFechaCreacion(LocalDate.parse("06/06/2016", fmt));
		
		muestra3 = new Muestra("ft124586.jpeg", EspecieVinchuca.Guasayana, quilmes);
		muestra3.setFechaCreacion(LocalDate.parse("11/06/2023", fmt));
		
		listaTest.add(muestra1);
		listaTest.add(muestra2);
		listaTest.add(muestra3);
	}
	
	@Test
	void testCambiarFechaFiltro() {
		sut.cambiarFechaFiltro(LocalDate.parse("25/07/2028", fmt));
		assertEquals(LocalDate.parse("25/07/2028",fmt), sut.getFechaFiltro());;
	}
	
	@Test
	void testFiltrarMuestras() {
		fail("Not yet implemented");
	}

}
