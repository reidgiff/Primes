package test;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.PrimeNumberGeneratorRunner;
import main.PrimeNumbers;

public class PrimesTest {
	PrimeNumbers primeNumbers = new PrimeNumbers();
	List<Integer> primes23 = Arrays.asList(2,3,5,7,11,13, 17, 19, 23);
	List<Integer> primes7920 = Arrays.asList(7901,7907,7919);
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
	@Before
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	}
	
	@After
	public void restoreStreams() {
	    System.setOut(System.out);
	}
	
	@Test
	public void primes() {
		assertTrue(primeNumbers.isPrime(2));
		assertTrue(primeNumbers.isPrime(3));
		assertTrue(primeNumbers.isPrime(5));
		assertTrue(primeNumbers.isPrime(7));
		assertTrue(primeNumbers.isPrime(11));
		assertTrue(primeNumbers.isPrime(13));
		assertTrue(primeNumbers.isPrime(97));
		assertTrue(primeNumbers.isPrime(101));
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
	public void primeList23() {
		List<Integer> x = primeNumbers.generate(1, 27);
		assertEquals(primes23, x);
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
	
	@Test
	public void backwards() {
		List<Integer> x = primeNumbers.generate(27, 0);
		assertEquals(primes23, x);
		List<Integer> y = primeNumbers.generate(7920, 7900);
		assertEquals(primes7920, y);
		x = primeNumbers.generate(1000, 0);
		assertEquals(x.size(), 168);
	}
	
	@Test
	public void factorialTest() {
		assertEquals(BigInteger.valueOf(720), primeNumbers.factorial(6));
	}
	
	
	public void listCount() {
		List<Integer> x = primeNumbers.generate(0, 101);
		assertEquals(x.size(), 26);
		x = primeNumbers.generate(0, 10);
		assertEquals(x.size(), 4);
		x = primeNumbers.generate(0, 100);
		assertEquals(x.size(), 25);
		x = primeNumbers.generate(0, 1000);
		assertEquals(x.size(), 168);
		x = primeNumbers.generate(0, 10000);
		assertEquals(x.size(), 1229);
	}
	
	@Test
	public void startEqualsEnd() {
		List<Integer> x = primeNumbers.generate(2, 2);
		assertEquals(Arrays.asList(2), x);
		x = primeNumbers.generate(97, 97);
		assertEquals(Arrays.asList(97), x);
		x = primeNumbers.generate(16, 16);
		assertTrue(x.isEmpty());
		x = primeNumbers.generate(7901, 7901);
		assertEquals(Arrays.asList(7901), x);
	}
	
	@Test
	public void negativeInputs() {
		List<Integer> x = primeNumbers.generate(-1000, 3);
		assertEquals(Arrays.asList(2,3), x);
		x = primeNumbers.generate(-1000, -100);
		assertTrue(x.isEmpty());
	}

	@Test
	public void runner13() {
		PrimeNumberGeneratorRunner primeNumberGeneratorRunner = new PrimeNumberGeneratorRunner();		
		String[] args = new String[2];
		args[0] = "1";
		args[1] = "13";		
		primeNumberGeneratorRunner.main(args);
		assertEquals("[2, 3, 5, 7, 11, 13]", outContent.toString().trim());
	}
	
	@Test
	public void runner() {
		PrimeNumberGeneratorRunner primeNumberGeneratorRunner = new PrimeNumberGeneratorRunner();		
		String[] args = new String[2];
		args[0] = "7900";
		args[1] = "7920";		
		primeNumberGeneratorRunner.main(args);
		assertEquals("[7901, 7907, 7919]", outContent.toString().trim());
	}
	
	@Test
	public void runnerLetters() {
		PrimeNumberGeneratorRunner primeNumberGeneratorRunner = new PrimeNumberGeneratorRunner();		
		String[] args = new String[2];
		args[0] = "F";
		args[1] = "13";		
		primeNumberGeneratorRunner.main(args);
		assertEquals("Number Format Exception. Numbers expected as arguement", outContent.toString().trim());
	}
	@Test
	public void runnerOne() {
		PrimeNumberGeneratorRunner primeNumberGeneratorRunner = new PrimeNumberGeneratorRunner();		
		String[] args = new String[1];
		args[0] = "13";		
		primeNumberGeneratorRunner.main(args);
		assertEquals("2 numerical arguments seperated by a space expected", outContent.toString().trim());
	}
	
}
