import java.util.Hashtable;
import java.util.Scanner;

public class mainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int notas[][] = obtenerNotas();
		calcularMedia(notas);
		
		
	}
	
	public static int[][] obtenerNotas() {
		Scanner sc = new Scanner(System.in);
		System.out.println("¿Cuántos alumnos sois?");
		int alumnos = sc.nextInt();
		System.out.println("¿Cuántas asignaturas tenéis?");
		int asignaturas = sc.nextInt();
		
		int notas[][] = new int[alumnos][asignaturas];
		
		for(int i = 0; i< notas.length; i++) {
			for(int j = 0; j< notas[i].length;j++) {
				System.out.println("Escribe la nota del alumno "+ i+" de la asignatura "+ j);
				notas[i][j] = sc.nextInt();
			}
		}
		sc.close();
		return notas;
		
	}
	
	public static void calcularMedia(int notas[][]) {
		double mediaTotal = 0;
		double resultado;
		
		Hashtable<Integer,Double> notasMedias = new Hashtable<Integer,Double>();
		for(int i = 0; i < notas.length; i++) {
			for(int j = 0; j < notas[i].length; j++) {
				mediaTotal += notas[i][j]; //Se suman las notas de las asignaturas en una variable
			}
			resultado = mediaTotal / (notas.length -1); //Se crea la media según la suma de las asignaturas dividida entre la longitud del array
			notasMedias.put(i,resultado); //Se añade en el hashtable el numero de alumno y su nota
			mediaTotal = 0;
			
		}
		
		
		for(int i = 0; i< notas.length; i++) {
			
				System.out.println(notasMedias.get(i)); //Se muestra la nota media de cada alumno
			}
		
	}

}
