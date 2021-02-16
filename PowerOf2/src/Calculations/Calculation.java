package Calculations;

public class Calculation {
	public boolean isPowerOf2(int num) {
		return num > 0 && ((num & (num - 1)) == 0);
	}
}
