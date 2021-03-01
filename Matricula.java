package Practica4;

public class Matricula {
	private String nipAlumno;
	private String codigoAsignatura;
	
	public Matricula () {
		this.nipAlumno = "";
		this.codigoAsignatura = "";
	}

	public String getNipAlumno() {
		return nipAlumno;
	}

	public void setNipAlumno(String nipAlumno) {
		this.nipAlumno = nipAlumno;
	}

	public String getCodigoAsignutura() {
		return codigoAsignatura;
	}

	public void setCodigoAsignutura(String codigoAsignutura) {
		this.codigoAsignatura = codigoAsignutura;
	}
	
	public void eliminarNipAlumno() {
		this.nipAlumno = "";
	}
	
	public void eliminarCodigoAsignaturas () {
		this.codigoAsignatura = "";
	}
}
