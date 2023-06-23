package tpVinchucasObj2.filtros;

import java.util.*;

import tpVinchucasObj2.muestra.Muestra;

public class FiltroCompuestoAnd extends FiltroCompuesto{
	
	

	public FiltroCompuestoAnd(Filtro filtro1, Filtro filtro2) {
		super(filtro1, filtro2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Muestra> filtrarMuestras(List<Muestra> muestras) {
		List<Muestra> muestrasFiltradas1 = this.filtro1.filtrarMuestras(muestras) ;
		List<Muestra> muestrasFiltradas2 = this.filtro2.filtrarMuestras(muestras) ;
		
		List<Muestra> interseccion = new ArrayList<>(muestrasFiltradas1);
		interseccion.retainAll(muestrasFiltradas2);
		return interseccion;
	}

}
