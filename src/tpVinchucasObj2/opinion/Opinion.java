package tpVinchucasObj2.opinion;

import java.time.LocalDate;
import java.util.*;

import tpVinchucasObj2.participantes.Dinamico;
import tpVinchucasObj2.participantes.EstadoUsuario;
import tpVinchucasObj2.participantes.Participante;

public class Opinion {
	
	private LocalDate fechaCreacion;
	private TipoOpinion tipo;
	private DatosDelCreador datosCreador;
	
	
	public Opinion(TipoOpinion tipo) {
		super();
		this.fechaCreacion= LocalDate.now();
		this.tipo= tipo;
		this.datosCreador = new DatosDelCreador(); ;
	}



	public TipoOpinion getTipo() {
		return tipo;
	}


	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(LocalDate fechaCreacion) {
		// Este seter esta hecho para poder cambiarle la fecha a la opinion para poder testear mejor la clase.
		this.fechaCreacion = fechaCreacion;
	}



	public DatosDelCreador getDatosCreador() {
		return datosCreador;
	}



	public void setDatosDelCreador(Participante participante) {
		this.getDatosCreador().setCreador(participante);
		EstadoUsuario estado = participante.getEstadoParticipante() ;
		this.getDatosCreador().setEstadoParticipante(estado);
	}
	
	

	
	
}
