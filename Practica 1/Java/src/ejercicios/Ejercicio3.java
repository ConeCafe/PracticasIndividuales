package ejercicios;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


import java.io.File;

public class Ejercicio3 {

	public static List<Punto> lecturaFichero3(){
		List<Punto> listaAux = new ArrayList<Punto>();
		
		try {
			
			Scanner scanner = new Scanner(new File("ficheros/Prueba3.txt"));
			while(scanner.hasNextLine()) {
				String stringAux = scanner.nextLine();
				String res = stringAux.substring(1, stringAux.length()-1);
				
				String[] creaPunto = res.trim().split(",");
				Punto p = new PuntoImpl(Double.parseDouble(creaPunto[0]),Double.parseDouble(creaPunto[1]));
				listaAux.add(p);
			}
			scanner.close();
			
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		return listaAux;
	}
	
public static Map<Cuadrante, Double> solucion3(List<Punto> l){
		
		Map<Cuadrante, Double> m = new TreeMap<Cuadrante, Double>();
		Integer i = 0;
		while(i<l.size()) {
			if(!m.containsKey(l.get(i).getCuadrante())) {
				m.put(l.get(i).getCuadrante(), l.get(i).getX());
			}else {
				m.replace(l.get(i).getCuadrante(), m.get(l.get(i).getCuadrante()) + l.get(i).getX());
			}
			i++;
		}
		
		return m;
	}
}
