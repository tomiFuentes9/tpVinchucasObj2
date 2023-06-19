package tpVinchucasObj2.participantes;


import tpVinchucasObj2.muestra.Muestra;
import tpVinchucasObj2.opinion.DatosDelCreador;
import tpVinchucasObj2.opinion.Opinion;
import tpVinchucasObj2.opinion.TipoOpinion;


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
	public void opinarMuestra(Muestra muestra, TipoOpinion tipo) {
		Opinion nuevaOp = new Opinion(tipo,new DatosDelCreador(this,this.getEstadoParticipante()));
		muestra.aniadirOpinion(nuevaOp);
		this.agregarOpinion(nuevaOp);
		this.cambiarEstado();
		
	}
	@Override
	public void cambiarEstado() {
		estadoParticipante.cambiarEstado(this);
		
	}

}
