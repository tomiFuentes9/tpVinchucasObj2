package tpVinchucasObj2.filtros;

import java.util.*;

import tpVinchucasObj2.muestra.*;

public abstract class NivelDeVerificacion extends Filtro {

	@Override
	public abstract List<Muestra> filtrarMuestras(List<Muestra> muestras);
}