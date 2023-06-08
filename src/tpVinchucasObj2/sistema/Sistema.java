package tpVinchucasObj2.sistema;

import java.util.ArrayList;
import java.util.List;

import tpVinchucasObj2.muestra.Muestra;
import tpVinchucasObj2.ubicacion.Ubicacion;

public class Sistema {

	private List<Muestra> muestras ;
	
	
	
	public Sistema(List<Muestra> muestras) {
		super();
		this.muestras = muestras;
	}




	public List<Muestra> muestraAXMetros(Muestra muestra,float distanciaEnMts,Sistema sistema){
		// Dado una muestra, conoce todas las muestras obtenidas a menos de x metros.
		List<Muestra> listaFinal = new ArrayList<Muestra>();
		List<Muestra> muestras = sistema.getMuestras(); //-- todas las muestras del sistema pasado por parametro
		
		Ubicacion ubicacionMuestra = muestra.getUbicacion() ;
		
		for(Muestra muestraAVerificar : muestras) {
			if(ubicacionMuestra.distanciaCon(muestraAVerificar.getUbicacion()) <= distanciaEnMts ) {
				listaFinal.add(muestraAVerificar);
			}
		}
		return listaFinal;

	}
	
	
}
