package Ejercicio4;

public class Articulo {
	private String titular;
	private String escritor;
	private float valoracion;

	public Articulo() {
	}

	public Articulo(String titular, String escritor, float valoracion)
			throws TitularInvalidoException, EscritorInvalidoException, ValoracionInvalidaException {
		if (titular == null || titular.isBlank())
			throw new TitularInvalidoException();
		else
			this.titular = titular;

		if (escritor == null || escritor.isBlank())
			throw new EscritorInvalidoException();
		else
			this.escritor = escritor;

		if (valoracion < 0)
			throw new ValoracionInvalidaException();
		else
			this.valoracion = valoracion;
	}

	public String getTitular() {
		return titular;
	}

	public String getEscritor() {
		return escritor;
	}

	public float getValoracion() {
		return valoracion;
	}

	public void setTitular(String titular) throws TitularInvalidoException {
		if (titular == null || titular.isBlank())
			throw new TitularInvalidoException();
		else
			this.titular = titular;
	}

	public void setEscritor(String escritor) throws EscritorInvalidoException {
		if (escritor == null || escritor.isBlank())
			throw new EscritorInvalidoException();
		else
			this.escritor = escritor;
	}

	public void setValoracion(float valoracion) throws ValoracionInvalidaException {
		if (valoracion < 0)
			throw new ValoracionInvalidaException();
		else
			this.valoracion = valoracion;
	}
	
	
}
