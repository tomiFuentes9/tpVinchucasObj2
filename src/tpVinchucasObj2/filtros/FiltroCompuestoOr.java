package tpVinchucasObj2.filtros;

import java.util.*;
import java.util.stream.Collectors;

import tpVinchucasObj2.muestra.Muestra;

public class FiltroCompuestoOr extends FiltroCompuesto{
	

	public FiltroCompuestoOr(Filtro filtro1, Filtro filtro2) {
		super(filtro1, filtro2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Muestra> filtrarMuestras(List<Muestra> muestras) {
		List<Muestra> muestrasFiltradas1 = this.filtro1.filtrarMuestras(muestras) ;
		List<Muestra> muestrasFiltradas2 = this.filtro2.filtrarMuestras(muestras) ;
		
		List<Muestra> union = new ArrayList<>(muestrasFiltradas1);
		union.addAll(muestrasFiltradas2);
		
		
		return union.stream().distinct().collect(Collectors.toList());
	}

}
