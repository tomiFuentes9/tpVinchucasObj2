package tpVinchucasObj2.participantes;

public class EstadoExperto extends EstadoUsuario{

	@Override
	public String estado() {
		
		return "Experto";
	}

	@Override
	protected void cambiarEstado(Participante participante) {
		//if (muestrasEnviadas(participante) > 10 && revisionesMuestras(participante)>20){
		EstadoBasico estadoNuevo= new EstadoBasico ();
		participante.setEstadoParticipante(estadoNuevo);
		
		
		}

}
