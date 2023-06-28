package tpVinchucasObj2.muestra;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import tpVinchucasObj2.participantes.*;
import tpVinchucasObj2.opinion.*;
import tpVinchucasObj2.ubicacion.*;
import tpVinchucasObj2.opinion.*;

public class Muestra {
	private String foto;
	private LocalDate fechaCreacion;
	private EstadoMuestra estado;
	private EspecieVinchuca especieVinchuca;
	private List <Opinion> opiniones;
	private Ubicacion ubicacion;
	private TipoOpinion resultadoActual;
	
	public Muestra(String foto, EspecieVinchuca especieVinchuca, Ubicacion ubicacion) {
		super();
		this.foto = foto;
		this.fechaCreacion = LocalDate.now();
		this.estado = new Inicial();
		this.especieVinchuca = especieVinchuca;
		this.opiniones = new ArrayList<Opinion>();
		this.ubicacion = ubicacion;
		this.resultadoActual = TipoOpinion.NoDefinida;
	}

	// Creado para poder testear
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	public EstadoMuestra getEstado() {
		return estado;
	}
	
	public TipoOpinion getResultadoActual() {
		return resultadoActual;
	}
	
	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}

	public EspecieVinchuca getEspecieVinchuca() {
		return especieVinchuca;
	}

	public List<Opinion> getOpiniones() {
		return opiniones;
	}
	
	public String estadoActual() {
		return this.getEstado().estado();
	}
	
	public Boolean esVotada() {
		return this.getOpiniones().size() > 0;
	}
	
	public void cambiarEstado(EstadoMuestra nuevoEstado) {
		this.estado = nuevoEstado;
	}
	
	public void setResultadoActual(TipoOpinion op) {
		resultadoActual = op;
	}
	
	public void aniadirOpinion(Opinion op, Participante p) {//Verifico si la muestra ya esta verificada antes de añadir la opinion
		if (!this.yaOpinoParticipante(p)) {
			this.getEstado().aniadirOpinion(op, p, this);	
		}
	}
	
	public void agregarOpinion(Opinion op) {
		this.opiniones.add(op);
	}
	
	public Boolean yaOpinoParticipante(Participante participante) {
		return this.participantesQueYaOpinaron().contains(participante);
	}
	
	public List<Participante> participantesQueYaOpinaron() {
		return this.getOpiniones().stream().map(op -> op.getDatosCreador().getParticipante()).toList();
	}
}









