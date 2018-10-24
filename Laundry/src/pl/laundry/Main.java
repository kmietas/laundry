package pl.laundry;

import java.util.Arrays;
import java.util.List;

import pl.laundry.exception.ValueOutOfRangeException;

public class Main {
	
	public static void main(String[] args) {
		Beko beko = new Beko(-5, 50.0, 500);
		Whirlpool whirlpool = new Whirlpool(6, 60.0, 600);
		Amica amica = new Amica(7, 70.0, 900);
		
		try {
			beko.setProgram(25);
		} catch (ValueOutOfRangeException e) {
			e.printStackTrace();
		}
		beko.showStatus();
		
		try {
			whirlpool.setProgram(25);
		} catch (ValueOutOfRangeException e) {
			e.printStackTrace();
		}
		whirlpool.showStatus();
		
		whirlpool.nextProgram();
		whirlpool.showStatus();
		
		whirlpool.tempUp();
		whirlpool.showStatus();
		
		beko.tempDown();
		beko.showStatus();
		
		try {
			amica.setTemp(90.0);
		} catch (ValueOutOfRangeException e) {
			e.printStackTrace();
		}
		
		amica.upV();
		amica.showStatus();
		amica.upV();
		amica.showStatus();
		
		List<Pralka> pralki = Arrays.asList(beko, whirlpool, amica);
		Pralka.sort(pralki);
	}
	
}
