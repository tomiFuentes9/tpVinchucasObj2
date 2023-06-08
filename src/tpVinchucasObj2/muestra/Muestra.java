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
	private Participante creador;
	private List <Opinion> opiniones;
	private Ubicacion ubicacion;
	private TipoOpinion resultadoActual;
	
	public Muestra(String foto, EspecieVinchuca especieVinchuca,
			Participante creador, Ubicacion ubicacion) {
		super();
		this.foto = foto;
		this.fechaCreacion = LocalDate.now();
		this.isVerificada = false;
		this.especieVinchuca = especieVinchuca;
		this.creador = creador;
		this.opiniones = new ArrayList<Opinion>();
		this.ubicacion = ubicacion;
		this.resultadoActual = NoDefinida;
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

	public Participante getCreador() {
		return creador;
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
	
	public boolean opinoUnExperto() {
		return opiniones.stream().anyMatch(op -> op.getEstadoDelCreador() == "Experto");
	}
	
	public List<TipoOpinion> filtrarOps(List<Opinion> ops){
		List<Opinion> filteredOps = this.filtrarExpertos(ops);
		return filteredOps.stream().map(op -> op.getTipo()).toList();
	}
	
	public List<Opinion> filtrarExpertos(List<Opinion> ops){
		List<Opinion> filteredOps = ops;
		if(this.opinoUnExperto()) {
			 filteredOps = filteredOps.stream().filter(op -> op.getEstadoDelCreador() == "Experto").toList();
		}
		return filteredOps;
	}
	
	public void verificarOpiniones() {
		List <TipoOpinion> ops = this.filtrarOps(opiniones);
		HashMap<TipoOpinion, Integer> opinionesRepetidas = new HashMap<>();
        // Recorrer la lista y contar los elementos
        for (TipoOpinion op : ops) {
            if (opinionesRepetidas.containsKey(op)) {
                opinionesRepetidas.put(op, opinionesRepetidas.get(op) + 1);
            } else {
                opinionesRepetidas.put(op, 1);
            }
        }
        this.setResultadoActual(this.opinionMasFrecuente(opinionesRepetidas));// Consultar esto y falta filtrar la op con mas apariciones
	}
	
	public TipoOpinion opinionMasFrecuente(HashMap mp) {
		TipoOpinion opinion = mp.;
		
		return Ninguna;
	}
	
	public void setResultadoActual(TipoOpinion op) {
		resultadoActual = op;
	}
	
	/*
	 * Posible solucion:
	 * 
	 * 1) Agregar resultadoActual
	 * 
	 * 2) agregar un metodo que actualice el resultado evaluando las opiniones
	 * 
	 * if (!this.estaVerificada) Primero evalua que no este verificada asî no cambia el resultado
	 *  subtarea que actualiza resultado actual, contiene esto:
	 *  sino agregar excepción o system out
	 * List <Opiniones> opis = opiniones 
	 * if(this.opinoUnExperto){ Luego verificamos si opino un experto para filtar las opiniones y evaluar unicamente las validas
	 * 	opis = opis.filter(op -> op.estadoDeCreador === "Experto")
	 * }  Si pasa la condicion anterior, usando un stream o un for filtra las opiniones y asignamos el valor a la variable resultado actual
	 * while() / indexOf? / HashMap?
	 * 
	 * 3) Hacer un metodo para devolver el resultado actual
	 * 
	 * 
	 * 
	 * 
	 * 
	 * */
	
	public void aniadirOpinion(Opinion op) {
	if (!isVerificada) {	
		// Subtarea que adentro verifique si opino un experto y en ese caso agregarlo o no si corresponda
		//opiniones.add(op);
		
	 }
	}
	
	
	
}
