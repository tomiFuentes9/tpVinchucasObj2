package tpVinchucasObj2.participantes;

public abstract class EstadoUsuario {
	
	public EstadoUsuario(Participante participante) {
		this.participante = participante;
	}

	Participante participante;
	
	public abstract String estado();

	protected abstract void modificarMiEstadoSiCorresponde(Participante participante);

}
