package tpVinchucasObj2.organizacion.test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tpVinchucasObj2.filtros.Filtro;
import tpVinchucasObj2.muestra.EspecieVinchuca;
import tpVinchucasObj2.muestra.Muestra;
import tpVinchucasObj2.organizacion.Funcionalidad;
import tpVinchucasObj2.organizacion.Organizacion;
import tpVinchucasObj2.organizacion.TipoOrganizacion;
import tpVinchucasObj2.participantes.Participante;
import tpVinchucasObj2.sistema.Sistema;
import tpVinchucasObj2.ubicacion.Ubicacion;
import tpVinchucasObj2.zonaDeCobertura.ZonaDeCobertura;

class OrganizacionTest {

	Sistema sistema ;
	Filtro filtro ;
	
	Organizacion orga;
	
	ZonaDeCobertura zona ;
	
	Ubicacion quilmes ;
	Ubicacion posadas;
	
	Participante participante ;
	
	Funcionalidad funcionalidad ;
	
	Muestra muestraDeLaZona ;
	Muestra muestraDeOtraZona ;
	
	@BeforeEach
	void setUp()  {
		// Instanciamos un sistema , una organizacion , una ubicacion , 
		// una zona de cobertura , y una funcionalidad externa
		sistema = new Sistema();
		
		orga = new Organizacion("NuevaOrga",TipoOrganizacion.Salud);

		quilmes = new Ubicacion(-34.72904, -58.26374);
		posadas     = new Ubicacion(-27.36708, -55.89608);
		
		zona = new ZonaDeCobertura("zonaQuilmes",50,quilmes,sistema);
		
		funcionalidad = new Funcionalidad();
		
		//Creamos un participante en el sistema y agregamos la zona instanciada anteriormente al mismo
		
		sistema.crearParticipanteDinamico("Vinchu");
		sistema.agregarZonaDeCobertura(zona);
		
		// Le asignamos la funcionalidad a la organizacion
		orga.cambiarFuncExternaMuestra(funcionalidad);
		
		// Agregamos cuantas personas trabajan en la organizacion 
		
		orga.setCantPersonasTrabajando(10);
		
		muestraDeLaZona = new Muestra("Foto",EspecieVinchuca.Sordida,quilmes);
		muestraDeOtraZona = new Muestra("Foto",EspecieVinchuca.Sordida,posadas);
	}

	@Test
	void testSuscribirseAZona() {
		assertEquals(0,orga.getZonasRegistradas().size());
		orga.suscribirseAZona(zona);
		assertEquals(1,orga.getZonasRegistradas().size());
	}

	@Test
	void testDesuscribirseAZona() {
		//Subcribiemos una zona de cobertura a una organizaciones
		orga.suscribirseAZona(zona);
		// Demostramos que se registro la zona de cobertura en la organizacion y viceversa 
		assertEquals(1,orga.getZonasRegistradas().size());
		assertEquals(1,zona.getOrganizaciones().size());
		//Desuscribimos la zona de la organizacion
		orga.desuscribirseAZona(zona);
		// Demostramos que se desuscribio la zona de cobertura en la organizacion y viceversa 
		assertEquals(0,orga.getZonasRegistradas().size());
		assertEquals(0,zona.getOrganizaciones().size());
	}

	@Test
	void testAvisoNuevaMuestra() {
		//Subcribiemos una zona de cobertura a una organizaciones
		orga.suscribirseAZona(zona);
		// Creamos una muestra y en el sistema y llega el aviso a la funcionlidad externa
		participante = sistema.getParticipantes().get(0);
		sistema.almacenarMuestra(muestraDeLaZona, participante);
		// Almacenamos otra muestra pero de uan zona diferentes y comprobamos que no da avisosobre la misma.
		sistema.almacenarMuestra(muestraDeOtraZona, participante);
	}
/*
	@Test
	void testAvisoValidacionMuestra() {
		
	}
*/
	
	
	@Test
	void testgetTipo() {
		assertEquals(TipoOrganizacion.Salud,orga.getTipo());
	}

}
