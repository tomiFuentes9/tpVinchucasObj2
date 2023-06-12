package tpVinchucasObj2.filtros;

import java.time.LocalDate;
import java.util.*;

import tpVinchucasObj2.muestra.Muestra;

public class PorFecha extends Filtro {
	private LocalDate fechaFiltro;

	public PorFecha(LocalDate fechaFiltro) {
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
		return muestras.stream().filter(m -> m.getFechaCreacion() == this.getFechaFiltro()).toList();
	}

}
