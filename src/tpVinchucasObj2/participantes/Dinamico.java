package tpVinchucasObj2.participantes;


import tpVinchucasObj2.muestra.Muestra;
import tpVinchucasObj2.opinion.DatosDelCreador;
import tpVinchucasObj2.opinion.Opinion;
import tpVinchucasObj2.opinion.TipoOpinion;
import tpVinchucasObj2.sistema.Sistema;
import java.util.*;


public class Dinamico extends Participante {
	
	
	public Dinamico(String nombre, Sistema sistema) {
		super(nombre, sistema);
		this.estadoParticipante = new EstadoBasico();
		this.misOpiniones= new ArrayList<Opinion>();
		this.misMuestras= new ArrayList<Muestra>();
		
		
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
