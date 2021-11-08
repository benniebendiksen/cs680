package edu.umb.cs680.hw01;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PrimeGeneratorTest {
	
	@Test
	public void IsEven() {
		PrimeGenerator values = new PrimeGenerator(1, 20);
		boolean actual = values.isEven(2);
		boolean expected = true;
		assertEquals(expected, actual);
	}
	
	@Test
	public void IsPrime() {
		PrimeGenerator values = new PrimeGenerator(1, 20);
		boolean actual = values.isPrime(2);
		boolean expected = true;
		assertEquals(expected, actual);
	}
	
	@Test
	public void GetPrimes1To20() {
		PrimeGenerator actual = new PrimeGenerator(1, 20);
		actual.generatePrimes();		
		Long[] expected = {2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L};
		assertArrayEquals(expected, actual.getPrimes().toArray());
	}
	
	@Test
	public void GetPrimesNegative10To10() {
		try {
			PrimeGenerator actual = new PrimeGenerator(-10, 10);
			actual.generatePrimes();	
		}
		catch(RuntimeException e) {
		assertEquals("Wrong input values: from=-10 to=10", e.getMessage());
		}
	}

}
