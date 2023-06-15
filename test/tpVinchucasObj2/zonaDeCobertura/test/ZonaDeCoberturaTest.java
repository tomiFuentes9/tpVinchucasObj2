package tpVinchucasObj2.zonaDeCobertura.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpVinchucasObj2.filtros.Filtro;
import tpVinchucasObj2.muestra.EspecieVinchuca;
import tpVinchucasObj2.muestra.Muestra;
import tpVinchucasObj2.participantes.Dinamico;
import tpVinchucasObj2.participantes.ExpertoExterno;
import tpVinchucasObj2.participantes.Participante;
import tpVinchucasObj2.sistema.Sistema;
import tpVinchucasObj2.ubicacion.Ubicacion;
import tpVinchucasObj2.zonaDeCobertura.ZonaDeCobertura;

class ZonaDeCoberturaTest {
	
	Sistema sistemaVinchuca ;
	Filtro filtro;
	
	Participante participante1;
	Participante participante2;

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
		
		muestra1 = new Muestra("Foto", EspecieVinchuca.Infestans , quilmes);
		muestra2 = new Muestra("Foto", EspecieVinchuca.Infestans , quilmes);
		muestra3 = new Muestra("Foto", EspecieVinchuca.Infestans , laPlata);
		muestra4 = new Muestra("Foto", EspecieVinchuca.Infestans , cordoba);
		
		
		//Agregamos las zonas al sistema 
		sistemaVinchuca.agregarZonaDeCobertura(zonaCoberturaQuilmes);;
		sistemaVinchuca.agregarZonaDeCobertura(zonaCoberturaBuenosAires);
		sistemaVinchuca.agregarZonaDeCobertura(zonaCoberturaLaPlata);
		sistemaVinchuca.agregarZonaDeCobertura(zonaCoberturaCordoba);
		
		//Creamos los participantes
		participante1 = new ExpertoExterno("Tomas",sistemaVinchuca); 
		participante2 = new Dinamico("Walter",sistemaVinchuca);
	}
	

	@Test
	void testMuestrasDeLaZona() {
		// Verifico que las zonas de coberturas no tienen muestras ya que no hay participantes en el sistema
		assertEquals(0,zonaCoberturaQuilmes.muestrasDeLaZona().size());
		assertEquals(0,zonaCoberturaBuenosAires.muestrasDeLaZona().size());
		assertEquals(0,zonaCoberturaLaPlata.muestrasDeLaZona().size());
		assertEquals(0,zonaCoberturaCordoba.muestrasDeLaZona().size());
		
		//Agrego dos participantes al sistema
		sistemaVinchuca.agregarParticipante(participante2);
		sistemaVinchuca.agregarParticipante(participante1);
		
		
		// Los dos participantes cargan dos muestras 
		participante1.agregarMuestra(muestra1); // Quilmes 
		participante2.agregarMuestra(muestra2); // Quilmes
		participante1.agregarMuestra(muestra3); // La Plata
		participante2.agregarMuestra(muestra4); // Cordoba
		
		//  Al solaparse quilmes y la Plata por los radios que tienen cada una de las zonas, en quilmes y la plata
		// tengo 3 muestras y en cordoba 1 
		assertEquals(3,zonaCoberturaQuilmes.muestrasDeLaZona().size());
		assertEquals(3,zonaCoberturaLaPlata.muestrasDeLaZona().size());
		assertEquals(1,zonaCoberturaCordoba.muestrasDeLaZona().size());
		
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
