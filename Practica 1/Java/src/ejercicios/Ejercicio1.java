package ejercicios;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;

public class Ejercicio1 {
	
	
	public static List<List<Integer>> lecturaFichero1(){
		List<Integer> listaAux;
		List<List<Integer>> listasAux = new ArrayList<List<Integer>>();
		
		
		try {
			
			Scanner scanner = new Scanner(new File("ficheros/Prueba1.txt"));
			while(scanner.hasNextLine()) {
				int i = 0;
				listaAux = new ArrayList<Integer>();
				String[] res = scanner.nextLine().split(", ");
				while(i<res.length) {
					listaAux.add(Integer.parseInt(res[i]));
					i++;
				}
				listasAux.add(listaAux);
			}
			scanner.close();
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return listasAux;
	}

	private static Boolean esPrimo(Integer i) {
		if(i<2) {
			return false;
		}else if(i==2){
			return true;
		}
		else {
			int j = 2;
			while(j<=i/2) {
				if(i%j==0) {
					return false;
				}
				j++;
			}
		return true;
		}
	}
	public static List<Integer> solucionEj1(List<List<Integer>> listas){
		int i = 0;
		List<Integer> solucion = new ArrayList<Integer>();
		
		while(i<listas.size()) {
			int j = 0;
			
			while(j<listas.get(i).size()) {
				if(esPrimo(listas.get(i).get(j))) {
					solucion.add(listas.get(i).get(j));
				}
				j++;
			}
			i++;
		}
		return solucion;
	}
}
