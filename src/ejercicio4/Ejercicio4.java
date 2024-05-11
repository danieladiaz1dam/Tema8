package ejercicio4;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BufferedWriter out = null;
		String line = null;

		try {
			out = new BufferedWriter(new FileWriter("src/ejercicio4/Texto.txt"));

			do {
				line = sc.nextLine();

				out.write(line);
				out.newLine();
				out.flush();
			} while (line != null && !line.equalsIgnoreCase("fin"));

		} catch (FileNotFoundException e) {
			System.err.println("Archivo no encontrado");
		} catch (IOException e) {
			System.err.println("No se pudo leer el archivo");
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
