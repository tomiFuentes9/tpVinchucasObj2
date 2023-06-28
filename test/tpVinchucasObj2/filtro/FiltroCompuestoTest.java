package tpVinchucasObj2.filtro;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpVinchucasObj2.filtros.*;
import tpVinchucasObj2.muestra.EspecieVinchuca;
import tpVinchucasObj2.muestra.Muestra;
import tpVinchucasObj2.participantes.Dinamico;
import tpVinchucasObj2.participantes.Participante;
import tpVinchucasObj2.sistema.Sistema;
import tpVinchucasObj2.ubicacion.Ubicacion;

class FiltroCompuestoTest {
	
	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	// Declaramos un Sistema
	Sistema sistema;
	
	// Instanciamos el participante
	Participante participante ;
	
	// Declaracion de ubicaciones	
	Ubicacion buenosAires;
	Ubicacion laPlata;
	Ubicacion quilmes;
	Ubicacion posadas;
	Ubicacion cordoba;
	Ubicacion montevideo;	
		
	// Declarcion de Muestras
	Muestra muestra1;
	Muestra muestra2;
	Muestra muestra3;
	Muestra muestra4;
	Muestra muestra5;
	Muestra muestra6;
	Muestra muestra7;
	Muestra muestra8;
	Muestra muestra9;
	Muestra muestra10;
	Muestra muestra11;
	Muestra muestra12;
	Muestra muestra13;
	Muestra muestra14;
	Muestra muestra15;
	Muestra muestra16;
	Muestra muestra17;
	Muestra muestra18;
	Muestra muestra19;
	Muestra muestra20;
	Muestra muestra21;
	Muestra muestra22;
	
	// Declaracion de filtros
	
	Filtro filtroPorTipo1;
	Filtro filtroPorTipo2;
	Filtro porFecha1;
	Filtro porFecha2;
	FiltroCompuestoOr filtroOr ;
	FiltroCompuestoAnd filtroAnd;
	FiltroCompuestoOr filtroFinal;
	
	
	@BeforeEach
	void setUp()  {
		
		sistema = new Sistema();
		
		participante = new Dinamico("Leandro");
		
		sistema.agregarParticipante(participante);
		
		buenosAires = new Ubicacion(-34.61315, -58.37723);
		laPlata     = new Ubicacion(-34.92145, -57.95453);
		quilmes     = new Ubicacion(-34.72904, -58.26374);
		posadas     = new Ubicacion(-27.36708, -55.89608);
		cordoba     = new Ubicacion(-31.41350, -64.18105);
		montevideo  = new Ubicacion(-34.90328, -56.18816);
		
		//Instanciamos 5 muestras con fecha de 10 dias atras y las agregamos al sistema
		muestra1  = new Muestra("imagenA.jpg",EspecieVinchuca.Infestans,buenosAires);
		muestra1.setFechaCreacion(LocalDate.parse("12/06/2023",fmt));
		sistema.almacenarMuestra(muestra1, participante);
		
		muestra2  = new Muestra("imagenB.jpg",EspecieVinchuca.Sordida,laPlata);
		muestra2.setFechaCreacion(LocalDate.parse("12/06/2023",fmt));
		sistema.almacenarMuestra(muestra2, participante);
		
		muestra3  = new Muestra("imagenC.bmp",EspecieVinchuca.Guasayana,quilmes);
		muestra3.setFechaCreacion(LocalDate.parse("12/06/2023",fmt));
		sistema.almacenarMuestra(muestra3, participante);
		
		muestra4  = new Muestra("imagenD.jpg",EspecieVinchuca.Infestans,posadas);
		muestra4.setFechaCreacion(LocalDate.parse("12/06/2023",fmt));
		sistema.almacenarMuestra(muestra4, participante);
		
		muestra5  = new Muestra("imagenE.jpg",EspecieVinchuca.Sordida,cordoba);
		muestra5.setFechaCreacion(LocalDate.parse("12/06/2023",fmt));
		sistema.almacenarMuestra(muestra5, participante);
		
		
		//Instanciamos 5 muestras con fecha de 6 meses atras
		muestra6  = new Muestra("imagenA.jpg",EspecieVinchuca.Infestans,buenosAires);
		muestra6.setFechaCreacion(LocalDate.parse("22/01/2023",fmt));
		sistema.almacenarMuestra(muestra6, participante);
				
		muestra7  = new Muestra("imagenB.jpg",EspecieVinchuca.Sordida,laPlata);
		muestra7.setFechaCreacion(LocalDate.parse("22/01/2023",fmt));
		sistema.almacenarMuestra(muestra7, participante);
				
		muestra8  = new Muestra("imagenC.bmp",EspecieVinchuca.Guasayana,quilmes);
		muestra8.setFechaCreacion(LocalDate.parse("22/01/2023",fmt));
		sistema.almacenarMuestra(muestra8, participante);
		
		muestra9  = new Muestra("imagenD.jpg",EspecieVinchuca.Infestans,posadas);
		muestra9.setFechaCreacion(LocalDate.parse("22/01/2023",fmt));
		sistema.almacenarMuestra(muestra9, participante);
				
		muestra10  = new Muestra("imagenE.jpg",EspecieVinchuca.Sordida,cordoba);
		muestra10.setFechaCreacion(LocalDate.parse("22/01/2023",fmt));
		sistema.almacenarMuestra(muestra10, participante);
				
		//Instanciamos otras muestras con la fecha de hoy 
		muestra11  = new Muestra("imagenF.jpg",EspecieVinchuca.Guasayana,montevideo);
		sistema.almacenarMuestra(muestra11, participante);
		
		muestra12  = new Muestra("imagenG.jpg",EspecieVinchuca.Infestans,buenosAires);
		sistema.almacenarMuestra(muestra12, participante);
		
		muestra13 = new Muestra("imagenM.jpg",EspecieVinchuca.Infestans,buenosAires);
		sistema.almacenarMuestra(muestra13, participante);
		
		muestra14 = new Muestra("imagenN.jpg",EspecieVinchuca.Sordida,laPlata);
		sistema.almacenarMuestra(muestra14, participante);
		
		muestra15 = new Muestra("imagenO.jpg",EspecieVinchuca.Guasayana,quilmes);
		sistema.almacenarMuestra(muestra15, participante);
		
		muestra16 = new Muestra("imagenP.jpg",EspecieVinchuca.Infestans,posadas);
		sistema.almacenarMuestra(muestra16, participante);
		
		muestra17 = new Muestra("imagenQ.jpg",EspecieVinchuca.Sordida,cordoba);
		sistema.almacenarMuestra(muestra17, participante);
		
		muestra18 = new Muestra("imagenR.jpg",EspecieVinchuca.Guasayana,montevideo);
		sistema.almacenarMuestra(muestra18, participante);
		
		muestra19 = new Muestra("imagenS.jpg",EspecieVinchuca.Infestans,buenosAires);
		sistema.almacenarMuestra(muestra19, participante);
		
		muestra20 = new Muestra("imagenT.jpg",EspecieVinchuca.Sordida,laPlata);
		sistema.almacenarMuestra(muestra20, participante);
		
		muestra21 = new Muestra("imagenUjpg",EspecieVinchuca.Guasayana,quilmes);
		sistema.almacenarMuestra(muestra21, participante);
		
		muestra22 = new Muestra("imagenUjpg",EspecieVinchuca.Infestans,posadas);
		sistema.almacenarMuestra(muestra22, participante);
		
		//Dos filtros simples.
		filtroPorTipo1 = new PorTipoVinchuca(EspecieVinchuca.Infestans); // 9 Infestans
		filtroPorTipo2 = new PorTipoVinchuca(EspecieVinchuca.Sordida);	//   7  Sordida
		
		//Dos filtros simples
		porFecha1 = new PorFecha(LocalDate.parse("12/06/2023",fmt));    // 5 Con esa fecha
		porFecha2 = new PorFecha(LocalDate.parse("22/01/2023",fmt));	// 5 con esta otra fecha
		
		
		filtroAnd = new FiltroCompuestoAnd(filtroPorTipo1, porFecha1) ;  // muestras que tiene la fecha 12/06/23 y son Infestans - 2 muestras
		filtroOr = new FiltroCompuestoOr(filtroPorTipo2,porFecha2) ;     // // muestras que tiene la fecha 22/01/23 o son Sordida - 10 muestras
		
		filtroFinal = new FiltroCompuestoOr(filtroAnd,filtroOr);		// 12 muestras
		
		
	}

	@Test
	void testFiltrarMuestras() {
		
		// Probamos el tamaño de los filtros simples
		List<Muestra> muestras = sistema.getMuestras();
		assertEquals(9,filtroPorTipo1.filtrarMuestras(muestras).size());
		assertEquals(5,porFecha1.filtrarMuestras(muestras).size());
		
		assertEquals(7,filtroPorTipo2.filtrarMuestras(muestras).size());
		assertEquals(5,porFecha2.filtrarMuestras(muestras).size());
		
		// Probamos el tamaño de los filtros and y or
		assertEquals(2,filtroAnd.filtrarMuestras(muestras).size());
		assertEquals(10,filtroOr.filtrarMuestras(muestras).size());
		
		//Seteamos en el sistema el filtro final 
		assertEquals(22,sistema.getMuestras().size());	// Hay 22 muestras en el sistema
		sistema.setFiltro(filtroFinal);
		List<Muestra> muestrasFinales = sistema.ejecutarFiltro();
		assertEquals(12,muestrasFinales.size());	
	}
	
	@Test
	void testSetFiltros() {
		
		// Probamos el tamaño de los filtros simples
		List<Muestra> muestras = sistema.getMuestras();
		
		
		filtroOr.setFiltro1(filtroPorTipo1);
		filtroOr.setFiltro2(porFecha1);
		
		assertEquals(12,filtroOr.filtrarMuestras(muestras).size());
		
	}

	
}
