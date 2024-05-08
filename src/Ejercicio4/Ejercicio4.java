package Ejercicio4;

import java.util.Scanner;

public class Ejercicio4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Articulo art = new Articulo();
		
		try {
			System.out.println("Introduce el titular");
			art.setTitular(sc.nextLine());
		} catch (TitularInvalidoException e) {
			System.out.println(e);
		}
		
		
		try {
			System.out.println("Introduce la valoracion");
			art.setValoracion(sc.nextInt());
		} catch (ValoracionInvalidaException e) {
			System.out.println(e);
		}
		
		
		try {
			System.out.println("Introduce el escritor");
			art.setEscritor(sc.nextLine());
		} catch (EscritorInvalidoException e) {
			System.out.println(e);
		}
		
		System.out.println(art);
		sc.close();
		
	}
}
