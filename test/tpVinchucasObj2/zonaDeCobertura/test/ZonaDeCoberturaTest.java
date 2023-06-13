package tpVinchucasObj2.zonaDeCobertura.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpVinchucasObj2.filtros.Filtro;
import tpVinchucasObj2.muestra.Muestra;
import tpVinchucasObj2.sistema.Sistema;
import tpVinchucasObj2.ubicacion.Ubicacion;
import tpVinchucasObj2.zonaDeCobertura.ZonaDeCobertura;

class ZonaDeCoberturaTest {
	
	Sistema sistemaVinchuca ;
	Filtro filtro;

	ZonaDeCobertura zonaCoberturaQuilmes ;
	ZonaDeCobertura zonaCoberturaBuenosAires ;
	ZonaDeCobertura zonaCoberturaLaPlata ;
	ZonaDeCobertura zonaCoberturaCordoba ;
	
	Ubicacion quilmes ;
	Ubicacion buenosAires ;
	Ubicacion laPlata ;
	Ubicacion cordoba ;
	
	Muestra muestra1 ;
	Muestra muestra2 ;
	Muestra muestra3 ;
	Muestra muestra4 ;
	

	@BeforeEach
	void setUp() {
		
		// Creamos el sistema 
		
		sistemaVinchuca = new Sistema(filtro);
		
		
		// Creamos los epicentros de las zonas de coberturas 
		quilmes     = new Ubicacion(-34.72904, -58.26374);
		
		buenosAires = new Ubicacion(-34.61315, -58.37723);
		laPlata     = new Ubicacion(-34.92145, -57.95453);
		cordoba     = new Ubicacion(-31.41350, -64.18105);

		// Creamos las zonas de coberturas
		zonaCoberturaQuilmes = new ZonaDeCobertura("Quilmes", 50 , quilmes,sistemaVinchuca);
		
		zonaCoberturaBuenosAires = new ZonaDeCobertura("Buenos Aires", 50 , buenosAires,sistemaVinchuca) ;
		zonaCoberturaLaPlata = new ZonaDeCobertura("La Plata", 50 , laPlata,sistemaVinchuca);
		zonaCoberturaCordoba = new ZonaDeCobertura("Cordoba", 50 , cordoba,sistemaVinchuca);
		
		// Creamos las muestras 
		
		muestra1 = mock(Muestra.class);
		muestra2 = mock(Muestra.class);
		muestra3 = mock(Muestra.class);
		muestra4 = mock(Muestra.class);
		
		
		//Agregamos las zonas al sistema 
		sistemaVinchuca.agregarZonaDeCobertura(zonaCoberturaQuilmes);;
		sistemaVinchuca.agregarZonaDeCobertura(zonaCoberturaBuenosAires);
		sistemaVinchuca.agregarZonaDeCobertura(zonaCoberturaLaPlata);
		sistemaVinchuca.agregarZonaDeCobertura(zonaCoberturaCordoba);
	}
	

	@Test
	void testMuestrasDeLaZona() {
		assertEquals(0,zonaCoberturaQuilmes.getMuestras().size());
		assertEquals(0,zonaCoberturaBuenosAires.getMuestras().size());
		assertEquals(0,zonaCoberturaLaPlata.getMuestras().size());
		assertEquals(0,zonaCoberturaCordoba.getMuestras().size());
		
		zonaCoberturaQuilmes.agregarMuestra(muestra1);
		zonaCoberturaQuilmes.agregarMuestra(muestra2);
		
		zonaCoberturaLaPlata.agregarMuestra(muestra3);
		zonaCoberturaLaPlata.agregarMuestra(muestra4);
		
		assertEquals(2,zonaCoberturaQuilmes.getMuestras().size());
		assertEquals(2,zonaCoberturaLaPlata.getMuestras().size());
		
	}

	@Test
	void testSeSolapaCon() {
		//Quilmes se solapa con buenos Aires y La Plata pero no con Cordoba 
		assertTrue(zonaCoberturaQuilmes.seSolapaCon(zonaCoberturaBuenosAires));
		assertTrue(zonaCoberturaQuilmes.seSolapaCon(zonaCoberturaLaPlata));
		assertFalse(zonaCoberturaQuilmes.seSolapaCon(zonaCoberturaCordoba));
		// Lo mismo le pasa a buenos Aires y La Plata 
		
		// La Plata
		assertTrue(zonaCoberturaLaPlata.seSolapaCon(zonaCoberturaBuenosAires));
		assertTrue(zonaCoberturaLaPlata.seSolapaCon(zonaCoberturaQuilmes));
		assertFalse(zonaCoberturaLaPlata.seSolapaCon(zonaCoberturaCordoba));
		
		// Buenos Aires
		assertTrue(zonaCoberturaBuenosAires.seSolapaCon(zonaCoberturaLaPlata));
		assertTrue(zonaCoberturaBuenosAires.seSolapaCon(zonaCoberturaQuilmes));
		assertFalse(zonaCoberturaBuenosAires.seSolapaCon(zonaCoberturaCordoba));
		
		// Cordoba no se debe solapar con ninguna
		assertFalse(zonaCoberturaCordoba.seSolapaCon(zonaCoberturaBuenosAires));
		assertFalse(zonaCoberturaCordoba.seSolapaCon(zonaCoberturaLaPlata));
		assertFalse(zonaCoberturaCordoba.seSolapaCon(zonaCoberturaQuilmes));
	}

	@Test
	void testZonasQueLaSolapan() {
		// Quilmes, la deberian solapar la plata y buenos aires
		assertEquals(2,zonaCoberturaQuilmes.zonasQueLaSolapan().size());
		assertEquals(zonaCoberturaBuenosAires,zonaCoberturaQuilmes.zonasQueLaSolapan().get(0));
		assertEquals(zonaCoberturaLaPlata,zonaCoberturaQuilmes.zonasQueLaSolapan().get(1));
		// Buenos Aires , la deberian solapar quilmes y la plata 
		assertEquals(2,zonaCoberturaBuenosAires.zonasQueLaSolapan().size());
		assertEquals(zonaCoberturaQuilmes,zonaCoberturaBuenosAires.zonasQueLaSolapan().get(0));
		assertEquals(zonaCoberturaLaPlata,zonaCoberturaBuenosAires.zonasQueLaSolapan().get(1));
		// La Plata , la deberian solapar quilmes y buenos aires
		assertEquals(2,zonaCoberturaLaPlata.zonasQueLaSolapan().size());
		assertEquals(zonaCoberturaQuilmes,zonaCoberturaLaPlata.zonasQueLaSolapan().get(0));
		assertEquals(zonaCoberturaBuenosAires,zonaCoberturaLaPlata.zonasQueLaSolapan().get(1));
		// Cordoba
		assertEquals(0,zonaCoberturaCordoba.zonasQueLaSolapan().size());
	}

}
