package tpVinchucasObj2.muestra;

import java.util.*;
import tpVinchucasObj2.opinion.*;
import tpVinchucasObj2.participantes.*;

public class Inicial extends EstadoMuestra{
	
	@Override
	public void verificarOpiniones(Muestra m) {
		List <TipoOpinion> ops = this.convertirOps(m.getOpiniones()); //Mapeamos las opiniones para que quede el tipo y las filtramos para que queden las de expertos, en caso de no haber quedan todas las opiniones.											
        m.setResultadoActual(this.opinionMasFrecuente(ops));
	}
	
	public List<TipoOpinion> convertirOps(List<Opinion> ops){
		return ops.stream().map(op -> op.getTipo()).toList();
	}
	
	public void cambiarEstado(Muestra m) {
		if (this.opinoUnExperto(m.getOpiniones())) {
			m.cambiarEstado(new SemiVerificada());
		}
	}
	
	public boolean opinoUnExperto(List <Opinion> ops) {
		return ops.stream().anyMatch(op -> op.getDatosCreador().estadoDeParticipante().estado() == "Experto");
	}
	
	@Override
	public String estado() {
		return "Inicial";
	}

}
