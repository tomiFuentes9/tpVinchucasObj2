package tpVinchucasObj2.participantes;


import tpVinchucasObj2.muestra.Muestra;
import tpVinchucasObj2.opinion.DatosDelCreador;
import tpVinchucasObj2.opinion.Opinion;
import tpVinchucasObj2.opinion.TipoOpinion;



public class ExpertoExterno extends Participante {

	public ExpertoExterno(String nombre) {
		super(nombre);
		this.estadoParticipante = new EstadoExperto();		
	}

	@Override
	public String estado() {		
		return estadoParticipante.estado();
	}

	@Override
	public void opinarMuestra(Muestra muestra, TipoOpinion tipo) {
		Opinion nuevaOp = new Opinion(tipo,new DatosDelCreador(this,this.getEstadoParticipante()));
		muestra.aniadirOpinion(nuevaOp);
		this.agregarOpinion(nuevaOp);
	}

	@Override
	public void cambiarEstado() {
		// no cambio de estado nunca siempre es Experto	
	}

	@Override
	public void setEstadoParticipante(EstadoUsuario estadoParticipante) {
		// no cambio de estado nunca siempre es Experto	
		
	}

	

}
