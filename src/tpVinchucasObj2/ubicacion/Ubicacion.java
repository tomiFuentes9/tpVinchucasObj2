package tpVinchucasObj2.ubicacion;

import java.util.*;

import tpVinchucasObj2.muestra.Muestra;



public class Ubicacion {
	
	private double latitud ;
	private double longitud;
	
	
	public Ubicacion(double latitud, double longitud) {
		super();
		this.latitud = latitud;
		this.longitud = longitud;
	}


	public double getLatitud() {
		return latitud;
	}


	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}


	public double getLongitud() {
		return longitud;
	}


	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	
	
	public double distanciaCon(Ubicacion ubicacion) {
		//Averiguar la distancia con respecto a otra ubicacion pasada
		int radioTierraKm = 6371;

        double dLat = Math.toRadians(ubicacion.getLatitud() - this.latitud);
        double dLon = Math.toRadians(ubicacion.getLongitud() - this.longitud);

        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                   Math.cos(Math.toRadians(this.latitud)) * Math.cos(Math.toRadians(ubicacion.getLatitud())) *
                   Math.sin(dLon/2) * Math.sin(dLon/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double distancia = radioTierraKm * c;

        return distancia;
	    

	}
	
	public List<Ubicacion> aXDistancia(List<Ubicacion> ubicaciones , int distancia){
		// Dada una lista de ubicaciones devuelve las ubicaciones que se encuentran a la distancia indicada, de si misma.
		List<Ubicacion> listaFinal = new ArrayList<Ubicacion>();
		for(Ubicacion ubicacion : ubicaciones) {
			if(this.distanciaCon(ubicacion) <= distancia) {
				listaFinal.add(ubicacion);
			}
		}
		return listaFinal ;
		//return ubicaciones.stream().filter(u->u.distanciaCon(this) < distancia).toList();
	} 
	
	
	
	public List<Muestra> muestraAXMetros(Muestra muestra,float distanciaEnMts,Sistema sistema){
		// Dado una muestra, conoce todas las muestras obtenidas a menos de x metros.
		List<Muestra> listaFinal = new ArrayList<Muestra>();
		//sistema.getMuestras() -- todas las muestras del sistema pasado por parametro
		Ubicacion ubicacionMuestra = muestra.getUbicacion() ;
		for(Muestra muestraAVerificar : muestras) {
			if(ubicacionMuestra.distanciaCon(muestraAVerificar.getUbicacion() < distanciaEnMts )) {
				listaFinal.add(muestraAVerificar);
			}
		}
		return listaFinal;

	}
	
	
	
	
	
}
