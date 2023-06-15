package tpVinchucasObj2.participantes;


import java.util.*;


import tpVinchucasObj2.muestra.Muestra;
import tpVinchucasObj2.opinion.Opinion;
import tpVinchucasObj2.opinion.TipoOpinion;



public abstract class Participante {
	
	
	private String nombre;
	
	protected EstadoUsuario estadoParticipante;
	protected List<Opinion> misOpiniones;
	protected List<Muestra> misMuestras;
	
	
		
	public Participante(String nombre) {
		super();
		this.nombre = nombre;		
		
		
	}	
			
	public abstract void opinarMuestra(Muestra nuestra, TipoOpinion tipo); 
	public abstract String estado();
	public abstract void setEstadoParticipante(EstadoUsuario estadoParticipante);
	public abstract void cambiarEstado();


	
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
	
	// se crea el metodo este para poder testear
	public void agregarMuestra(Muestra muestra) {
		misMuestras.add(muestra);
	}
	public void agregarOpinion(Opinion opinion) {
		misOpiniones.add(opinion);
	}
	
	

}


