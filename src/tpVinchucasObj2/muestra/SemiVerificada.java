package tpVinchucasObj2.muestra;

import java.util.*;

import tpVinchucasObj2.opinion.*;
import tpVinchucasObj2.participantes.*;

public class SemiVerificada extends EstadoMuestra{
	
	@Override
	public void aniadirOpinion(Opinion op, Participante p, Muestra m) {
		if (this.esExperto(p)) {
			super.aniadirOpinion(op, p, m); //Preguntar si esta bien
		}
	}
	
	@Override
	public void verificarOpiniones(Muestra m) {
		List <TipoOpinion> ops = this.convertirOpsValidas(m.getOpiniones()); //Mapeamos las opiniones para que quede el tipo y las filtramos para que queden las de expertos, en caso de no haber quedan todas las opiniones.											
        m.setResultadoActual(this.opinionMasFrecuente(ops));
	}
	
	public List<TipoOpinion> convertirOpsValidas(List<Opinion> ops){
		List<Opinion> filteredOps = ops.stream().filter(op -> op.getDatosCreador().estadoDeParticipante().estado() == "Experto").toList();
		return filteredOps.stream().map(op -> op.getTipo()).toList();
	}
	
	public void cambiarEstado(Muestra m) {
		if (this.convertirOpsValidas(m.getOpiniones()).size() > 1 && m.getResultadoActual() != TipoOpinion.NoDefinida) {
			m.cambiarEstado(new Verificada());
		}
	}
	
	public boolean esExperto(Participante p) {
		return p.estado() == "Experto";
	}

	@Override
	public String estado() {
		return "Semiverificada";
	}
}
