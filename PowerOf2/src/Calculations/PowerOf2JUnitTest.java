package Calculations;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PowerOf2JUnitTest {
	@Test
	void test() {
		Calculation calc = new Calculation();
		
		// True test cases
		
		boolean output1 = calc.isPowerOf2(2);
		assertEquals(true, output1);
		
		boolean output2 = calc.isPowerOf2(4);
		assertEquals(true, output2);
		
		boolean output3 = calc.isPowerOf2(8);
		assertEquals(true, output3);
		
		boolean output4 = calc.isPowerOf2(16);
		assertEquals(true, output4);
		
		boolean output5 = calc.isPowerOf2(32);
		assertEquals(true, output5);
		
		boolean output6 = calc.isPowerOf2(64);
		assertEquals(true, output6);
		
		boolean output7 = calc.isPowerOf2(128);
		assertEquals(true, output7);
		
		boolean output8 = calc.isPowerOf2(256);
		assertEquals(true, output8);
		
		// False Test Cases
		
		boolean output9 = calc.isPowerOf2(10);
		assertEquals(false, output9);
		
		boolean output10 = calc.isPowerOf2(20);
		assertEquals(false, output10);
		
		boolean output11 = calc.isPowerOf2(34);
		assertEquals(false, output11);
		
		boolean output12 = calc.isPowerOf2(40);
		assertEquals(false, output12);
		
		boolean output13 = calc.isPowerOf2(60);
		assertEquals(false, output13);
		
		boolean output14 = calc.isPowerOf2(66);
		assertEquals(false, output14);
		
		boolean output15 = calc.isPowerOf2(130);
		assertEquals(false, output15);
		
		boolean output16 = calc.isPowerOf2(2222);
		assertEquals(false, output16);
	}

}
