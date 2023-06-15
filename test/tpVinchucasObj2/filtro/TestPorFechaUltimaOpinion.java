package tpVinchucasObj2.filtro;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpVinchucasObj2.filtros.*;
import tpVinchucasObj2.muestra.*;
import tpVinchucasObj2.participantes.*;
import tpVinchucasObj2.sistema.*;
import tpVinchucasObj2.ubicacion.*;
import tpVinchucasObj2.opinion.*;

class TestPorFechaUltimaOpinion {
DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	PorFechaUltimaOpinion sut;
	
	Muestra muestra1;
	Muestra muestra2;
	Muestra muestra3;
	
	Participante crazyWally;
	Ubicacion quilmes;
	Sistema vinchuPower;
	Opinion opinion1;
	Opinion opinion2;
	
	List<Muestra> listaTest = new ArrayList<Muestra>();
	
	@BeforeEach
	void setUp() throws Exception {
		sut = new PorFechaUltimaOpinion(LocalDate.parse("11/06/2023",fmt));
		crazyWally = new Dinamico("Walter Norberto Gomez", vinchuPower);
		quilmes = new Ubicacion(-34.72904, -58.26374);
		vinchuPower = new Sistema(sut);
		
		opinion1 = new Opinion(TipoOpinion.ImagenPocoClara, new DatosDelCreador(crazyWally, new EstadoBasico()));
		opinion1.setFechaCreacion(LocalDate.parse("11/06/2023", fmt));
		
		opinion2 = new Opinion(TipoOpinion.PhtiaChinche, new DatosDelCreador(crazyWally, new EstadoBasico()));
		opinion2.setFechaCreacion(LocalDate.parse("25/03/2005", fmt));
		
		
		muestra1 = new Muestra("foto.png", EspecieVinchuca.Sordida, quilmes);
		muestra1.setFechaCreacion(LocalDate.parse("01/05/2005",fmt));
		muestra1.aniadirOpinion(opinion2);
		
		muestra2 = new Muestra("captura.jpeg", EspecieVinchuca.Infestans, quilmes);
		muestra2.setFechaCreacion(LocalDate.parse("06/06/2016", fmt));
		
		muestra3 = new Muestra("ft124586.jpeg", EspecieVinchuca.Guasayana, quilmes);
		muestra3.setFechaCreacion(LocalDate.parse("11/06/2023", fmt));
		muestra3.aniadirOpinion(opinion1);
		
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
		assertEquals(muestra3, sut.filtrarMuestras(listaTest).get(0));
	}

}
