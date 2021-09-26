package edu.edi.practicaDocker;

import java.util.Date;

public class Tabla {
	
	String  palabra;
	Date fecha;
	public Tabla() {}
	public Tabla(String palabra) {
		this.palabra=palabra;
		this.fecha=new Date();
		
	}
	public Tabla(String palabra,Date fecha) {
		this.palabra=palabra;
		this.fecha=fecha;
		
	}
	public String getPalabra() {
		return palabra;
	}
	public void setPalabra(String palabra) {
		this.palabra = palabra;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	
	
	

}
