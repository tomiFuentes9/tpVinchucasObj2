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

class TestSistema {
	
	// Creacion de sistema
	Sistema sistemaVinchucas ;
	Filtro filtro;
	
	// Creacion de Participantes
	Participante participante1 ;
	Participante participante2 ;
	
	//Creo una lista de muestras
	List<Muestra> listaDeMuestras ;
	
	// Creo una muestra para compararla con otros 4 
	Muestra muestraParaComparar ;
	
	Muestra muestra1 ;
	Muestra muestra2 ;
	Muestra muestra3 ;
	Muestra muestra4 ;
	
	
	// Creo las ubicaciones donde van a estar esas muestras 
	Ubicacion buenosAires ;
	Ubicacion laPlata ;
	Ubicacion montevideo ;
	Ubicacion quilmes ;
	Ubicacion cordoba ;
	Ubicacion posadas ;
	
	

	@BeforeEach
	void setUp(){
		
		sistemaVinchucas = new Sistema(filtro);
		// Parcipante 
		
		participante1 = new ExpertoExterno("Tomas",sistemaVinchucas); 
		participante2 = new Dinamico("Walter",sistemaVinchucas);
		
		
		// Instanciamos 4 muestras que van a ser comparas con la muestraParaComparar 
		// La muestra 1 y 2 van a estar cerca de la muestra a comparar. La Muestra 3 y 4 no 
		
		muestraParaComparar = new Muestra("Foto", EspecieVinchuca.Infestans ,participante1, buenosAires);
		
		muestra1 = new Muestra("Foto", EspecieVinchuca.Infestans ,participante1, posadas);
		muestra2 = new Muestra("Foto", EspecieVinchuca.Infestans ,participante2, laPlata);
		muestra3 = new Muestra("Foto", EspecieVinchuca.Infestans ,participante2, montevideo);
		muestra4 = new Muestra("Foto", EspecieVinchuca.Infestans ,participante1, cordoba);
		
		
		listaDeMuestras = new ArrayList<Muestra>();
		List<Muestra> listaDeMuestras = Arrays.asList(muestra1,muestra2,muestra3,muestra4);
		
		
		
		
	}
	
	
	
	@Test
	void testAgregarMuestras() {
		sistemaVinchucas.agregarParticipante(participante1);
		sistemaVinchucas.agregarParticipante(participante2);
		assertEquals(0,sistemaVinchucas.getMuestras().size());
		participante1.agregarMuestra(muestra1);
		participante2.agregarMuestra(muestra2);
		assertEquals(2,sistemaVinchucas.getMuestras().size());
		participante1.agregarMuestra(muestra3);
		participante2.agregarMuestra(muestra4);
		assertEquals(4,sistemaVinchucas.getMuestras().size());
	}
	
	@Test 
	void testGetParticipantes() {
		assertEquals(0,sistemaVinchucas.getParticipantes().size());
		
		sistemaVinchucas.agregarParticipante(participante1);
		sistemaVinchucas.agregarParticipante(participante2);
		
		assertEquals(2,sistemaVinchucas.getParticipantes().size());
	}
	
	@Test
	void testGetMuestras(){
		sistemaVinchucas.agregarParticipante(participante2);
		sistemaVinchucas.agregarParticipante(participante1);
		participante1.agregarMuestra(muestra1);
		participante2.agregarMuestra(muestra2);
		participante1.agregarMuestra(muestra3);
		participante2.agregarMuestra(muestra4);
		
		assertEquals(4,sistemaVinchucas.getMuestras().size());
	}
	
	
	@Test 
	void testMuestraAXDistancia() {
		sistemaVinchucas.agregarParticipante(participante2);
		sistemaVinchucas.agregarParticipante(participante1);
		participante1.agregarMuestra(muestra1);
		participante2.agregarMuestra(muestra2);
		participante1.agregarMuestra(muestra3);
		participante2.agregarMuestra(muestra4);
		
		List<Muestra> muestrasADistancia = sistemaVinchucas.muestraAXDistancia(muestraParaComparar, 200);
		
		assertEquals(2,muestrasADistancia.size());
		assertEquals(muestra2,muestrasADistancia.get(0));
		assertEquals(muestra3,muestrasADistancia.get(1));
	}
}
