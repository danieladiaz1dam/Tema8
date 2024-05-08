package ejercicio3;

import java.util.Scanner;

public class Ejercicio3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		CuentaCorriente cc = new CuentaCorriente();

		System.out.println("Introduce el Dni de la cuenta");
		try {
			cc.setDni(sc.nextLine());
		} catch (InvalidDniException e) {
			System.out.println(e);
		}

		System.out.println("Introduce el Nombre de la cuenta");
		try {
			cc.setNombre(sc.nextLine());
		} catch (InvalidNombreException e) {
			System.out.println(e);
		}

		System.out.println("Introduce el saldo de la cuenta");
		try {
			cc.setSaldo(sc.nextDouble());
		} catch (NegativeSaldoException e) {
			System.out.println(e);
		}
		
		System.out.println(cc);
		sc.close();
	}
}
