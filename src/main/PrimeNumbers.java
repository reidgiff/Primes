package main;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbers implements PrimeNumberGenerator {

	@Override
	public List<Integer> generate(int startingValue, int endingValue) {
		
		List<Integer> results = new ArrayList<Integer>();
		
		if(startingValue < endingValue) {
			for(int i = startingValue; i <= endingValue; i++) {
				if(isPrime(i)) {
					results.add(i);
				}
			}
		} else if (startingValue > endingValue) {
			for(int i = startingValue; i <= endingValue; i++) {
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
		if(value == 2 || value == 3 || value == 5) {
			return true;
		}
		if((value % 2) == 0 || (value % 3) == 0 || (value % 5) == 0) {
			return false;
		}
		
		// n+1 is prime iff n! mod (n+1) = n
		// Wilson's Theorem
		if (factorial(value-1) % (value) == value-1)
		{
			return true;
		}		
		return false;
	}
	
	//goes to infinity fast, works for 13.
	private double factorial(int num) {
		double factorial = 1;
		for(int i = 1; i <= num; i++)
		{
			factorial = factorial * i;
		}
		return factorial;
	}

}
