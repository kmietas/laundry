package pl.laundry;

import pl.laundry.exception.ValueOutOfRangeException;

public class Beko extends Pralka {
	
	public Beko(int program, double temp, int v) {
		super(program, temp, v, Marka.BEKO);
	}
	
	public void tempUp() {
		if (temp >= 0 && temp <= 89.0) {
			try {
				setTemp(temp + 1);
			} catch (ValueOutOfRangeException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Przekroczony zakres. Nie można podnieść temperatury prania"); // dodac Exception
		}
	}
	
	public void tempDown() {
		if (temp >= 1 && temp <= 90) {
			try {
				setTemp(temp - 1);
			} catch (ValueOutOfRangeException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Przekroczony zakres. Nie można obniżyć temperatury prania");
		}
	}
}
