package ejercicio7;

import java.util.Scanner;

public class Ejercicio7 {
	static final Scanner sc = new Scanner(System.in);

	static int menu() {
		int opt = 0;

		System.out.println("1. Nuevo contacto");
		System.out.println("2. Buscar por nombre");
		System.out.println("3. Mostrar todos los contactos");
		System.out.println("0. Salir");

		opt = sc.nextInt();
		sc.nextLine();

		if (opt < 0 || opt > 3)
			opt = 0;

		return opt;
	}

	public static void main(String[] args) {
		Agenda agenda = new Agenda(true);
		int opt = 0;
		String nombre;
		String numero;

		do {
			opt = menu();

			switch (opt) {
			case 1:
				System.out.println("Introduce el nombre del contacto:");
				nombre = sc.nextLine();
				System.out.println("Introduce el numero del contacto:");
				numero = sc.nextLine();

				if (agenda.addContacto(nombre, numero))
					System.out.println("Hecho!");
				else
					System.out.println("Ha habido un error");
				break;

			case 2:
				System.out.println("Introduce el nombre del contacto:");
				nombre = sc.nextLine();

				if ((numero = agenda.buscarContacto(nombre)) != null)
					System.out.printf("%s: %s\n", nombre, numero);
				else
					System.out.println("El conacto no se encuentra en la agenda");
				break;
				
			case 3:
				System.out.println("--- Contactos ---");
				System.out.println(agenda);
				break;
			}
		} while (opt != 0);
		
		if (agenda.save())
			System.out.println("Agenda guardada!");
		else
			System.out.println("Hubo un error al guardar la agenda");

		sc.close();
	}
}
