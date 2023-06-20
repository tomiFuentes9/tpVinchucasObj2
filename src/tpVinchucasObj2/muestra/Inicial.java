package tpVinchucasObj2.muestra;

import tpVinchucasObj2.opinion.Opinion;
import tpVinchucasObj2.participantes.Participante;

public class Inicial extends EstadoMuestra{

	@Override
	public void aniadirOpinion(Opinion op, Participante p) {
		p.opinarMuestra(null, null);
	}

	@Override
	public void verificarOpiniones(Muestra m) {
		// TODO Auto-generated method stub
		
	}

}
