package tpVinchucasObj2.opinion;

import java.util.*;

import tpVinchucasObj2.participantes.Participante;

public class Opinion {
	
	private Date fechaCreacion;
	private String estadoDelCreador;
	private TipoOpinion tipo;
	private Participante creador; /*Como colocar quien hizo creo la opinion?*/
	//private Muestra muestraDondeSeEncuentra ; // Debe conocer la muestra donde fue realizada ella misma ?
	
	
	public Opinion(String estadoDelCreador,TipoOpinion tipo) {
		super();
		this.fechaCreacion= new Date();
		this.estadoDelCreador = estadoDelCreador;
		this.tipo= tipo;
	}


	public TipoOpinion getTipo() {
		return tipo;
	}


	public String getEstadoDelCreador() {
		return estadoDelCreador;
	}


	public Date getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	
	public String diaCreacion() {
		return "" + this.getFechaCreacion().getDay() ;
	}
	
}
