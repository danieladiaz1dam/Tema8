package ejercicio3;

public class InvalidDniException extends Exception {
	public InvalidDniException() {
		super("Dni Inválido");
	}
	
	@Override
	public String toString() {
		return "DNI invalido";
	}
}
