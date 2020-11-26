package tests;

import ejercicios.Ejercicio1;
import ejercicios.Ejercicio2;
import ejercicios.Ejercicio3;


public class Test {

	
	public static void main(String[] args) {
		System.out.println("===========================Ejercicio 1===========================");
		System.out.println(Ejercicio1.solucionEj1(Ejercicio1.lecturaFichero1()));
		System.out.println("=========================Fin Ejercicio 1=========================\n");
		System.out.println("===========================Ejercicio 2===========================");
		Ejercicio2.solucionEj2(Ejercicio2.lecturaFichero2());
		System.out.println("=========================Fin Ejercicio 2=========================\n");
		System.out.println("===========================Ejercicio 3===========================");
		System.out.println(Ejercicio3.solucion3(Ejercicio3.lecturaFichero3()));
		System.out.println("=========================Fin Ejercicio 3=========================\n");
	}


	
	


}
