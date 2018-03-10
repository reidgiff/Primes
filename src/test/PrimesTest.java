package test;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import main.PrimeNumbers;

public class PrimesTest {
	PrimeNumbers primeNumbers = new PrimeNumbers();
	List<Integer> primes13 = Arrays.asList(2,3,5,7,11,13);
	List<Integer> primes7920 = Arrays.asList(7901,7907,7919);
	
	@Test
	public void primes() {
		assertTrue(primeNumbers.isPrime(2));
		assertTrue(primeNumbers.isPrime(3));
		assertTrue(primeNumbers.isPrime(5));
		assertTrue(primeNumbers.isPrime(7));
		assertTrue(primeNumbers.isPrime(11));
	}
	
	@Test
	public void notPrimes() {
		assertFalse(primeNumbers.isPrime(-3));
		assertFalse(primeNumbers.isPrime(0));
		assertFalse(primeNumbers.isPrime(1));
		assertFalse(primeNumbers.isPrime(4));
		assertFalse(primeNumbers.isPrime(6));
		assertFalse(primeNumbers.isPrime(27));
	}
	
	@Test
	public void primeList13() {
		List<Integer> x = primeNumbers.generate(1, 16);
		assertEquals(primes13, x);
	}
	
	@Test
	public void primeList7920() {
		List<Integer> x = primeNumbers.generate(7900, 7920);
		assertEquals(primes7920, x);
	}
	
	@Test
	public void emptyList() {
		List<Integer> x = primeNumbers.generate(14, 16);
		assertTrue(x.isEmpty());
	}

}
