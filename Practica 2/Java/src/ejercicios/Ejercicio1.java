package ejercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Ejercicio1 {
	
	static final int MAX_TAM = 50;
	
	public static void solucionEjercicio() {
		List<String> aux = new ArrayList<String>();
		aux = lecturaFichero();
		
		int i = 0;
		while(i<aux.size()) {
			System.out.println(aux.get(i).replace("#", ", "));
			System.out.println("1. Iterativa (while): "+solucionIterativa(aux.get(i)));
			System.out.println("2. Recursiva final: "+solucionRecFinal(aux.get(i)));
			System.out.println("3. Funcional: "+solucionFuncional(aux.get(i)));
			System.out.println();
			i++;
		}
	}
	
	private static List<String> lecturaFichero() {
		List<String> listaLineas = new ArrayList<String>();
		try {
			Scanner scanner = new Scanner(new File("ficheros/PI2Ej1DatosEntrada.txt"));
			
			while(scanner.hasNextLine()) {
				listaLineas.add(scanner.nextLine());
			}
			scanner.close();
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return listaLineas;
	}
	
	private static int solucionIterativa(String s) {
		
		String lineas[] = s.split("#");
		int i = 0;
		
		while(i<MAX_TAM&&(lineas[0].charAt(i) == lineas[1].charAt(i))) {
			
			i++;
		}
		
		return i;
	}
	private static int solucionRecFinal(String s) {
		return solucionRecFinal(s, 0);
	}
	private static int solucionRecFinal(String s, Integer res) {
		String lineas[] = s.split("#");
		
		if(res>=50 || (lineas[0].charAt(res) != lineas[1].charAt(res))) {
			return res;
		}else {
			return solucionRecFinal(s, res+1);
		}
		
	}
	
	private static Integer solucionFuncional(String s) {
		String lineas[] = s.split("#");
		
		Integer aux = (int) Stream.iterate(0, n->lineas[0].charAt(n) == lineas[1].charAt(n), n->n+1).count();
		
		return aux;
		
	}
}
