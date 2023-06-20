package tpVinchucasObj2.muestra;

import tpVinchucasObj2.opinion.*;
import tpVinchucasObj2.participantes.*;

public class Verificada extends EstadoMuestra {

	@Override
	public void actualizarResultado(Muestra m) {
		throw new RuntimeException("La muestra ya fue verificada no es posible actualizar el resultado");
	}

	@Override
	public void aniadirOpinion(Opinion op, Participante p) {
		throw new RuntimeException("La muestra ya fue verificada no es posible opinar sobre esta");
	}

}
