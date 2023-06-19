package tpVinchucasObj2.zonaDeCobertura;

import java.util.*;
import java.util.stream.Stream;

import tpVinchucasObj2.muestra.Muestra;
import tpVinchucasObj2.organizacion.Organizacion;
import tpVinchucasObj2.sistema.Sistema;
import tpVinchucasObj2.ubicacion.Ubicacion;

public class ZonaDeCobertura {
	
	public String getNombre() {
		return nombre;
	}

	private String nombre ;
	private double radio ;
	private Ubicacion epicentro ;
	private Sistema sistema ;
	//private List<Muestra> muestras ; // Debe tener el atributo ??
	private List<Organizacion> organizaciones ;
	
	public ZonaDeCobertura(String nombre, double radio, Ubicacion epicentro,Sistema sistema) {
		super();
		this.nombre = nombre;
		this.radio = radio;
		this.epicentro = epicentro;
		//this.muestras = new ArrayList<Muestra>();
		this.organizaciones = new ArrayList<Organizacion>();
		this.sistema = sistema ;
	}
	
	public double getRadio() {
		return radio;
	}

	public Ubicacion getEpicentro() {
		return epicentro;
	}
	

	public List<Muestra> muestrasDeLaZona() {
		List<Muestra> muestras = sistema.getMuestras();
		
		List<Muestra> muestrasZona = muestras.stream().filter(m->this.perteneceAZona(m)).toList() ;
		
		return muestrasZona;
	}
	
	public boolean perteneceAZona(Muestra muestra) {
		return muestra.getUbicacion().distanciaCon(epicentro) <= this.radio ;
	}
	
	public List<ZonaDeCobertura> zonasQueLaSolapan(){
		List<ZonaDeCobertura> todasLasZonas = sistema.getZonasCoberturas(); // Se encuentran todas las zonas, inclusive esta misma
		Stream<ZonaDeCobertura> todasLasZonasMenosEsta = todasLasZonas.stream().filter(z->z != this);
		
		return todasLasZonasMenosEsta.filter(z->z.seSolapaCon(this)).toList() ;
		
	}
	
	
	public boolean seSolapaCon(ZonaDeCobertura zonaAComparar) {
		double distanciaEntreEpicentros = this.epicentro.distanciaCon(zonaAComparar.getEpicentro()) ;
		double sumaRadios = this.radio + zonaAComparar.getRadio();
		
		return distanciaEntreEpicentros <= sumaRadios ;
		
	}
	
	
	public void suscribirOrganizacion(Organizacion organizacion) {
		organizaciones.add(organizacion);
	}
	
	public void desuscribirOrganizacion(Organizacion organizacion) {
		organizaciones.remove(organizacion);
	}
	
	public void avisoNuevaMuestra(Muestra muestra) {
		if(this.perteneceAZona(muestra)) {
			organizaciones.stream().forEach(o->o.avisoNuevaMuestra(this,muestra));
		}
		
	}
	
	public void avisoValidacionMuestra(Muestra muestra) {
		organizaciones.stream().forEach(o->o.avisoValidacionMuestra(this,muestra));
	}

	public List<Organizacion> getOrganizaciones() {
		return this.organizaciones;
	}
	
	
	
	
	
}
