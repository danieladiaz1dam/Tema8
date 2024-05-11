package ejercicio5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String nombre;
		String edad;
		
		System.out.println("Introduce tu nombre:");
		nombre = sc.nextLine();
		
		System.out.println("Introduce tu edad:");
		edad = sc.nextLine();
		
		BufferedWriter out = null;
		
		try {
			out = new BufferedWriter(new FileWriter("src/ejercicio5/Datos.txt", true));
			
			out.write("Usario: %s  |  Edad: %s".formatted(nombre, edad));
			out.newLine();
			out.flush();
			
		} catch (IOException e) {
			System.err.println("Error al abrir el archivo");
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				System.err.println("Error al cerrar el archivo");
			}
		}
		
		sc.close();
	}
}
