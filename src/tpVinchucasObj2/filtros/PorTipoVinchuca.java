package tpVinchucasObj2.filtros;

import java.util.List;

import tpVinchucasObj2.muestra.*;

public class PorTipoVinchuca extends Filtro{
	private EspecieVinchuca tipoFiltro;
	
	public PorTipoVinchuca(EspecieVinchuca tipoFiltro) {
		super();
		this.tipoFiltro = tipoFiltro;
	}
	
	public EspecieVinchuca getTipoFiltro() {
		return tipoFiltro;
	}
	
	public void cambiarTipoFiltro(EspecieVinchuca nuevoTipo) {
		tipoFiltro = nuevoTipo;
	}
	
	public List<Muestra> filtrarMuestras(List<Muestra> muestras) {
		return muestras.stream().filter(m -> m.getEspecieVinchuca() == this.getTipoFiltro()).toList();
	}
	
}
