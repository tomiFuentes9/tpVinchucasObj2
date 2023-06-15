package tpVinchucasObj2.sistema;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpVinchucasObj2.filtros.Filtro;
import tpVinchucasObj2.muestra.EspecieVinchuca;
import tpVinchucasObj2.muestra.Muestra;
import tpVinchucasObj2.participantes.Dinamico;
import tpVinchucasObj2.participantes.ExpertoExterno;
import tpVinchucasObj2.participantes.Participante;
import tpVinchucasObj2.ubicacion.Ubicacion;
import tpVinchucasObj2.zonaDeCobertura.ZonaDeCobertura;

class TestSistema {
	
	// Declaramos el sistema
	Sistema sistemaVinchucas ;
	Filtro filtro;
	
	// Declaramos los Participantes
	Participante participante1 ;
	Participante participante2 ;
	
	
	// Creo una muestra para compararla
	Muestra muestraParaComparar ;
	
	
	// Declaramos las ubicaciones donde van a estar las muestras 
	Ubicacion buenosAires ;
	Ubicacion laPlata ;
	Ubicacion montevideo ;
	Ubicacion quilmes ;
	Ubicacion cordoba ;
	Ubicacion posadas ;
	
	// Declaramos dos zonas de cobertura
	
	ZonaDeCobertura zonaCoberturaLaPlata ;
	ZonaDeCobertura zonaCoberturaCordoba ;

	@BeforeEach
	void setUp(){
		// Instanciamos las ubicaciones
		buenosAires = new Ubicacion(-34.61315, -58.37723);
		
		posadas     = new Ubicacion(-27.36708, -55.89608);
		laPlata     = new Ubicacion(-34.92145, -57.95453);
		montevideo  = new Ubicacion(-34.90328, -56.18816);
		cordoba     = new Ubicacion(-31.41350, -64.18105);
		
		sistemaVinchucas = new Sistema(filtro);
		
		// Instanciamos las zonas 
		
		zonaCoberturaLaPlata = new ZonaDeCobertura("La Plata", 50 , laPlata,sistemaVinchucas);
		zonaCoberturaCordoba = new ZonaDeCobertura("Cordoba", 50 , cordoba,sistemaVinchucas);
		
		// Instancio una muestra para comparar con mi lista
		
		muestraParaComparar = new Muestra("Foto", EspecieVinchuca.Infestans , buenosAires);
		
		
		
		
		
	}
	
	
	
	@Test
	void testGetMuestras() {
		sistemaVinchucas.crearParticipanteDinamico("Leandro");
		sistemaVinchucas.crearParticipanteExterno("Tomas");
		
		participante1 = sistemaVinchucas.getParticipantes().get(0);
		participante2 = sistemaVinchucas.getParticipantes().get(1); 
		
		assertEquals(0,sistemaVinchucas.getMuestras().size());
		sistemaVinchucas.almacenarMuestra("Foto", EspecieVinchuca.Infestans , posadas,participante1);
		sistemaVinchucas.almacenarMuestra("Foto", EspecieVinchuca.Infestans , laPlata,participante2);
		assertEquals(2,sistemaVinchucas.getMuestras().size());
		sistemaVinchucas.almacenarMuestra("Foto", EspecieVinchuca.Infestans , montevideo,participante1);
		sistemaVinchucas.almacenarMuestra("Foto", EspecieVinchuca.Infestans , cordoba,participante2);
		assertEquals(4,sistemaVinchucas.getMuestras().size());
	}
	
	@Test 
	void testGetParticipantes() {
		assertEquals(0,sistemaVinchucas.getParticipantes().size());
		
		sistemaVinchucas.crearParticipanteDinamico("Leandro");
		sistemaVinchucas.crearParticipanteExterno("Tomas");
		
		assertEquals(2,sistemaVinchucas.getParticipantes().size());
	}
	
	
	 
	@Test 
	void testMuestraAXDistancia() {
		sistemaVinchucas.crearParticipanteDinamico("Leandro");
		sistemaVinchucas.crearParticipanteExterno("Tomas");
		
		participante1 = sistemaVinchucas.getParticipantes().get(0);
		participante2 = sistemaVinchucas.getParticipantes().get(1); 
		
		sistemaVinchucas.almacenarMuestra("Foto", EspecieVinchuca.Infestans , posadas,participante1);
		sistemaVinchucas.almacenarMuestra("Foto", EspecieVinchuca.Infestans , laPlata,participante2);
		sistemaVinchucas.almacenarMuestra("Foto", EspecieVinchuca.Infestans , montevideo,participante1);
		sistemaVinchucas.almacenarMuestra("Foto", EspecieVinchuca.Infestans , cordoba,participante2);
		
		
		List<Muestra> muestrasADistancia = sistemaVinchucas.muestraAXDistancia(muestraParaComparar, 300);
		
		assertEquals(2,muestrasADistancia.size());
	}
	
	
	@Test
	void agregarZonaDeCobertura() {
		assertEquals(0,sistemaVinchucas.getZonasCoberturas().size());
		sistemaVinchucas.agregarZonaDeCobertura(zonaCoberturaLaPlata);
		sistemaVinchucas.agregarZonaDeCobertura(zonaCoberturaCordoba);
		assertEquals(2,sistemaVinchucas.getZonasCoberturas().size());
	}
	
	
}