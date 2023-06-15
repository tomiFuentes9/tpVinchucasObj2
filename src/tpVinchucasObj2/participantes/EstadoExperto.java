package tpVinchucasObj2.participantes;


public class EstadoExperto extends EstadoUsuario{

	@Override
	public String estado() {
		
		return "Experto";
	}

	@Override
	public void cambiarEstado(Participante participante) {
		if (this.muestrasEnviadas(participante) < 10 || this.revisionesOpiniones(participante) < 20){
			EstadoBasico estadoNuevo= new EstadoBasico ();
			participante.setEstadoParticipante(estadoNuevo);
		} 
		
	}
	
	

}
