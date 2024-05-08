package ejercicio3;

public class NegativeSaldoException extends Exception {
	public NegativeSaldoException() {
		super("Saldo Negativo");
	}
	
	@Override
	public String toString() {
		return "Saldo negativo";
	}
}
