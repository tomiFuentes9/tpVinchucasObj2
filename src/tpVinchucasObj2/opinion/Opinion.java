package tpVinchucasObj2.opinion;

import java.time.LocalDate;
import java.util.*;

import tpVinchucasObj2.participantes.Participante;

public class Opinion {
	
	private LocalDate fechaCreacion;
	private String estadoDelCreador;
	private TipoOpinion tipo;
	private Participante creador;
	//private Muestra muestraDondeSeEncuentra ; // Debe conocer la muestra donde fue realizada ella misma ?
	
	
	public Opinion(TipoOpinion tipo,Participante creador) {
		super();
		this.fechaCreacion= LocalDate.now();
		this.estadoDelCreador = creador.estado();
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


	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	
	
}
