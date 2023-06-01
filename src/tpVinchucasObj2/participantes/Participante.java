package tpVinchucasObj2.participantes;

import tpVinchucasObj2.muestra.Muestra;
import tpVinchucasObj2.opinion.Opinion;

public class Participante {
	
	private String nombre;
	private EstadoUsuario estadoParticipante;
	
	public Participante(String nombre) {
		super();
		this.nombre = nombre;
		this.estadoParticipante = new EstadoBasico (this);
	}
	
	public String getNombre() {
		return nombre;
	}	
	
	public Muestra enviarMuestra() {
		return null;
	}
	
	public void opinarMuestra(Muestra nuestra, Opinion opinion) {
		nuestra.aniadirOpinion(opinion);
	}

	public void evaluarEstado() {
		estadoParticipante.modificarMiEstadoSiCorresponde(this);
	}
	
	public String estadoActual() {
		return estadoParticipante.toString();
	}
		
	public void actualizarEstado(EstadoUsuario estadoNuevo) {
		this.estadoParticipante = estadoNuevo;
		
	}
}


