package tpVinchucasObj2.filtro;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpVinchucasObj2.filtros.PorFecha;
import tpVinchucasObj2.muestra.EspecieVinchuca;
import tpVinchucasObj2.muestra.Muestra;
import tpVinchucasObj2.participantes.Participante;
import tpVinchucasObj2.sistema.Sistema;
import tpVinchucasObj2.ubicacion.Ubicacion;

class TestPorFecha {
	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	PorFecha sut;
	Muestra muestra1;
	Muestra muestra2;
	Muestra muestra3;
	Participante crazyWally;
	Ubicacion quilmes;
	Sistema vinchuPower;

	@BeforeEach
	void setUp() throws Exception {// Se crea una muestra con fecha de hoy y se usa el setter para cambiar la fecha con motivos de testing
		sut = new PorFecha(LocalDate.now());
		crazyWally = new Participante("Walter Norberto Gomez", vinchuPower);
		quilmes = new Ubicacion(-34.72904, -58.26374);
		vinchuPower = new Sistema();
		
		
		muestra1 = new Muestra("foto.png", EspecieVinchuca.Sordida, crazyWally, quilmes);
		muestra1.setFechaCreacion(LocalDate.parse("01/05/2005",fmt));
		
		muestra2 = new Muestra("captura.jpeg", EspecieVinchuca.Infestans, crazyWally, quilmes);
		muestra2.setFechaCreacion(LocalDate.parse("06/06/2016", fmt));
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
