package tpVinchucasObj2.participantes;


import java.util.*;
import tpVinchucasObj2.muestra.Muestra;
import tpVinchucasObj2.opinion.Opinion;
import tpVinchucasObj2.opinion.TipoOpinion;
import tpVinchucasObj2.sistema.Sistema;


public abstract class Participante {
	
	
	private String nombre;
	protected Sistema sistema;
	protected EstadoUsuario estadoParticipante;
	protected List<Opinion> misOpiniones;
	protected List<Muestra> misMuestras;
	
	
		
	public Participante(String nombre,Sistema sistema) {
		super();
		this.nombre = nombre;		
		this.sistema = sistema;	
		
	}	
			
	public abstract void opinarMuestra(Muestra nuestra, TipoOpinion tipo); 
	public abstract String estado();
	public abstract void setEstadoParticipante(EstadoUsuario estadoParticipante);

	public Sistema getSistema() {
		return sistema;
	}
	
	public String getNombre() {
		return nombre;
	}

	public List<Opinion> getMisOpiniones() {
		return misOpiniones;
	}

	public List<Muestra> getMisMuestras() {
		return misMuestras;
	}

	public EstadoUsuario getEstadoParticipante() {
		return estadoParticipante;
	}

	
	

}


