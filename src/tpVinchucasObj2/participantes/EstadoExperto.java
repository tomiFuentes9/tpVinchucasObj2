package tpVinchucasObj2.participantes;

public class EstadoExperto extends EstadoUsuario{

	@Override
	public String estado() {
		
		return "Experto";
	}

	@Override
	protected void modificarMiEstadoSiCorresponde(Participante participante) {
		// TODO Auto-generated method stub
		
	}

}
