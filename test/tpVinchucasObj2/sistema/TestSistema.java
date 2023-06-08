package tpVinchucasObj2.sistema;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpVinchucasObj2.muestra.EspecieVinchuca;
import tpVinchucasObj2.muestra.Muestra;
import tpVinchucasObj2.participantes.Participante;
import tpVinchucasObj2.ubicacion.Ubicacion;

class TestSistema {
	
	// Creacion de sistema
	Sistema sistemaVinchucas ;
	
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
		
		
		// Parcipante 
		
		participante1 = mock(Participante.class);
		participante2 = mock(Participante.class);
		
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
		assertEquals(0,sistemaVinchucas.getMuestras().size());
		sistemaVinchucas.agregarMuestra(muestra1);
		sistemaVinchucas.agregarMuestra(muestra2);
		assertEquals(2,sistemaVinchucas.getMuestras().size());
		sistemaVinchucas.agregarMuestra(muestra3);
		sistemaVinchucas.agregarMuestra(muestra4);
		assertEquals(4,sistemaVinchucas.getMuestras().size());
	}

	
	
}
