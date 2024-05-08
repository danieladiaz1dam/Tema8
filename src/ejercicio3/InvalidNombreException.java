package ejercicio3;

public class InvalidNombreException extends Exception {
	public InvalidNombreException() {
		super("Nombre Inválido");
	}
	
	@Override
	public String toString() {
		return "Nombre invalido";
	}
}
