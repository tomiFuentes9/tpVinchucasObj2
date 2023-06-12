package tpVinchucasObj2.sistema;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import tpVinchucasObj2.muestra.Muestra;
import tpVinchucasObj2.participantes.Participante;
import tpVinchucasObj2.ubicacion.Ubicacion;
import tpVinchucasObj2.zonaDeCobertura.ZonaDeCobertura;

public class Sistema {

	private List<Muestra> muestras ;
	private List<ZonaDeCobertura> zonasDeCobertura ;

	
	public Sistema() {
		super();
		this.muestras = new ArrayList<Muestra>();
		this.zonasDeCobertura = new ArrayList<ZonaDeCobertura>();
	}

	
	public List<Muestra> getMuestras() {
		return muestras;
	}

	
	public void agregarMuestra(Muestra muestra) {
		// Agrega la muestr apasada por parametro a la lsita de muestras que tiene como atributo
		this.muestras.add(muestra);
	}
	
	
	public List<Participante> getParticipantes(){
		// Creo una variable donde almaceno todos los participantes del sistema (estan duplicados si subieron mas de una muestra)
		List<Participante> participantes = this.getMuestras().stream().map(m -> m.getCreador()).toList() ;
		// Creo un set en donde no voy a tener duplicados
		Set miConjunto = new HashSet<>(participantes);
		// Limpio la lista 
		participantes.clear();
		// Devuelve todos los participantes del sistema
		participantes.addAll(miConjunto);
		return participantes ;
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
	
}
