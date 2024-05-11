package ejercicio1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Crea con un editor el fichero de texto NumerosReales.txt en la carpeta del
 * proyecto. Escribe en él una serie de números reales separados por espacios
 * simples. Implementar un programa que acceda a NumerosReales.txt, lea los
 * números y calcule la suma y la media aritmética, mostrando los resultados por
 * pantalla.
 * 
 */
public class Ejercicio1 {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		Scanner sc = null;

		try {
			sc = new Scanner(new FileReader("src/ejercicio1/NumerosReales.txt"));

			while (sc.hasNextInt()) {
				list.add(sc.nextInt());
			}
		} catch (FileNotFoundException e) {
			System.err.println("El archivo no se ha encontrado");
		} finally {
			if (sc != null)
				sc.close();
		}

		System.out.println("Numeros: " + list);
		System.out.println("Media: " + list.stream().mapToInt(value -> (int) value).average().getAsDouble());
		System.out.println("Suma: " + list.stream().mapToInt(value -> (int) value).sum());
	}
}
