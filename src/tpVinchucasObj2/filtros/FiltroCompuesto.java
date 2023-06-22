package tpVinchucasObj2.filtros;

import java.util.List;

import tpVinchucasObj2.muestra.Muestra;

public abstract class FiltroCompuesto {
	
	private Filtro filtro1;
	private Filtro filtro2;
	
	
	
	public FiltroCompuesto(Filtro filtro1, Filtro filtro2) {
		super();
		this.filtro1 = filtro1;
		this.filtro2 = filtro2;
	}



	public abstract List<Muestra> filtrarMuestras(List<Muestra> muestras, Filtro filtro);
	
}
