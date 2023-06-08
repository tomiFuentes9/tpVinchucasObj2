package tpVinchucasObj2.participantes;

public abstract class EstadoUsuario {
	
	
	
	public abstract String estado();

	protected abstract void modificarMiEstadoSiCorresponde(Participante participante);

}
