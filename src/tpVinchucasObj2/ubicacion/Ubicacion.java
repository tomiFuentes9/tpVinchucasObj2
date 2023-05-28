package tpVinchucasObj2.ubicacion;

import java.util.List;

import tpVinchucasObj2.muestras.Muestra;

public class Ubicacion {
	private Coordenada latitud ;
	private Coordenada longitud;
	
	
	public Ubicacion(Coordenada latitud, Coordenada longitud) {
		super();
		this.latitud = latitud;
		this.longitud = longitud;
	}


	public Coordenada getLatitud() {
		return latitud;
	}


	public void setLatitud(Coordenada latitud) {
		this.latitud = latitud;
	}


	public Coordenada getLongitud() {
		return longitud;
	}


	public void setLongitud(Coordenada longitud) {
		this.longitud = longitud;
	}
	
	
	public float distanciaCon(Ubicacion ubicacion) {
		//Averiguar la distancia con respecto a otra ubicacion pasada
		return 0;
	}
	
	public List<Ubicacion> aXDistancia(List<Ubicacion> ubicaciones , int distancia){
		// Dada una lista de ubicaciones devuelve las ubicaciones que se encuentran a la distancia indicada, de si misma.
	} 
	
	public List<Muestra> muestraAXMetros(Muestra muestra, float distanciaEnMts){
		// Dado una muestra, conoce todas las muestras obtenidas a menos de x metros.

	}
	
	public List<Muestra> muestraAXKilometros(Muestra muestra, float distanciaEnKm){
		// Dado una muestra, conoce todas las muestras obtenidas a menos de x kilómetros.

	}
	
	
}
