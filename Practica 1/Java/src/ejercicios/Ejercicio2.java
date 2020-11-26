package ejercicios;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;

public class Ejercicio2 {

	public static List<Integer> lecturaFichero2(){
		List<Integer> listaAux = new ArrayList<Integer>();
		
		try {
			Scanner scanner = new Scanner(new File("ficheros/Prueba2.txt"));
			while(scanner.hasNextLine()) {
				String[] res = scanner.nextLine().split(": ");
				listaAux.add(Integer.parseInt(res[1]));
			}
			scanner.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return listaAux;
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
	
	
	private static String solucion2(Integer limit) {
		String solucion = "Limite: "+limit+"\n";
        Integer i = 1;
        while(i<=limit){
            if(esPrimo(i)){
                solucion = solucion + i*i + "\n";
            }
            i++;
        }

        return solucion;
	}
	
	public static void solucionEj2(List<Integer> l) {
		int i = 0;
		while(i<l.size()) {
			System.out.println(solucion2(l.get(i)));
			System.out.println("===========================");
			i++;
		}
	}
}
