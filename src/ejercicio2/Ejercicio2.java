package ejercicio2;

import java.util.Scanner;

public class Ejercicio2 {
	public static void main(String[] args) {
		Hora hora = new Hora();
		Scanner sc = new Scanner(System.in);

		try {
			System.out.print("Introduce una hora: ");
			hora.setHoras(sc.nextInt());
			
			System.out.print("Introduce unos minuto: ");
			hora.setMinutos(sc.nextInt());
			
			System.out.print("Introduce unos segundos: ");
			hora.setSegundos(sc.nextInt());
			
			System.out.println(hora);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		sc.close();
	}
}
