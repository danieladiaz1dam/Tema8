package ejercicio2;

public class NegativeMinuteException extends Exception {
	public NegativeMinuteException() {
		super("Minutos Negativos");
	}

	@Override
	public String toString() {
		return "Minutos negativos";
	}
}
