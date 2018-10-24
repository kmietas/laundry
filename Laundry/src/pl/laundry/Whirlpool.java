package pl.laundry;

import pl.laundry.exception.ValueOutOfRangeException;

public class Whirlpool extends Pralka {
	
	public Whirlpool(int program, double temp, int v) {
		super(program, temp, v, Marka.WHIRPOOL);
	}
	
	@Override
	public void setProgram(int program) throws ValueOutOfRangeException {
		if (program < 1 || program > 25) {
			throw new ValueOutOfRangeException("Numer programu poza zakresem: " + program);
		}
		this.program = program;
	}
	
	@Override
	public void nextProgram() {
		if (program <= 24) {
			program++;
		}
	}
}
