package tpVinchucasObj2.filtros;

import java.util.*;

import tpVinchucasObj2.muestra.*;

public class NivelDeVerificacionVerificada extends NivelDeVerificacion {

	@Override
	public List<Muestra> filtrarMuestras(List<Muestra> muestras) {
		return muestras.stream().filter(m -> m.estadoActual() == "Verificada").toList(); //Cambiar despues del refactor de Muestra
	}

}
