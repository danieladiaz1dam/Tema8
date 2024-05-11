package ejercicio2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Ejercicio2 {
	public static void main(String[] args) {
		Scanner sc = null;

		try {
			sc = new Scanner(new FileReader("src/ejercicio2/Enteros.txt"));
			ArrayList<Integer> list = new ArrayList<>();

			while (sc.hasNextInt()) {
				list.add(sc.nextInt());
			}

			System.out.println("Numeros: " + list);
			System.out.println("Media: " + list.stream().mapToInt(v -> v).average().getAsDouble());
			System.out.println("Suma: " + list.stream().mapToInt(v -> v).sum());

		} catch (FileNotFoundException e) {
			System.err.println("Archivo no encontrado");
		} finally {
			if (sc != null)
				sc.close();
		}
	}
}
