package tpVinchucasObj2.muestra;

import tpVinchucasObj2.opinion.*;
import tpVinchucasObj2.participantes.*;

public abstract class EstadoMuestra {
	
	public abstract void actualizarResultado(Muestra m);
	
	public abstract void aniadirOpinion(Opinion op, Participante p);
}
