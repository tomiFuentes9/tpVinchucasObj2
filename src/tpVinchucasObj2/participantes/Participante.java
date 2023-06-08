package tpVinchucasObj2.participantes;

import java.time.LocalDate;

import java.util.List;

import tpVinchucasObj2.muestra.EspecieVinchuca;
import tpVinchucasObj2.muestra.Muestra;
import tpVinchucasObj2.opinion.Opinion;
import tpVinchucasObj2.opinion.TipoOpinion;
import tpVinchucasObj2.sistema.Sistema;
import tpVinchucasObj2.ubicacion.Ubicacion;

public class Participante {
	
	private String nombre;
	private EstadoUsuario estadoParticipante;
	private List <LocalDate> diasDeOpinion;
	private List <LocalDate> diasDeMuestreo;
	private Sistema sistemVinchu;
	
	
	public Participante(String nombre) {
		super();
		this.nombre = nombre;
		this.estadoParticipante = new EstadoBasico();
	}
	
	public String getNombre() {
		return nombre;
	}	
	
	public void agregarDiaDeOpinion() {
		this.diasDeOpinion.add(LocalDate.now());
		
	}
	public void agregarDiaDeMuestreo() {
		this.diasDeMuestreo.add(LocalDate.now());
		
	}
	public void enviarMuestra(String foto,EspecieVinchuca especieVinchuca, Ubicacion ubicacion) {
		Muestra nuevaMuestr = new Muestra(foto,especieVinchuca,this,ubicacion);		
		sistemVinchu.agregarMuestra(nuevaMuestr);
		this.agregarDiaDeMuestreo();
		this.evaluarEstadoYSiCorrespondeActualizar();
		
	}
	
	public void opinarMuestra(Muestra nuestra, TipoOpinion tipo) {
		Opinion nuevaOp = new Opinion(tipo,this);
		nuestra.aniadirOpinion(nuevaOp);
		this.agregarDiaDeOpinion();
		this.evaluarEstadoYSiCorrespondeActualizar();
		
	}

	public void evaluarEstadoYSiCorrespondeActualizar() {
		estadoParticipante.modificarMiEstadoSiCorresponde(this);
	}
	
	public String estado() {
		return estadoParticipante.estado();
	}	

	public List<LocalDate> getDiasDeOpinion() {
		return diasDeOpinion;
	}
	public List<LocalDate> getDiasDeMuestreo() {
		return diasDeMuestreo;
	}
	
	/*public class FechaAnterior {
	    public static void main(String[] args) {
	        // Obtener la fecha actual
	        LocalDate fechaActual = LocalDate.now();

	        // Restar 30 días a la fecha actual
	        LocalDate fechaAnterior = fechaActual.minusDays(30);

	        // Imprimir la fecha anterior
	        System.out.println("Fecha anterior: " + fechaAnterior);
	    }
	}*/
}


