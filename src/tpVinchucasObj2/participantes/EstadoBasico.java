package tpVinchucasObj2.participantes;

import java.time.LocalDate;
import java.util.List;

import tpVinchucasObj2.muestra.Muestra;
import tpVinchucasObj2.opinion.Opinion;


public class EstadoBasico implements EstadoUsuario{


	@Override
	public String estado() {
		
		return "Basico";
	}

	@Override
	public void cambiarEstado(Participante participante) {
		if (muestrasEnviadas(participante) > 10 && revisionesOpiniones(participante) > 20) {
		EstadoExperto estadoNuevo= new EstadoExperto ();
		participante.setEstadoParticipante(estadoNuevo);
		} else {}
	
		
	}
	public int revisionesOpiniones(Participante parti) {
		LocalDate fechaActual = LocalDate.now();
		LocalDate fechaAnterior = fechaActual.minusDays(30);
		List<Opinion> opionesDeUnMes = parti.getMisOpiniones();
		opionesDeUnMes.stream().filter(op->op.getFechaCreacion().isAfter(fechaAnterior)).toList();
		return opionesDeUnMes.size();	
		
	}

	public int muestrasEnviadas(Participante parti) {
		LocalDate fechaActual = LocalDate.now();
		LocalDate fechaAnterior = fechaActual.minusDays(30);
		List<Muestra> muestrasDeUnMes = parti.misMuestras;
		muestrasDeUnMes.stream().filter(mu->mu.getFechaCreacion().isAfter(fechaAnterior)).toList();
		return muestrasDeUnMes.size();	
		
	}

	
	
	
		
}


