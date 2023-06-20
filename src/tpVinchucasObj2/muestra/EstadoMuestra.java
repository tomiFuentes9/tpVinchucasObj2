package tpVinchucasObj2.muestra;

import tpVinchucasObj2.opinion.*;
import tpVinchucasObj2.participantes.*;

public abstract class EstadoMuestra {
	
	public void actualizarResultado(Muestra m) {
		this.verificarOpiniones(m);
	}
	
	public abstract void aniadirOpinion(Opinion op, Participante p);
	
	public abstract void verificarOpiniones(Muestra m);
}
