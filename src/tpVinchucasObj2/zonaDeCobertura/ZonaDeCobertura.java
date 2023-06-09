package tpVinchucasObj2.zonaDeCobertura;

import java.util.*;

import tpVinchucasObj2.muestra.Muestra;
import tpVinchucasObj2.sistema.Sistema;
import tpVinchucasObj2.ubicacion.Ubicacion;

public class ZonaDeCobertura {
	
	private String nombre ;
	private double radio ;
	private Ubicacion epicentro ;
	private Sistema sistema ;
	
	public ZonaDeCobertura(String nombre, double radio, Ubicacion epicentro) {
		super();
		this.nombre = nombre;
		this.radio = radio;
		this.epicentro = epicentro;
	}
	
	public double getRadio() {
		return radio;
	}

	public Ubicacion getEpicentro() {
		return epicentro;
	}

	public List<Muestra> muestrasDeLaZona() {
		List<Muestra> muestras = sistema.getMuestras();
		
		List<Muestra> muestrasZona = muestras.stream().filter(m->m.getUbicacion().distanciaCon(epicentro) <= radio).toList() ;
		
		return muestrasZona;
	}
	/*
	public List<ZonaDeCobertura> zonasQueLaSolapan(){
		List<ZonaDeCobertura> todasLasZonas = sistema.getZonasCoberturas();
		
		todasLasZonas.stream().forEach(z->z.seSolapaCon(this)).toList() ;
		
		return ;
	}
	*/
	
	public boolean seSolapaCon(ZonaDeCobertura zonaAComparar) {
		double distanciaEntreEpicentros = this.epicentro.distanciaCon(zonaAComparar.getEpicentro()) ;
		double mitadDistanciaEpicentros = distanciaEntreEpicentros / 2 ;
		
		return (mitadDistanciaEpicentros < this.radio) & (mitadDistanciaEpicentros < zonaAComparar.getRadio()) ;
		
		
	}
	
}
