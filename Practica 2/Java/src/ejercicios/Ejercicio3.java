package ejercicios;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

import us.lsi.common.Tuple;
public class Ejercicio3 {

	
	public static void solucionEjercicio() {
		List<String> aux = new ArrayList<String>();
		aux = lecturaFichero();
		
		int i = 0;
		while(i<aux.size()) {
			String lineaActual[] = aux.get(i).split(",");
			Long a = Long.parseLong(lineaActual[0]);
			Integer b = Integer.parseInt(lineaActual[1]);
			System.out.println(aux.get(i));
			System.out.println("1. Iterativa (while): "+potenciaIterativa(a, b));
			System.out.println("2. Recursiva no final: "+potenciaRecNoFinal(a, b));
			System.out.println("3. Recursiva final: "+potenciaRecFinal(a, b));
			System.out.println("4. Funcional: "+potenciaFuncional(a, b));
			System.out.println();

			i++;
		}
	}
	
	private static List<String> lecturaFichero() {
		List<String> listaLineas = new ArrayList<String>();
		try {
			Scanner scanner = new Scanner(new File("ficheros/PI2Ej3DatosEntrada.txt"));
			
			while(scanner.hasNextLine()) {
				listaLineas.add(scanner.nextLine());
			}
			scanner.close();
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return listaLineas;
	}
	
	private static Long potenciaIterativa(Long i, Integer j) {
		long res = 1;
	    while(j>0){
	        if(j%2==1){
	            res*=i;
	        }
	        i*=i;
	        j/=2;
	    }
	    return res;
	}
	
	private static Long potenciaRecFinal(Long i, Integer j) {
		return potenciaRecFinal(i, j, (long) 1);
	}
	private static Long potenciaRecFinal(Long i, Integer j, Long res) {
		if(j<=0) {
			return res;
		}else {
			if(j%2==1) {
				res*=i;
			}
			i*=i;
			j/=2;
			return potenciaRecFinal(i, j, res);
		}
	}
	
	private static Long potenciaRecNoFinal(Long i, Integer j) {
		long res = 1;
		if(j<=0) {
			return res;
		}else {
			if(j%2==1) {
				res*=i;
			}
			i*=i;
			j/=2;
			return res * potenciaRecNoFinal(i, j);
		}
	}
	
	public static Long potenciaFuncional(Long i, Integer j) {
		
		return Stream.iterate(Tuple.create(i, j, 1L), t->Tuple.create(t.v1*t.v1, t.v2/2, t.v2%2==1?t.v3*t.v1:t.v3))
				.dropWhile(t->t.v2>0).findFirst().get().v3;
		
	}
}
