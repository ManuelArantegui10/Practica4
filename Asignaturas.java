package Practica4;

public class Asignaturas {
	private int codigoAsignatura;
	private double creditos;
	private int cuatrimestre;
	private String tipologia;
	private String denominacion;
	
	public Asignaturas(int codigoAsignatura, double creditos, int cuatrimestre, String tipologia, String denominacion) {
		this.codigoAsignatura = codigoAsignatura;
		this.creditos = creditos;
		this.cuatrimestre = cuatrimestre;
		this.tipologia = tipologia;
		this.denominacion = denominacion;
	}

	public int getCodigoAsignatura() {
		return codigoAsignatura;
	}

	public void setCodigoAsignatura(int codigoAsignatura) {
		this.codigoAsignatura = codigoAsignatura;
	}

	public double getCreditos() {
		return creditos;
	}

	public void setCreditos(double creditos) {
		this.creditos = creditos;
	}

	public int getCuatrimestre() {
		return cuatrimestre;
	}

	public void setCuatrimestre(int cuatrimestre) {
		this.cuatrimestre = cuatrimestre;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	public String getDenominacion() {
		return denominacion;
	}

	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

}
