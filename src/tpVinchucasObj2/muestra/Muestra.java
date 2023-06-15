package tpVinchucasObj2.muestra;
import java.time.LocalDate;
import java.util.*;
import tpVinchucasObj2.participantes.*;
import tpVinchucasObj2.opinion.*;
import tpVinchucasObj2.ubicacion.*;
import tpVinchucasObj2.opinion.*;

public class Muestra {
	private String foto;
	private LocalDate fechaCreacion;
	private Boolean isVerificada;
	private EspecieVinchuca especieVinchuca;
	private List <Opinion> opiniones;
	private Ubicacion ubicacion;
	private TipoOpinion resultadoActual;
	
	public Muestra(String foto, EspecieVinchuca especieVinchuca, Ubicacion ubicacion) {
		super();
		this.foto = foto;
		this.fechaCreacion = LocalDate.now();
		this.isVerificada = false;
		this.especieVinchuca = especieVinchuca;
		this.opiniones = new ArrayList<Opinion>();
		this.ubicacion = ubicacion;
		this.resultadoActual = TipoOpinion.NoDefinida;
	}

	// Creado para poder testear
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	
	public TipoOpinion getResultadoActual() {
		return resultadoActual;
	}
	
	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public Boolean getIsVerificada() {
		return isVerificada;
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

	public void verificarMuestra() {
	 if (this.filtrarExpertos().size() > 1 && this.getResultadoActual() != TipoOpinion.NoDefinida ) {
		isVerificada = true;
	 }
	}
	
	public void actualizarResultado() {// Si no esta verificada revisamos las opiniones para actualizar el resultado
		if (!isVerificada) {
			this.verificarOpiniones();
		}else {
			throw new RuntimeException("La muestra ya fue verificada no es posible actualizar el resultado");
		}
	}
	
	public void verificarOpiniones() {
		List <TipoOpinion> ops = this.convertirOps(opiniones); //Mapeamos las opiniones para que quede el tipo y las filtramos para que queden las de expertos, en caso de no haber quedan todas las opiniones.
		HashMap<TipoOpinion, Integer> opsMapeadas = this.mapearOpiniones(ops); //Aca mapeamos la lista de opiniones filtradas para poder 																		
        this.setResultadoActual(this.opinionMasFrecuente(opsMapeadas)); //guardar un map con key= tipoOpinion y value= cant de apariciones
	}
	
	public boolean opinoUnExperto() {
		return opiniones.stream().anyMatch(op -> op.getDatosCreador().estadoDeParticipante().estado() == "Experto");
	}
	
	public List<TipoOpinion> convertirOps(List<Opinion> ops){  
		List<Opinion> filteredOps = this.filtrarExpertos();
		return filteredOps.stream().map(op -> op.getTipo()).toList();
	} 
	
	public List<Opinion> filtrarExpertos(){
		List<Opinion> filteredOps = this.getOpiniones();                    
		if(this.opinoUnExperto()) {
			 filteredOps = filteredOps.stream().filter(op -> op.getDatosCreador().estadoDeParticipante().estado() == "Experto").toList();
		}
		return filteredOps;
	}
	
	public HashMap<TipoOpinion, Integer> mapearOpiniones(List<TipoOpinion> opiniones) {
		HashMap<TipoOpinion, Integer> opinionesMapeadas = new HashMap<>();             
        for (TipoOpinion op : opiniones) {
            if (opinionesMapeadas.containsKey(op)) {
            	opinionesMapeadas.put(op, opinionesMapeadas.get(op) + 1);
            } else {
            	opinionesMapeadas.put(op, 1);
            }
        }
        return opinionesMapeadas;
	}
	
	public TipoOpinion opinionMasFrecuente(HashMap<TipoOpinion, Integer> mp) {// Aca reviso el map y me quedo con el elemento mas frecuente
		TipoOpinion elementoMasFrecuente = TipoOpinion.NoDefinida;            // Si no hay un elemento con muchas apariciones devuelve no definido
        int maxContador = 0;                                                  
		for (Map.Entry<TipoOpinion, Integer> entry : mp.entrySet()) {
            if (entry.getValue() > maxContador) {
                maxContador = entry.getValue();
                elementoMasFrecuente = entry.getKey();
            }
        }
        
        return this.elementoMasFrecuenteOEmpate(elementoMasFrecuente, maxContador, mp.values());
	}
	
	public TipoOpinion elementoMasFrecuenteOEmpate(TipoOpinion elementoMasFrecuente, int maxCantOps, Collection<Integer> valores ) {
		TipoOpinion res = elementoMasFrecuente;
		if (Collections.frequency(valores, maxCantOps) > 1 || maxCantOps < 2 ) {
			res = TipoOpinion.NoDefinida;
		}
		return res;
	}
	
	public void setResultadoActual(TipoOpinion op) {
		resultadoActual = op;
		this.verificarMuestra();
	}
	
	public void aniadirOpinion(Opinion op) {//Verifico si la muestra ya esta verificada antes de añadir la opinion
	if (!isVerificada) {	
		this.aniadirOpinionSiCorresponde(op);
	 }
	}
	
	public void aniadirOpinionSiCorresponde(Opinion op) {
		Participante participante = op.getDatosCreador().getParticipante();
		if (this.participantePuedeOpinar(participante) && !this.yaOpinoParticipante(participante)) { // Verifico si ya opino el participante y si ya opino un experto
			opiniones.add(op);
		} else {
			throw new RuntimeException("Ya opinaste sobre esta muestra o ya opino un experto");
		}
	}
	
	public Boolean participantePuedeOpinar(Participante participante) {
		Boolean puedeOpinar = true;
		if(this.opinoUnExperto() && participante.estado() != "Experto") {
			puedeOpinar = false;
		}
		return puedeOpinar;
	}
	
	public Boolean yaOpinoParticipante(Participante participante) {
		return this.participantesQueYaOpinaron().contains(participante);
	}
	
	public List<Participante> participantesQueYaOpinaron() {
		return this.getOpiniones().stream().map(op -> op.getDatosCreador().getParticipante()).toList();
	}
}
