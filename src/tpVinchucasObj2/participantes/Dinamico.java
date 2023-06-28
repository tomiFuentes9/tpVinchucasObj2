package tpVinchucasObj2.participantes;


import tpVinchucasObj2.muestra.Muestra;
import tpVinchucasObj2.opinion.Opinion;



public class Dinamico extends Participante {
	
	public Dinamico(String nombre) {
		super(nombre);
		this.estadoParticipante = new EstadoBasico();		
	}
	


	@Override
	public String estado() {
		return estadoParticipante.estado();
	}
	
	public void setEstadoParticipante(EstadoUsuario estadoParticipante) {
		this.estadoParticipante = estadoParticipante;
	}
	
	@Override
	public void opinarMuestra(Muestra muestra, Opinion opinion) {
		super.opinarMuestra(muestra, opinion);
		this.cambiarEstado();
		
	}
	@Override
	public void cambiarEstado() {
		estadoParticipante.cambiarEstado(this);
		
	}

}
