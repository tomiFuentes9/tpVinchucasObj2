package tpVinchucasObj2.muestra;

import tpVinchucasObj2.opinion.Opinion;
import tpVinchucasObj2.participantes.Participante;

public class NoVerificada extends EstadoMuestra{

	@Override
	public void actualizarResultado(Muestra m) {
		m.verificarOpiniones();
	}

	@Override
	public void aniadirOpinion(Opinion op, Participante p) {
		p.opinarMuestra(null, null);
	}

}
