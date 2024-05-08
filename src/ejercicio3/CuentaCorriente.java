package ejercicio3;

public class CuentaCorriente {
	private double saldo;
	private String dni;
	private String nombre;

	public CuentaCorriente() {
	}

	public CuentaCorriente(double saldo, String dni, String nombre)
			throws NegativeSaldoException, InvalidDniException, InvalidNombreException {
		if (saldo < 0)
			throw new NegativeSaldoException();
		else
			this.saldo = saldo;

		if (dni == null || dni.isBlank())
			throw new InvalidDniException();
		else
			this.dni = dni;

		if (nombre == null || nombre.isBlank())
			throw new InvalidNombreException();
		else
			this.nombre = nombre;
	}

	public void setSaldo(double saldo) throws NegativeSaldoException {
		if (saldo < 0)
			throw new NegativeSaldoException();
		else
			this.saldo = saldo;
	}

	public void setDni(String dni) throws InvalidDniException {
		if (dni == null || dni.isBlank())
			throw new InvalidDniException();
		else
			this.dni = dni;
	}

	public void setNombre(String nombre) throws InvalidNombreException {
		if (nombre == null || nombre.isBlank())
			throw new InvalidNombreException();
		else
			this.nombre = nombre;
	}

	@Override
	public String toString() {
		return "Nombre: %s\nDni: %s\nSaldo actual: %.2f".formatted(this.nombre, this.dni, this.saldo);
	}
}
