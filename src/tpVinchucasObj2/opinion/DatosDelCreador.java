package tpVinchucasObj2.opinion;

import tpVinchucasObj2.participantes.EstadoUsuario;
import tpVinchucasObj2.participantes.Participante;

public class DatosDelCreador {
	private Participante creador;
	private EstadoUsuario estadoParticipante;
	

	public DatosDelCreador() {
		this.creador = null;
		this.estadoParticipante = null;
	}
	
	public Participante getParticipante() {
		return creador;
	}
	
	public EstadoUsuario estadoDeParticipante() {
		return estadoParticipante;
	}
	
	public void setCreador(Participante creador) {
		this.creador = creador;
	}

	public void setEstadoParticipante(EstadoUsuario estadoParticipante) {
		this.estadoParticipante = estadoParticipante;
	}
	
	
}
