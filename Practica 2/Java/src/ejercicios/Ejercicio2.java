package ejercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Ejercicio2 {

	public static void solucionEjercicio() {
		List<String> aux = new ArrayList<String>();
		aux = lecturaFichero();
		
		int i = 0;
		while(i<aux.size()) {
			String lineaActual[] = aux.get(i).split(",");
			Integer a = Integer.parseInt(lineaActual[0]);
			Integer b = Integer.parseInt(lineaActual[1]);
			System.out.println(aux.get(i));
			if(esMultiploIterativo(a, b)) {
				System.out.println("1. Iterativa (while): true");
			}else {
				System.out.println("1. Iterativa (while): false");
			}
			if(esMultiploRecFinal(a, b)) {
				System.out.println("2. Recursiva final: true");
			}else {
				System.out.println("2. Recursiva final: false");
			}
			if(esMultiploFuncional(a, b)) {
				System.out.println("3. Funcional: true");
			}else {
				System.out.println("3. Funcional: false");
			}
			System.out.println();

			i++;
		}
	}
	
	private static List<String> lecturaFichero() {
		List<String> listaLineas = new ArrayList<String>();
		try {
			Scanner scanner = new Scanner(new File("ficheros/PI2Ej2DatosEntrada.txt"));
			
			while(scanner.hasNextLine()) {
				listaLineas.add(scanner.nextLine());
			}
			scanner.close();
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return listaLineas;
	}
	
	private static Boolean esMultiploIterativo(Integer i, Integer j) {
		Boolean res = false;
		while(!res&&i>=j) {
			if(i==j) {
				res = true;
			}
			i-=j;
		}
		return res;
	}
	
	private static Boolean esMultiploRecFinal(Integer i, Integer j) {
		return esMultiploRecFinal(i, j, true);
	}
	
	private static Boolean esMultiploRecFinal(Integer i, Integer j, Boolean res) {
		if(i-j==0){
	        return res;
	    }else if(0<i&&i<j){
	        res = false;
	        return res;
	    }else{
	        return esMultiploRecFinal(i-j,j,res);
	    }
	}
	
	private static Boolean esMultiploFuncional(Integer i, Integer j) {
		
		return Stream.iterate(i, n->n>=j, n->n=n-j).anyMatch(n->n==j);
	}
}
