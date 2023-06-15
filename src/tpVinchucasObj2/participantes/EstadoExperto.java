package tpVinchucasObj2.participantes;

import java.time.LocalDate;
import java.util.List;

import tpVinchucasObj2.muestra.Muestra;
import tpVinchucasObj2.opinion.Opinion;

public class EstadoExperto extends EstadoUsuario{

	@Override
	public String estado() {
		
		return "Experto";
	}

	@Override
	public void cambiarEstado(Participante participante) {
		if (this.muestrasEnviadas(participante) < 10 || this.revisionesOpiniones(participante) < 20){
			EstadoBasico estadoNuevo= new EstadoBasico ();
			participante.setEstadoParticipante(estadoNuevo);
		} else {}
		
	}
	
	

}
