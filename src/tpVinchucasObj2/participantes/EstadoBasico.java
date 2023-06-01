package tpVinchucasObj2.participantes;

public class EstadoBasico extends EstadoUsuario{


	public EstadoBasico(Participante participante) {
		super(participante);
		
	}

	@Override
	public String estado() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void modificarMiEstadoSiCorresponde(Participante participante) {
		//if (muestrasEnviadas(participante) > 10 && revisionesMuestras(participante)>20){
		//	participante.actualizarEstado();
		}
		
}


