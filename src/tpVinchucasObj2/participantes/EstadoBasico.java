package tpVinchucasObj2.participantes;

public class EstadoBasico extends EstadoUsuario{



	@Override
	public String estado() {
		
		return "Basico";
	}

	@Override
	protected void cambiarEstado(Participante participante) {
		//if (muestrasEnviadas(participante) > 10 && revisionesMuestras(participante)>20){
		EstadoExperto estadoNuevo= new EstadoExperto ();
		participante.setEstadoParticipante(estadoNuevo);
		
		
		}
	
	
	
		
}


