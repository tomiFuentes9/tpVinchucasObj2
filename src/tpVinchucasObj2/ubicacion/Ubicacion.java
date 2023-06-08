package tpVinchucasObj2.ubicacion;

import java.util.*;

import tpVinchucasObj2.muestra.Muestra;
import tpVinchucasObj2.sistema.Sistema;



public class Ubicacion {
	
	private double latitud ;
	private double longitud;
	
	
	public Ubicacion(double latitud, double longitud) {
		super();
		this.latitud = latitud;
		this.longitud = longitud;
	}


	public double getLatitud() {
		return this.latitud;
	}


	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}


	public double getLongitud() {
		return this.longitud;
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
		List<Ubicacion> listaFiltrada = new ArrayList<Ubicacion>();
		
		for(Ubicacion ubicacion : ubicaciones) {
			
			double distanciaCalculada = this.distanciaCon(ubicacion);
			
			if(distanciaCalculada <= distancia) {
				listaFiltrada.add(ubicacion);
			}
		}
		
		return listaFiltrada ;
	} 
	
	
	
	
	

	
	
	
	

	
	
	
}
