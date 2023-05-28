package tpVinchucasObj2.participantes;
import tpVinchucasObj2.muestra.Muestra;
import tpVinchucasObj2.muestras.opinion.Opinion;

public class Participante {
	private String nombre;
	private EstadoUsuario estadoParticipante;
	
	public Participante(String nombre, EstadoUsuario estadoParticipante) {
		super();
		this.nombre = nombre;
		this.estadoParticipante = estadoParticipante;
	}
	public String getNombre() {
		return nombre;
	}	
	public Muestra enviarMuestra() {
		return null;
	}
	public Opinion opinarMuestra(Muestra nuestra) {
		return null;
	}
	public void evaluarEstado() {
		
	}
	
	public String estadoActual() {
		return estadoParticipante.toString();
	}

}
