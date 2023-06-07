package tpVinchucasObj2.participantes;

import java.util.Date;
import java.util.List;

import tpVinchucasObj2.muestra.EspecieVinchuca;
import tpVinchucasObj2.muestra.Muestra;
import tpVinchucasObj2.opinion.Opinion;
import tpVinchucasObj2.opinion.TipoOpinion;
import tpVinchucasObj2.ubicacion.Ubicacion;

public class Participante {
	
	private String nombre;
	private EstadoUsuario estadoParticipante;
	private List <Date> diasQueOpine;
	
	
	public Participante(String nombre) {
		super();
		this.nombre = nombre;
		this.estadoParticipante = new EstadoBasico (this);
	}
	
	public String getNombre() {
		return nombre;
	}	
	
	public void agregarDia() {
		this.diasQueOpine.add(new Date());
		
	}
	public void enviarMuestra(String foto,EspecieVinchuca especieVinchuca, Ubicacion ubicacion) {
		Muestra nuevaMuestr = new Muestra(foto,especieVinchuca,this,ubicacion);
		//nuevaMuestr.agregarAlSistema(nuevaMuestr);
		
	}
	
	public void opinarMuestra(Muestra nuestra, TipoOpinion tipo) {
		Opinion nuevaOp = new Opinion(tipo,this);
		nuestra.aniadirOpinion(nuevaOp);
		this.agregarDia();
		this.evaluarEstado();
		
	}

	public void evaluarEstado() {
		estadoParticipante.modificarMiEstadoSiCorresponde(this);
	}
	
	public String estadoActual() {
		return estadoParticipante.estado();
	}
		
	public void actualizarEstado(EstadoUsuario estadoNuevo) {
		this.estadoParticipante = estadoNuevo;
		
	}
}


