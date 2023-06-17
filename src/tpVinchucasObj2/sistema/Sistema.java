package tpVinchucasObj2.sistema;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import tpVinchucasObj2.filtros.Filtro;
import tpVinchucasObj2.muestra.EspecieVinchuca;
import tpVinchucasObj2.muestra.Muestra;
import tpVinchucasObj2.participantes.Dinamico;
import tpVinchucasObj2.participantes.ExpertoExterno;
import tpVinchucasObj2.participantes.Participante;
import tpVinchucasObj2.ubicacion.Ubicacion;
import tpVinchucasObj2.zonaDeCobertura.ZonaDeCobertura;

public class Sistema {

	private List<Participante> participantes ;
	private List<ZonaDeCobertura> zonasDeCobertura ;
	private Filtro filtro;
	
	public Sistema() {
		super();
		this.participantes = new ArrayList<Participante>();
		this.zonasDeCobertura = new ArrayList<ZonaDeCobertura>();
		this.filtro = null;
	}
	
	
	
	
	public void setFiltro(Filtro filtro) {
		this.filtro = filtro;
	}



	public void crearParticipanteDinamico(String nombre) {
		Participante nuevo = new Dinamico(nombre);
		this.agregarParticipante(nuevo);
	}
	
	public void crearParticipanteExterno(String nombre) {
		Participante nuevo = new ExpertoExterno(nombre);
		this.agregarParticipante(nuevo);
	}
	
	
	public List<Participante> getParticipantes() {
		return participantes;
	}

	
	public void agregarParticipante(Participante participante) {
		// Agrega la muestr apasada por parametro a la lsita de muestras que tiene como atributo
		this.participantes.add(participante);
	}
	
	
	public List<Muestra> getMuestras(){
		// Creo una variable donde almaceno todos los participantes del sistema (estan duplicados si subieron mas de una muestra)
		List<Muestra> muestras = this.fusionarListas((this.getParticipantes().stream().map(p -> p.getMisMuestras()).toList()));
		
		return muestras ;
	}
	
	
	private List<Muestra> fusionarListas(List<List<Muestra>> listas) {
		List<Muestra> listaFinal = new ArrayList<Muestra>() ;
		listas.stream().forEach(l->listaFinal.addAll(l));
		return listaFinal;
	}


	public List<Muestra> muestraAXDistancia(Muestra muestra,float distanciaEnKm){
		// Dado una muestra, conoce todas las muestras obtenidas a menos de x kms.
		List<Muestra> listaFinal = new ArrayList<Muestra>();
		List<Muestra> muestras = this.getMuestras(); //-- todas las muestras del sistema
		
		Ubicacion ubicacionMuestra = muestra.getUbicacion() ;
		
		for(Muestra muestraAVerificar : muestras) {
			if(ubicacionMuestra.distanciaCon(muestraAVerificar.getUbicacion()) <= distanciaEnKm ) {
				listaFinal.add(muestraAVerificar);
			}
		}
		return listaFinal; 
 
	}

	public List<ZonaDeCobertura> getZonasCoberturas() {
		return zonasDeCobertura;
	}
	
	public void agregarZonaDeCobertura(ZonaDeCobertura zona) {
		this.zonasDeCobertura.add(zona);
	}
	
	public void almacenarMuestra(Muestra muestra, Participante participante) {
		// 1-almacena
		participante.agregarMuestra(muestra);
		// 2-avisa a la/s zona/s de cobertura/s que corresponde.
		this.avisarAZonas(muestra);
	}


	private void avisarAZonas(Muestra muestra) {
		// Corregir ya que a las que corresponde les habla dos veces 
		// 1 - vos queres esta muestra 
		// 2 - toma esta muestra
		this.getZonasCoberturas().stream().filter(z->z.perteneceAZona(muestra)).
								           forEach(z->z.avisoNuevaMuestra(muestra));
	}
	
	
	
}
