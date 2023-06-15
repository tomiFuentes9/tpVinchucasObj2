package tpVinchucasObj2.organizacion;

import tpVinchucasObj2.muestra.Muestra;
import tpVinchucasObj2.zonaDeCobertura.ZonaDeCobertura;

public class Funcionalidad implements FuncionalidadExterna{
	
	public void nuevoEvento(Organizacion organizacion,ZonaDeCobertura zona ,Muestra muestra) {
		System.out.print("La " + organizacion.getNombre() + " de " + zona.getNombre() + " es " + muestra.getResultadoActual() );
	}
	
}
