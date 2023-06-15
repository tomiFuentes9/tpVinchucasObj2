package tpVinchucasObj2.participantes;

import java.time.LocalDate;
import java.util.List;

import tpVinchucasObj2.muestra.Muestra;
import tpVinchucasObj2.opinion.Opinion;

public abstract class EstadoUsuario {
	
	
	public abstract String estado();

	public abstract void cambiarEstado(Participante participante);
	
	public int revisionesOpiniones(Participante parti) {
		LocalDate fechaActual = LocalDate.now();
		LocalDate fechaAnterior = fechaActual.minusDays(30);
		List<Opinion> opionesDeUnMes = parti.misOpiniones;
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
