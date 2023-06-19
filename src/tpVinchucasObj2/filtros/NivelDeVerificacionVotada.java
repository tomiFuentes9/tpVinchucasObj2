package tpVinchucasObj2.filtros;

import java.util.*;

import tpVinchucasObj2.muestra.*;

public class NivelDeVerificacionVotada extends NivelDeVerificacion {
	
	@Override
	public List<Muestra> filtrarMuestras(List<Muestra> muestras) {
		return muestras.stream().filter(m -> m.esVotada()).toList();
	}

}
