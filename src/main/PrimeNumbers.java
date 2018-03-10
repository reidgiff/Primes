package main;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers implements PrimeNumberGenerator {

	@Override
	public List<Integer> generate(int startingValue, int endingValue) {
		
		List<Integer> results = new ArrayList<Integer>();
		
		if(startingValue <= endingValue) {
			for(int i = startingValue; i <= endingValue; i++) {
				if(isPrime(i)) {
					results.add(i);
				}
			}
		} else if (startingValue > endingValue) {
			for(int i = endingValue; i <= startingValue; i++) {
				if(isPrime(i)) {
					results.add(i);
				}	
			}
		}
		return results;
	}

	@Override
	public boolean isPrime(int value) {
		if(value < 2) {
			return false;
		}
		//for performance, arbitrarily check the first few primes and if value has them as a factor
		if(value == 2 || value == 3 || value == 5) {
			return true;
		}
		if((value % 2) == 0 || (value % 3) == 0 || (value % 5) == 0) {
			return false;
		}
		
		// n+1 is prime iff n! mod (n+1) = n
		// Wilson's Theorem
		if (factorial(value-1).mod(BigInteger.valueOf(value)).equals(BigInteger.valueOf(value-1)))
		{
			return true;
		}		
		return false;
	}
	
	public BigInteger factorial(int num) {
		BigInteger factorial = BigInteger.ONE;
		for(int i = 1; i <= num; i++)
		{
			factorial = factorial.multiply(BigInteger.valueOf(i));
		}
		return factorial;
	}

}
