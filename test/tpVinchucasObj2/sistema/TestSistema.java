package tpVinchucasObj2.sistema;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestSistema {

	Sistema sistemaVinchucas ;
	
	
	// Parcipante 
	
	participante1 = mock(Participante.class);
	
	// Instanciamos 4 muestras que van a ser comparas con la muestraParaComparar 
	// La muestra 1 y 2 van a estar cerca de la muestra a comparar. La Muestra 3 y 4 no 
	
	muestraParaComparar = new Muestra("Foto", EspecieVinchuca.Infestans ,participante1, buenosAires);
	
	muestra1 = new Muestra("Foto", EspecieVinchuca.Infestans ,participante1, posadas);
	muestra2 = new Muestra("Foto", EspecieVinchuca.Infestans ,participante1, laPlata);
	muestra3 = new Muestra("Foto", EspecieVinchuca.Infestans ,participante1, montevideo);
	muestra4 = new Muestra("Foto", EspecieVinchuca.Infestans ,participante1, cordoba);
	
	
	listaDeMuestras = new ArrayList<Muestra>();
	List<Muestra> listaDeMuestras = Arrays.asList(muestra1,muestra2,muestra3,muestra4);
	
	

	@BeforeEach
	void setUp(){
	}
	
	
	
	
	
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
