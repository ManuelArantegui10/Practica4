package Practica4;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("Ordenes ha realizar: ");
		System.out.println("Matricula");
		System.out.println("Asignaturas nip [A] [C]");
		System.out.println("Alumnos codigo [A] [N]");
		System.out.println("Eliminar nip {codigo}");
		System.out.println("Matricular nip codigo {codigo}");
		Scanner Entrada = new Scanner(System.in);
		System.out.println("Escribe la orden que desea realizar");
		System.out.println("Orden> ");
		String cadena = "Asignaturas,627867";
//		"Eliminar 627867 30201"
		while(!cadena.equals("Fin")) {
			String[] textoJunto = cadena.split(",");
			int length = textoJunto.length;
			if (textoJunto[0].equals("Matricula")) {
				matriculas();
			} else if (textoJunto[0].equals("Asignaturas")) {
				System.out.println("Entraste en Asignaturas nip");
				asignaturas(textoJunto, length);
			} else if (textoJunto[0].equals("Alumnos")) {
			} else if (textoJunto[0].equals("Eliminar")) {
				eliminar(textoJunto, length);
			} else if (textoJunto[0].equals("Matricular")) {
			}
			System.out.println("Escribe la orden que desea realizar");
			cadena = Entrada.nextLine();
		}
		System.out.println("El programa ha finalizado");
	}

	
	/**
	 * 
	 * 
	 */
	public static void matriculas () {
		try {
			DataInputStream f = new DataInputStream(new FileInputStream("Ficheros\\practica4\\matriculas.dat"));
			File file1 = new File("Ficheros\\practica4\\alumnos.csv");
			Scanner f1 = new Scanner(file1);
			ArrayList<String> nips = new ArrayList<String>();
			int lineas = 0;
			while(f1.hasNextLine()) {
				String linea = f1.nextLine();
				lineas++;
				String[] lineaSeparada = linea.split(";");
				if (lineas != 1) {
					String nip = lineaSeparada[0];
					nips.add(nip);
				}
			}
			int numeroMatriculas = 0;
			ArrayList<String> matriculas = new ArrayList<String>();
			ArrayList<Integer> total = new ArrayList<Integer>();
				try {
					while(true) {
						int nip = f.readInt();
						int codigoAsignatura = f.readInt();
//						Matricula user = new Matricula();
//						user.setNipAlumno(nip);
//						user.setCodigoAsignutura(codigoAsignatura);
//						matriculas.add(user);		
					    String numCadena= String.valueOf(nip);
					    numCadena = numCadena.trim();
					    matriculas.add(numCadena);
					    System.out.println(nip + " ==> " + codigoAsignatura);
						nip = 0; codigoAsignatura = 0;
					}
				} catch (IOException e) {
				    for (int i = 0; i < nips.size(); i++) {
						for(int j = 0; j < matriculas.size(); j++) {
							String x = matriculas.get(j);
							if(nips.get(i).equals(x)) {
								numeroMatriculas++;
							}
						}	
						total.add(numeroMatriculas);
						numeroMatriculas = 0;
					}
					for(int x = 0; x < total.size(); x++) {
						System.out.println(nips.get(x) + " ==> " + total.get(x) + " asignaturas matriculas.");
					}
				}
				f.close();
				f1.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error en operación de E/S con el fichero ");
		}
	}
	
	/**
	 * 
	 * 
	 */
	public static void asignaturas (String[] textoJunto, int length) {
		try {
			DataInputStream f = new DataInputStream(new FileInputStream("Ficheros\\practica4\\matriculas.dat"));
			ArrayList<Matricula> matriculas = new ArrayList<Matricula>();
			ArrayList<Matricula> matEliminar = new ArrayList<Matricula>();
			ArrayList<Matricula> matTotal = new ArrayList<Matricula>();
				try {
					while(true) {
						int nip = f.readInt();
						int codigoAsignatura = f.readInt();;		
					    String numCadena = String.valueOf(nip);
					    numCadena = numCadena.trim();
					    String numCadena2 = String.valueOf(codigoAsignatura);
					    numCadena = numCadena.trim();
					    Matricula mat1 = new Matricula();
					    mat1.setNipAlumno(numCadena);
					    mat1.setCodigoAsignutura(numCadena2);
					    matriculas.add(mat1);
						nip = 0; codigoAsignatura = 0;
					}
				} catch (IOException e) {
				    String nipA = null;
				    Iterator itMat = matriculas.iterator();
				    while(itMat.hasNext()) {
				    	Matricula mat = (Matricula)itMat.next();
				    	if (textoJunto[1].equals(mat.getNipAlumno())) {
				    		String Nip = mat.getNipAlumno();
				    		String cod = mat.getCodigoAsignutura();
				    		Matricula mat2 = new Matricula();
						    mat2.setNipAlumno(Nip);
						    mat2.setCodigoAsignutura(cod);
						    nipA = mat2.getNipAlumno();
						    matEliminar.add(mat2);
				    	}
				    }
				    Iterator itMat2 = matEliminar.iterator();
				    while(itMat.hasNext() & itMat2.hasNext()) {
				    	Matricula mat = (Matricula)itMat.next();
				    	Matricula mat2 = (Matricula)itMat2.next();
				    	if(mat2.getNipAlumno().equals(mat.getNipAlumno())) {
				    		Matricula matr3 = new Matricula();
						    matr3.setNipAlumno(mat.getNipAlumno());
						    matr3.setCodigoAsignutura(mat.getCodigoAsignutura());
						    matTotal.add(matr3);
				    	}
				    }
				    Iterator itMat3 = matEliminar.iterator();
					File file1 = new File("Ficheros\\practica4\\asignaturas.txt");
				    Scanner f1 = new Scanner(file1);
					ArrayList<String> nombres = new ArrayList<String>();
					ArrayList<String> total = new ArrayList<String>();
					ArrayList<String> nips = new ArrayList<String>();
					String nombre = "";
					int lineas = 0;
					while(f1.hasNextLine()) {
						String linea = f1.nextLine();
						total.add(linea);
						lineas++;
						String[] lineaSeparada = linea.split(" ");
						for(int i = 4; i < lineaSeparada.length; i++) {
							nombre = nombre + " " + lineaSeparada[i];
						}
						nombre = nombre.trim();
						nombres.add(nombre);
						String nip = lineaSeparada[0];
						nips.add(nip);
						nombre = "";
					}
					ArrayList<String> cods = new ArrayList<String>();
					while(itMat2.hasNext()) {
				    	Matricula mat3 = (Matricula)itMat2.next();
				    	cods.add(mat3.getCodigoAsignutura());
				    }
					ArrayList<String> arrayFinal = new ArrayList<String>();
					for(int i = 0; i < cods.size(); i++) {
						for(int j = 0; j < nips.size(); j++) {
							if(cods.get(i).equals(nips.get(j))) {
						    			arrayFinal.add(nombres.get(j));		
				    		}
						}
			    	}
					if (length == 3) {
						if (textoJunto[2].equals("A")) {
							Collections.sort(arrayFinal);
						}
					}
					for(int i = 0; i < arrayFinal.size(); i++) {
		    			System.out.println(nipA + " ==> " + arrayFinal.get(i));
					}
				}
				f.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error en operación de E/S con el fichero ");
		}
	}
	
	/**
	 * 
	 * 
	 */
	public static void alumnos (File file3){
		
	}
	
	/**
	 * 
	 * 
	 */
	public static void eliminar (String[] textoJunto, int length) {
		try {
			DataInputStream f = new DataInputStream(new FileInputStream("Ficheros\\practica4\\matriculas.dat"));
			ArrayList<Matricula> matriculas = new ArrayList<Matricula>();
			ArrayList<Matricula> matEliminar = new ArrayList<Matricula>();
			ArrayList<Matricula> matTotal = new ArrayList<Matricula>();
			if (length == 2) {
				try {
					while(true) {
						int nip = f.readInt();
						int codigoAsignatura = f.readInt();
//						Matricula user = new Matricula();
//						user.setNipAlumno(nip);
//						user.setCodigoAsignutura(codigoAsignatura);
//						matriculas.add(user);		
					    String numCadena = String.valueOf(nip);
					    numCadena = numCadena.trim();
					    String numCadena2 = String.valueOf(codigoAsignatura);
					    numCadena = numCadena.trim();
					    Matricula mat1 = new Matricula();
					    mat1.setNipAlumno(numCadena);
					    mat1.setCodigoAsignutura(numCadena2);
					    matriculas.add(mat1);
						nip = 0; codigoAsignatura = 0;
					}
				} catch (IOException e) {
				    Iterator itMat = matriculas.iterator();
				    while(itMat.hasNext()) {
				    	Matricula mat = (Matricula)itMat.next();
				    	if (textoJunto[1].equals(mat.getNipAlumno())) {
				    		String Nip = mat.getNipAlumno();
				    		String cod = mat.getCodigoAsignutura();
				    		Matricula mat2 = new Matricula();
						    mat2.setNipAlumno(Nip);
						    mat2.setCodigoAsignutura(cod);
						    matEliminar.add(mat2);
				    	}
				    }
				    Iterator itMat2 = matEliminar.iterator();
				    while(itMat.hasNext() & itMat2.hasNext()) {
				    	Matricula mat = (Matricula)itMat.next();
				    	Matricula mat2 = (Matricula)itMat2.next();
				    	if(mat2.getNipAlumno().equals(mat.getNipAlumno())) {
				    		Matricula matr3 = new Matricula();
						    matr3.setNipAlumno(mat.getNipAlumno());
						    matr3.setCodigoAsignutura(mat.getCodigoAsignutura());
						    matTotal.add(matr3);
				    	}
				    }
				    Iterator itMat3 = matEliminar.iterator();
				    while(itMat3.hasNext()) {
				    	Matricula mat3 = (Matricula)itMat3.next();
				    	System.out.println(mat3.getNipAlumno() + " ==> " + mat3.getCodigoAsignutura());
				    }
				}
				f.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Error en operación de E/S con el fichero ");
		}
		
		if(length == 3) {
			try {
				DataInputStream f = new DataInputStream(new FileInputStream("Ficheros\\practica4\\matriculas.dat"));
				ArrayList<Matricula> matriculas = new ArrayList<Matricula>();
				ArrayList<Matricula> matEliminar = new ArrayList<Matricula>();
				ArrayList<Matricula> matTotal = new ArrayList<Matricula>();
					try {
						while(true) {
							int nip = f.readInt();
							int codigoAsignatura = f.readInt();
//							Matricula user = new Matricula();
//							user.setNipAlumno(nip);
//							user.setCodigoAsignutura(codigoAsignatura);
//							matriculas.add(user);		
						    String numCadena = String.valueOf(nip);
						    numCadena = numCadena.trim();
						    String numCadena2 = String.valueOf(codigoAsignatura);
						    numCadena = numCadena.trim();
						    Matricula mat1 = new Matricula();
						    mat1.setNipAlumno(numCadena);
						    mat1.setCodigoAsignutura(numCadena2);
						    matriculas.add(mat1);
							nip = 0; codigoAsignatura = 0;
						}
					} catch (IOException e) {
					    Iterator itMat = matriculas.iterator();
					    while(itMat.hasNext()) {
					    	Matricula mat = (Matricula)itMat.next();
					    	if (textoJunto[1].equals(mat.getNipAlumno()) && textoJunto[2].equals(mat.getCodigoAsignutura())) {
					    		String Nip = mat.getNipAlumno();
					    		String cod = mat.getCodigoAsignutura();
					    		Matricula mat2 = new Matricula();
							    mat2.setNipAlumno(Nip);
							    mat2.setCodigoAsignutura(cod);
							    matEliminar.add(mat2);
					    	}
					    }
					    Iterator itMat2 = matEliminar.iterator();
					    while(itMat.hasNext() & itMat2.hasNext()) {
					    	Matricula mat = (Matricula)itMat.next();
					    	Matricula mat2 = (Matricula)itMat2.next();
					    	if(!mat2.getNipAlumno().equals(mat.getNipAlumno())) {
					    		Matricula matr3 = new Matricula();
							    matr3.setNipAlumno(mat.getNipAlumno());
							    matr3.setCodigoAsignutura(mat.getCodigoAsignutura());
							    matTotal.add(matr3);
					    	}
					    }
					   Iterator itMat3 = matEliminar.iterator();
					   while(itMat3.hasNext()) {
						   Matricula mat3 = (Matricula)itMat3.next();
						   System.out.println(mat3.getNipAlumno() + " ==> " + mat3.getCodigoAsignutura());
					   }
				}
				f.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Error en operación de E/S con el fichero ");
			}
		}
	}

	
	/**
	 * 
	 * 
	 */
	public static void matricular (File file3){
		
	}
}
