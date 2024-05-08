package ejercicio2;

public class NegativeHourException extends Exception {
	public NegativeHourException() {
		super("Horas Negativas");
	}

	@Override
	public String toString() {
		return "Horas negativas";
	}
}
