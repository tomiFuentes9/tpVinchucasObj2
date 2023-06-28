package tpVinchucasObj2.muestra;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import tpVinchucasObj2.opinion.*;
import tpVinchucasObj2.participantes.*;

public abstract class EstadoMuestra {
	
	public abstract String estado();
	
	public void actualizarResultado(Muestra m) {
		this.verificarOpiniones(m);
		this.cambiarEstado(m);
	}
	
	public void aniadirOpinion(Opinion op, Participante p , Muestra m) {
		m.agregarOpinion(op);
		p.incorpararOpinion(op);
		this.actualizarResultado(m);
	}
	
	public abstract void verificarOpiniones(Muestra m);
	
	public abstract void cambiarEstado(Muestra m);
	
	public TipoOpinion opinionMasFrecuente (List<TipoOpinion> opiniones) {
		Map<TipoOpinion, Long> opinionesMapeadas = opiniones.stream().collect(Collectors.groupingBy(op -> op, Collectors.counting()));
        TipoOpinion resultado = opinionesMapeadas.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(TipoOpinion.NoDefinida);
		return this.elementoMasFrecuenteOEmpate(resultado, opinionesMapeadas.get(resultado), opinionesMapeadas.values());
	}
	
	public TipoOpinion elementoMasFrecuenteOEmpate(TipoOpinion elementoMasFrecuente, Long maxCantOps, Collection<Long> valores ) {
		TipoOpinion res = elementoMasFrecuente;
		if (Collections.frequency(valores, maxCantOps) > 1 || maxCantOps < 2 ) {
			res = TipoOpinion.NoDefinida;
		}
		return res;
	}
}
