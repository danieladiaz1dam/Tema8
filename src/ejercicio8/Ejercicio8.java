package ejercicio8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class Ejercicio8 {
	static final Scanner sc = new Scanner(System.in);
	private static final String FILE_PATH = "src/ejercicio8/Temperaturas.txt";

	static int menu() {
		int opt = 0;

		System.out.println("1. Registrar nueva temperatura");
		System.out.println("2. Mostrar historial de registros");
		System.out.println("0. Salir");

		opt = sc.nextInt();
		sc.nextLine();

		if (opt < 0 || opt > 2)
			opt = 0;

		return opt;
	}

	/**
	 * Añade un registro nuevo al archivo
	 * 
	 * @param date Fecha
	 * @param max  Temperatura maxima
	 * @param min  Temperatura minima
	 * @return true si se añadio correctamente, false en caso contrario
	 */
	static boolean registrarFecha(LocalDate date, float max, float min) {
		boolean res = false;
		BufferedWriter out = null;

		try {
			out = new BufferedWriter(new FileWriter(FILE_PATH, true));

			out.write("%s,%.2f,%.2f".formatted(date, max, min));
			out.newLine();
			out.flush();

			res = true;
		} catch (IOException e) {
			System.err.println("Error al escribir en el fichero");
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				System.err.println("Error al cerrar en el fichero");
			}
		}

		return res;
	}

	/**
	 * Imprime todos los registros del fichero. Luego imprime la temperatura maxima
	 * y minima
	 */
	static void imprimirRegistros() {
		float max = Float.MIN_VALUE, min = Float.MAX_VALUE;
		String line;
		String[] datos;
		File f = new File(FILE_PATH);
		BufferedReader in = null;

		if (f.exists()) {
			try {
				in = new BufferedReader(new FileReader(f));

				while ((line = in.readLine()) != null) {
					datos = line.split(",");

					System.out.printf("%s: %s ~ %s\n", datos[0], datos[1], datos[2]);

					if (max < Float.parseFloat(datos[1]))
						max = Float.parseFloat(datos[1]);

					if (min > Float.parseFloat(datos[2]))
						min = Float.parseFloat(datos[2]);
				}
				
				System.out.println("Min: " + min);
				System.out.println("Max: " + max);

			} catch (FileNotFoundException e) {
				System.err.println("No se pudo encontrar el archivo");
			} catch (IOException e) {
				System.err.println("No se pudo leer el archivo");
			}
		}
	}

	public static void main(String[] args) {
		int opt;
		LocalDate date;
		float max;
		float min;

		do {
			opt = menu();

			switch (opt) {
			case 1:
				System.out.println("Introduce el dia (yyyy-mm-dd): ");
				date = LocalDate.parse(sc.nextLine());

				System.out.println("Introduce la temperatura maxima:");
				max = sc.nextFloat();
				sc.nextLine();

				System.out.println("Introduce la temperatura minima:");
				min = sc.nextFloat();
				sc.nextLine();

				if (registrarFecha(date, max, min))
					System.out.println("Añadida!");
				else
					System.out.println("Hubo un error");
				break;

			case 2:
				System.out.println("\n--- Registros ---");
				imprimirRegistros();
				System.out.println();
			}

		} while (opt != 0);

		sc.close();
	}
}
