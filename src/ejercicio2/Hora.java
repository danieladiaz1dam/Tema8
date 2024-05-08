package ejercicio2;

public class Hora {
	private int segundos;
	private int minutos;
	private int horas;

	public Hora() {
	}

	public int getSegundos() {
		return segundos;
	}

	public int getMinutos() {
		return minutos;
	}

	public int getHoras() {
		return horas;
	}

	public void setSegundos(int segundos) throws NegativeSecondException {
		if (segundos < 0)
			throw new NegativeSecondException();
		else if (segundos >= 60)
			this.segundos = 59;
		else
			this.segundos = segundos;
	}

	public void setMinutos(int minutos) throws NegativeMinuteException {
		if (minutos < 0)
			throw new NegativeMinuteException();
		else if (minutos >= 60)
			this.minutos = 59;
		else
			this.minutos = minutos;
	}

	public void setHoras(int horas) throws NegativeHourException {
		if (horas < 0)
			throw new NegativeHourException();
		else if (horas >= 23)
			horas = 0;
		else
			this.horas = horas;
	}

	@Override
	public String toString() {
		return "%2d:%2d:%2d".formatted(this.segundos, this.minutos, this.horas);
	}
}
