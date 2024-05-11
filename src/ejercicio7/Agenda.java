package ejercicio7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Agenda {
	private static final String FILE_PATH = "src/ejercicio7/agenda.txt";
	private TreeMap<String, String> contactos;
	private boolean debug;

	public Agenda(boolean debug) {
		this.debug = debug;
		contactos = new TreeMap<>();
		load();
	}

	private boolean load() {
		boolean res = false;
		BufferedReader in = null;
		String line;

		File f = new File(FILE_PATH);

		if (f.exists()) {
			try {
				in = new BufferedReader(new FileReader(f));

				line = in.readLine();
				while (line != null && addContacto(line)) {
					line = in.readLine();
				}

				if (this.debug)
					System.out.println("Agenda cargada!");
			} catch (FileNotFoundException e) {
				if (this.debug)
					System.err.println("Archivo no encontrado");
			} catch (IOException e) {
				if (debug)
					System.err.println("Error al leer el archivo");
			} finally {
				try {
					in.close();
				} catch (IOException e) {
					if (debug)
						System.err.println("Error al cerrar el archivo");
				}
			}
		}
		
		return res;
	}

	/**
	 * Añade un contacto a la agenda
	 * 
	 * @param nombre Nombre del contacto
	 * @param numero Numero del contacto
	 * @return true si se pudo añadir el contacto, false en caso contrario
	 */
	public boolean addContacto(String nombre, String numero) {
		boolean res = false;

		if (nombre != null && !nombre.isBlank() || numero != null && !numero.isBlank() && contactos.size() < 20) {
			contactos.put(nombre, contactos.getOrDefault(nombre, numero));
			res = true;
		}

		return res;
	}

	/**
	 * Añade un contacto a la agenda
	 * 
	 * @param line Linea que se lee del archivo al cargar la agenda, con el patron
	 *             <<Nombre;Numero>>
	 * @return true si se pudo añadir el contacto, false en caso contrario
	 */
	private boolean addContacto(String line) {
		boolean res = false;
		String[] datos = line.split(";");

		if (datos.length == 2) {
			String nombre = datos[0];
			String numero = datos[1];

			if (nombre != null && !nombre.isBlank() || numero != null && !numero.isBlank() && contactos.size() < 20) {
				contactos.put(nombre, contactos.getOrDefault(nombre, numero));
				res = true;
			}
		}

		return res;
	}

	/**
	 * Busca un contacto en la agenda
	 * 
	 * @param nombre Nombre a buscar
	 * @return Devuelve el numero del contacto o null si este no se encuentra en la
	 *         agenda
	 */
	public String buscarContacto(String nombre) {
		return contactos.getOrDefault(nombre, null);
	}

	/**
	 * Guarda los contactos en el disco duro
	 * 
	 */
	public boolean save() {
		boolean res = false;
		BufferedWriter out = null;

		try {
			out = new BufferedWriter(new FileWriter(FILE_PATH));

			for (Entry<String, String> e : contactos.entrySet()) {
				out.write("%s;%s".formatted(e.getKey(), e.getValue()));
				out.newLine();
				out.flush();
			}

			res = true;
		} catch (IOException e) {
			if (this.debug)
				System.err.println("Error al abrir el fichero");
		} finally {
			try {
				out.close();
			} catch (IOException e) {
				if (this.debug)
					System.err.println("Error al cerrar el fichero");
			}
		}

		return res;
	}

	@Override
	public String toString() {
		String str = "";

		for (Entry<String, String> e : contactos.entrySet()) {
			str += "%s: %s\n".formatted(e.getKey(), e.getValue());
		}

		return str;
	}
}
