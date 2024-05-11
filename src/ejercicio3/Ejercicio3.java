package ejercicio3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Ejercicio3 {
	public static void main(String[] args) {
		BufferedReader in = null;
		String line;
		int sumaEdades = 0, sumaAlturas = 0, contador = 0;
		String datos[];

		try {
			in = new BufferedReader(new FileReader("src/ejercicio3/Alumnos.txt"));

			while ((line = in.readLine()) != null) {
				datos = line.split(";");

				System.out.printf("Alumno #%d: %s\n", ++contador, datos[0]);

				sumaEdades += Integer.parseInt(datos[1]);
				sumaAlturas += Integer.parseInt(datos[2]);

				System.out.println("\nMedia edades: " + (sumaEdades / contador));
				System.out.println("Media alturas: " + (sumaAlturas / contador));
			}

		} catch (FileNotFoundException e) {
			System.err.println("Archivo no encontrado");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				System.err.println("No se pudo cerrar el archivo");
			}
		}
	}
}
