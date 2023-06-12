package tpVinchucasObj2.opinion;

import tpVinchucasObj2.participantes.EstadoUsuario;
import tpVinchucasObj2.participantes.Participante;

public class DatosDelCreador {
	private Participante creador;
	private EstadoUsuario estadoParticipante;
	
	public DatosDelCreador(Participante creador, EstadoUsuario estadoParticipante) {
		this.creador = creador;
		this.estadoParticipante = estadoParticipante;
	}
	
	public Participante getParticipante() {
		return creador;
	}
	
	public EstadoUsuario estadoDeParticipante() {
		return estadoParticipante;
	}
}
