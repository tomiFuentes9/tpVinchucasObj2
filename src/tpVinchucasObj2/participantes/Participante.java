package tpVinchucasObj2.participantes;

import java.time.LocalDate;

import java.util.*;

import tpVinchucasObj2.muestra.EspecieVinchuca;
import tpVinchucasObj2.muestra.Muestra;
import tpVinchucasObj2.opinion.Opinion;
import tpVinchucasObj2.opinion.TipoOpinion;
import tpVinchucasObj2.sistema.Sistema;
import tpVinchucasObj2.ubicacion.Ubicacion;

public class Participante {
	
	private String nombre;
	private EstadoUsuario estadoParticipante;
	private List <LocalDate> diasDeOpinion;
	private List <LocalDate> diasDeMuestreo;
	private Sistema sistema;
	
	
	public Participante(String nombre,Sistema sistema) {
		super();
		this.nombre = nombre;
		this.estadoParticipante = new EstadoBasico();
		this.sistema = sistema;
		this.diasDeMuestreo = new ArrayList<LocalDate>();
		this.diasDeOpinion = new ArrayList<LocalDate>();
	}
	
	public String getNombre() {
		return nombre;
	}	
	
	public void agregarDiaDeOpinion() {
		this.diasDeOpinion.add(LocalDate.now());
		
	}
	public void agregarDiaDeMuestreo() {
		this.diasDeMuestreo.add(LocalDate.now());
		
	}
	public void enviarMuestra(String foto,EspecieVinchuca especieVinchuca, Ubicacion ubicacion) {
		Muestra nuevaMuestr = new Muestra(foto,especieVinchuca,this,ubicacion);		
		sistema.agregarMuestra(nuevaMuestr);
		this.agregarDiaDeMuestreo();
		//this.actualizarEstado();
		
	}
	
	public void opinarMuestra(Muestra nuestra, TipoOpinion tipo) {
		Opinion nuevaOp = new Opinion(tipo,this);
		nuestra.aniadirOpinion(nuevaOp);
		this.agregarDiaDeOpinion();
		this.actualizarEstado();
		
	}

	public void actualizarEstado() {
		estadoParticipante.cambiarEstado(this);
	}
	
	public String estado() {
		return estadoParticipante.estado();
	}	

	public List<LocalDate> getDiasDeOpinion() {
		return diasDeOpinion;
	}
	public List<LocalDate> getDiasDeMuestreo() {
		return diasDeMuestreo;
	}

	public void setEstadoParticipante(EstadoUsuario estadoParticipante) {
		this.estadoParticipante = estadoParticipante;
	}
	
	/*public class FechaAnterior {
	    public static void main(String[] args) {
	        // Obtener la fecha actual
	        LocalDate fechaActual = LocalDate.now();

	        // Restar 30 días a la fecha actual
	        LocalDate fechaAnterior = fechaActual.minusDays(30);

	        // Imprimir la fecha anterior
	        System.out.println("Fecha anterior: " + fechaAnterior);
	    }
	}*/
}


