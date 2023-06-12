package tpVinchucasObj2.organizacion;

import java.util.*;

import tpVinchucasObj2.muestra.Muestra;
import tpVinchucasObj2.zonaDeCobertura.ZonaDeCobertura;

public class Organizacion {
	private String nombre;
	private List<ZonaDeCobertura> zonasRegistradas ;
	private FuncionalidadExterna funcionalidadExterna;
	
	public Organizacion(String nombre) {
		super();
		this.nombre = nombre;
		this.zonasRegistradas = new ArrayList<ZonaDeCobertura>();
	}
	
	
	public void suscribirseAZona(ZonaDeCobertura zonaARegistrarse) {
		zonasRegistradas.add(zonaARegistrarse);
	}
	
	public void desuscribirseAZona(ZonaDeCobertura zonaADesuscribirse) {
		zonasRegistradas.remove(zonaADesuscribirse);
	}
	
	public void avisoNuevaMuestra(ZonaDeCobertura zona, Muestra muestra) {
		funcionalidadExterna.nuevoEvento(this, zona, muestra);
	}
	
	public void avisoValidacionMuestra(ZonaDeCobertura zona, Muestra muestra) {
		funcionalidadExterna.nuevoEvento(this, zona, muestra);
	}
	
}


