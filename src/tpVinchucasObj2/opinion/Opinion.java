package tpVinchucasObj2.opinion;

import java.util.*;

public class Opinion {
	
	private Date fechaCreacion;
	private String estadoDelCreador;
	
	
	public Opinion(String estadoDelCreador) {
		super();
		this.fechaCreacion= new Date();
		this.estadoDelCreador = estadoDelCreador;
	}


	public String getEstadoDelCreador() {
		return estadoDelCreador;
	}


	public Date getFechaCreacion() {
		return fechaCreacion;
	}


	public void setFechaCreacion(Date fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}


	
	public String diaCreacion() {
		return "" + this.getFechaCreacion().getDay() ;
	}
	
}
