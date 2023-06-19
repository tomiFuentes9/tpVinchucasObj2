package tpVinchucasObj2.organizacion;

import tpVinchucasObj2.muestra.Muestra;
import tpVinchucasObj2.zonaDeCobertura.ZonaDeCobertura;

public class Funcionalidad implements FuncionalidadExterna{
	
	public void nuevoEvento(Organizacion organizacion,ZonaDeCobertura zona ,Muestra muestra) {
		System.out.println("Se agrego una nueva muestra la cual tiene como resultado: "+ muestra.getResultadoActual() +
				 ", esta pertenece a la zona de cobertura " + zona.getNombre() + " y fue informada a la Organizacion " + organizacion.getNombre() ) ;
	}
	
}



