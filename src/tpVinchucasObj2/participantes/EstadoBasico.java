package tpVinchucasObj2.participantes;

public class EstadoBasico extends EstadoUsuario{



	@Override
	public String estado() {
		
		return "Basico";
	}

	@Override
	protected void modificarMiEstadoSiCorresponde(Participante participante) {
		//if (muestrasEnviadas(participante) > 10 && revisionesMuestras(participante)>20){
		EstadoExperto estadoNuevo= new EstadoExperto (participante);
		participante.actualizarEstado(estadoNuevo);
		
		
		}
	
	private int muestrasEnviadas(Participante participante) {
		participante.getDiasDeOpinion();
	}
	
		
}


