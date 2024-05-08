package ejercicio2;

public class NegativeSecondException extends Exception {
	public NegativeSecondException() {
		super("Segundos Negativos");
	}

	@Override
	public String toString() {
		return "Segundos Negativos";
	}
}
