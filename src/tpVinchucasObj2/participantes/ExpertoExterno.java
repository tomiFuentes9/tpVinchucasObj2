package tpVinchucasObj2.participantes;


import java.util.*;

import tpVinchucasObj2.muestra.Muestra;
import tpVinchucasObj2.opinion.Opinion;
import tpVinchucasObj2.opinion.TipoOpinion;
import tpVinchucasObj2.sistema.Sistema;


public class ExpertoExterno extends Participante {

	public ExpertoExterno(String nombre, Sistema sistema) {
		super(nombre, sistema);
		this.estadoParticipante = new EstadoExperto();
		this.misOpiniones= new ArrayList<Opinion>();
		this.misMuestras= new ArrayList<Muestra>();
	}

	@Override
	public String estado() {		
		return estadoParticipante.estado();
	}

	@Override
	public void opinarMuestra(Muestra nuestra, TipoOpinion tipo) {
		Opinion nuevaOp = new Opinion(tipo,this);
		nuestra.aniadirOpinion(nuevaOp);				
	}

	@Override
	public void setEstadoParticipante(EstadoUsuario estadoParticipante) {
		// no cambio de estado nunca siempre es Experto
		
	}


	

}
