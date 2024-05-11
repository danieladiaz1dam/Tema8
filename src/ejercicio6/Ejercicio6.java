package ejercicio6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Ejercicio6 {
	static void rellenarNumeros() {
		BufferedWriter out = null;

		try {
			out = new BufferedWriter(new FileWriter("src/ejercicio6/Numeros.txt"));

			for (int i = 0; i < 100; i++) {
				out.write(String.valueOf((int) (Math.random() * 101)));
				out.newLine();
				out.flush();
			}

		} catch (IOException e) {
			System.err.println("No se pudo crear el archivo");
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				System.err.println("No se pudo cerrar el archivo");
			}
		}
	}

	static void rellenarNumeros(ArrayList<Integer> numeros) {
		BufferedWriter out = null;

		try {
			out = new BufferedWriter(new FileWriter("src/ejercicio6/NumerosOrdenados.txt"));

			for (Integer num : numeros) {
				out.write(String.valueOf(num));
				out.newLine();
				out.flush();
			}
		} catch (IOException e) {
			System.err.println("No se pudo crear el archivo");
			e.printStackTrace();
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				System.err.println("No se pudo cerrar el archivo");
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> numeros = new ArrayList<>();
		BufferedReader in = null;
		String line;

		rellenarNumeros();

		try {
			in = new BufferedReader(new FileReader("src/ejercicio6/Numeros.txt"));

			while ((line = in.readLine()) != null) {
				numeros.add(Integer.parseInt(line));
			}

		} catch (FileNotFoundException e) {
			System.err.println("Archivo no encontrado");
		} catch (IOException e) {
			System.err.println("No se pudo crear el archivo");
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				System.err.println("No se pudo cerrar el archivo");
			}
		}

		if (numeros.size() > 0) {
			Collections.sort(numeros);
			rellenarNumeros(numeros);
		}
	}
}
