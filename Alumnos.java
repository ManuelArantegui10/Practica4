package Practica4;

public class Alumnos {
	private int nipAlumno;
	private String apellidos;
	private String nombre;
	
	public Alumnos(int nipAlumno, String apellidos, String nombre) {
		this.nipAlumno = nipAlumno;
		this.apellidos = apellidos;
		this.nombre = nombre;
	}

	public int getNipAlumno() {
		return nipAlumno;
	}

	public void setNipAlumno(int nipAlumno) {
		this.nipAlumno = nipAlumno;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
}
