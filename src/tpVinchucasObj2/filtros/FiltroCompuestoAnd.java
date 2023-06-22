package tpVinchucasObj2.filtros;

import java.util.List;

import tpVinchucasObj2.muestra.Muestra;

public class FiltroCompuestoAnd extends FiltroCompuesto{
	
	
	
	public FiltroCompuestoAnd(Filtro filtro1, Filtro filtro2) {
		super(filtro1, filtro2);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Muestra> filtrarMuestras(List<Muestra> muestras, Filtro filtro) {
		List<Muestra> union = new ArrayList<>(muestras);
		union.addAll(union)
		return null;
	}

}
