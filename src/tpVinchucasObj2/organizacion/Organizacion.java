package tpVinchucasObj2.organizacion;

import java.util.*;

import tpVinchucasObj2.muestra.Muestra;
import tpVinchucasObj2.zonaDeCobertura.ZonaDeCobertura;

public class Organizacion {
	
	private String nombre;
	private List<ZonaDeCobertura> zonasRegistradas ;
	private FuncionalidadExterna funcExternaMuestra;
	private FuncionalidadExterna funcExternaValidacion;
	private TipoOrganizacion tipo;
	private int cantPersonasTrabajando;
	
	
	public Organizacion(String nombre,TipoOrganizacion tipo) {
		super();
		this.nombre = nombre;
		this.zonasRegistradas = new ArrayList<ZonaDeCobertura>();
		this.tipo = tipo ;
		this.cantPersonasTrabajando = 0 ;
	}
	
	
	public TipoOrganizacion getTipo() {
		return tipo;
	}


	public void setCantPersonasTrabajando(int cantPersonasTrabajando) {
		this.cantPersonasTrabajando = cantPersonasTrabajando;
	}


	public String getNombre() {
		return nombre;
	}


	public List<ZonaDeCobertura> getZonasRegistradas() {
		return zonasRegistradas;
	}

	public FuncionalidadExterna getFuncExternaMuestra() {
		return funcExternaMuestra;
	}

	public FuncionalidadExterna getFuncExternaValidacion() {
		return funcExternaValidacion;
	}

	
	
	
	public void cambiarFuncExternaMuestra(FuncionalidadExterna nuevaFuncionalidad) {
		this.funcExternaMuestra = nuevaFuncionalidad; 
	}
	
	public void cambiarFuncValidacionMuestra(FuncionalidadExterna nuevaFuncionalidad) {
		this.funcExternaValidacion = nuevaFuncionalidad; 
	}
	
	public void suscribirseAZona(ZonaDeCobertura zonaARegistrarse) {
		zonasRegistradas.add(zonaARegistrarse);
		zonaARegistrarse.suscribirOrganizacion(this);
		
	}
	
	public void desuscribirseAZona(ZonaDeCobertura zonaADesuscribirse) {
		zonasRegistradas.remove(zonaADesuscribirse);
		zonaADesuscribirse.desuscribirOrganizacion(this);
		
	}
	
	public void avisoNuevaMuestra(ZonaDeCobertura zona, Muestra muestra) {
		funcExternaMuestra.nuevoEvento(this, zona, muestra);
	}
	
	public void avisoValidacionMuestra(ZonaDeCobertura zona, Muestra muestra) {
		funcExternaValidacion.nuevoEvento(this, zona, muestra);
	}
	
}


