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
	
	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public String getFoto() {
		return foto;
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
		isVerificada = true;
	}
	
	public void actualizarResultado() {
		if (!isVerificada) {
			this.verificarOpiniones();
		}else {
			throw new RuntimeException("La muestra ya fue verificada no es posible actualizar el resultado");
		}
	}
	
	public void verificarOpiniones() {// En este metodo determinamos el resultado actual
		List <TipoOpinion> ops = this.filtrarOps(opiniones);
		HashMap<TipoOpinion, Integer> opsMapeadas = this.mapearOpiniones(ops);
		
        this.setResultadoActual(this.opinionMasFrecuente(opsMapeadas));
	}
	
	public boolean opinoUnExperto() {
		return opiniones.stream().anyMatch(op -> op.getDatosCreador().estadoDeParticipante().estado() == "Experto");
	}
	
	public List<TipoOpinion> filtrarOps(List<Opinion> ops){ // Agarro el array que tiene elementos de tipo Opinion 
		List<Opinion> filteredOps = this.filtrarExpertos(ops);//y lo mapeo para quedarme con los TiposDeOpinion nomas
		return filteredOps.stream().map(op -> op.getTipo()).toList();
	}
	
	public List<Opinion> filtrarExpertos(List<Opinion> ops){//Filtro las opiniones para que queden unicamente la de los expertos
		List<Opinion> filteredOps = ops;                    //Si no opino un experto envia toda las opiniones de nuevo
		if(this.opinoUnExperto()) {
			 filteredOps = filteredOps.stream().filter(op -> op.getDatosCreador().estadoDeParticipante().estado() == "Experto").toList();
		}
		return filteredOps;
	}
	
	public HashMap<TipoOpinion, Integer> mapearOpiniones(List<TipoOpinion> opiniones) {// Aca reviso el array filtrado y guardo como key el tipo de opinion
		HashMap<TipoOpinion, Integer> opinionesMapeadas = new HashMap<>();             // y como value las veces que aparece
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
        int maxContador = 0;                                                  // Falta definir esta ultima parte
		for (Map.Entry<TipoOpinion, Integer> entry : mp.entrySet()) {
            if (entry.getValue() > maxContador) {
                maxContador = entry.getValue();
                elementoMasFrecuente = entry.getKey();
            }
        }
        
        return elementoMasFrecuente;
	}
	
	public void setResultadoActual(TipoOpinion op) {
		resultadoActual = op;
	}
	
	public void aniadirOpinion(Opinion op) {
	if (!isVerificada) {	
		this.aniadirOpinionSiCorresponde(op);
	 }
	}
	
	public void aniadirOpinionSiCorresponde(Opinion op) {
		if (!this.opinoUnExperto()) {
			opiniones.add(op);
		}
	}
	
	
	
}
