package tpVinchucasObj2.filtros;

import java.time.*;
import java.util.*;

import tpVinchucasObj2.muestra.Muestra;
import tpVinchucasObj2.opinion.Opinion;

public class PorFechaUltimaOpinion extends Filtro {
	private LocalDate fechaFiltro;
	
	public PorFechaUltimaOpinion(LocalDate fechaFiltro) {
		super();
		this.fechaFiltro = fechaFiltro;
	}
	
	public LocalDate getFechaFiltro() {
		return fechaFiltro;
	}
	
	public void cambiarFechaFiltro(LocalDate nuevaFecha) {
		this.fechaFiltro = nuevaFecha;
	}

	@Override
	public List<Muestra> filtrarMuestras(List<Muestra> muestras) {
		List<Muestra> muestrasFiltradas = new ArrayList<Muestra>();
		for(Muestra m : muestras) {
			if(this.ultimaOpinionEnFechaBuscada(m.getOpiniones())) {
				muestrasFiltradas.add(m);
			}
		}
		return muestrasFiltradas;
	}
	
	public Boolean ultimaOpinionEnFechaBuscada(List<Opinion> opiniones) {
		Opinion ultimaOp = opiniones.get(opiniones.size() - 1);
		return ultimaOp.getFechaCreacion() == this.getFechaFiltro();
	}

}
