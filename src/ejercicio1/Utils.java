package ejercicio1;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Proprociona funciones para leer numeros por terminal
 */
public class Utils {
	/**
	 * Scanner para leer en las funciones de la clase
	 */
	private static final Scanner sc = new Scanner(System.in);

	/**
	 * Lee un double por consola
	 * 
	 * @return double introducido, 0.0 si el valor introducido es invalido
	 */
	static double readDouble() {
		double d = 0;

		try {
			System.out.print("Introduce un double: ");
			d = sc.nextDouble();
		} catch (InputMismatchException e) {
			System.err.println("El valor introducido no es de tipo double");
		} finally {
			sc.nextLine();
		}

		return d;
	}

	/**
	 * Lee un int por consola
	 * 
	 * @return double introducido, 0 si el valor introducido es invalido
	 */
	static int readInt() {
		int i = 0;

		try {
			System.out.print("Introduce un int: ");
			i = sc.nextInt();
		} catch (InputMismatchException e) {
			System.err.println("El valor introducido no es de tipo int");
		} finally {
			sc.nextLine();
		}

		return i;
	}
}
