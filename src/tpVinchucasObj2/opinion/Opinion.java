package tpVinchucasObj2.opinion;

import java.util.*;

import tpVinchucasObj2.participantes.Participante;

public class Opinion {
	
	private Date fechaCreacion;
	private String estadoDelCreador;
	private TipoOpinion tipo;
	private Participante creador;
	//private Muestra muestraDondeSeEncuentra ; // Debe conocer la muestra donde fue realizada ella misma ?
	
	
	public Opinion(TipoOpinion tipo,Participante creador) {
		super();
		this.fechaCreacion= new Date();
		this.estadoDelCreador = creador.estadoActual();
		this.tipo= tipo;
		this.creador = creador;
	}


	public Participante getCreador() {
		return creador;
	}


	public void setCreador(Participante creador) {
		this.creador = creador;
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


	
	
}
