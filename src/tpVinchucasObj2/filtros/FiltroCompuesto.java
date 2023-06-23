package tpVinchucasObj2.filtros;

import java.util.List;

import tpVinchucasObj2.muestra.Muestra;

public abstract class FiltroCompuesto extends Filtro {
	
	protected Filtro filtro1; 
	protected Filtro filtro2;
	
	
	public FiltroCompuesto(Filtro filtro1, Filtro filtro2) {
		super();
		this.filtro1 = filtro1;
		this.filtro2 = filtro2;
	}
	
	


	public void setFiltro1(Filtro filtro) {
		this.filtro1 = filtro;
	}




	public void setFiltro2(Filtro filtro) {
		this.filtro2 = filtro;
	}




	public abstract List<Muestra> filtrarMuestras(List<Muestra> muestras);
	
}
