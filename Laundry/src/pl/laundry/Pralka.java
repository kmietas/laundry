package pl.laundry;

import java.util.List;

import pl.laundry.exception.ValueOutOfRangeException;

public abstract class Pralka {
	
	protected int		program;
	protected double	temp;
	protected int		v;
	protected Marka		marka;
	
	public Pralka(int program, double temp, int v, Marka marka) {
		try {
			setProgram(program);
		} catch (ValueOutOfRangeException e) {
			this.program = 1;
			System.out.println("Numer programu poza zakresem. Ustawiono program 1.");
		}
		
		try {
			setTemp(temp);
		} catch (ValueOutOfRangeException e) {
			this.temp = 50.0;
			System.out.println("Temperatura poza zakresem. Ustawiono temperature 50\u00b0C.");
		}
		
		try {
			setV(v);
		} catch (ValueOutOfRangeException e) {
			this.v = 800;
			System.out.println("Obroty poza zakresem. Ustawiono obroty 800.");
		}
		this.marka = marka;
	}
	
	public void setProgram(int program) throws ValueOutOfRangeException {
		if (program >= 0 && program <= 20) {
			this.program = program;
		} else {
			throw new ValueOutOfRangeException("Numer programu poza zakresem: " + program);
		}
	}
	
	public int getProgram() {
		return program;
	}
	
	public void nextProgram() {
		if (program <= 19) {
			program++;
		}
	}
	
	public void previusProgram() {
		if (program >= 2) {
			program--;
		}
	}
	
	public void setTemp(double temp) throws ValueOutOfRangeException {
		if (temp >= 0 && temp <= 90) {
			temp = Math.round(temp * 2) / 2.0;
			this.temp = temp;
			System.out.println("Temperatura prania: " + temp + "\u00b0C"); // print degree symbol java
		} else {
			throw new ValueOutOfRangeException("Temperatura poza zakresem.");
		}
	}
	
	public double getTemp() {
		return temp;
	}
	
	// skok 0 0,5 stopnia celsujasz
	public void tempUp() {
		if (temp <= 89.5) {
			try {
				setTemp(temp + 0.5);
			} catch (ValueOutOfRangeException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Przekroczony zakres. Nie można podnieść temperatury prania");
		}
	}
	
	public void tempDown() {
		if (temp >= 0.5) {
			try {
				setTemp(temp - 0.5);
			} catch (ValueOutOfRangeException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Przekroczony zakres. Nie można obniżyć temperatury prania");
		}
	}
	
	public void setV(int v) throws ValueOutOfRangeException {
		if (v >= 0 && v <= 1000) {
			this.v = (v + 50) / 100 * 100; // integer division
		} else {
			throw new ValueOutOfRangeException("Obroty poza zakresem.");
		}
	}
	
	public int getV() {
		return v;
	}
	
	public void upV() {
		if (v == 1000) {
			v = 0;
		} else {
			try {
				setV(v + 100);
			} catch (ValueOutOfRangeException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void downV() {
		if (v == 0) {
			v = 1000;
		} else {
			try {
				setV(v - 100);
			} catch (ValueOutOfRangeException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void sort(List<Pralka> pralki) {
		System.out.println("----------------------");
		System.out.println("Lista przed posortowaniem: ");
		pralki.stream()
				.forEach(pralka -> System.out.println(pralka));
		
		System.out.println("Lista po posortowaniu: ");
		pralki.stream()
				.sorted((p1, p2) -> p1.marka
						.compareTo(p2.marka))
				.forEach(pralka -> System.out.println(pralka));
	}
	
	public String toString() {
		return "[marka=" + marka + ", program=" + program + ", temp=" + temp + ", v=" + v + "]";
	}
	
	// showStatus
	public void showStatus() {
		System.out.println(this);
	}
	
}
