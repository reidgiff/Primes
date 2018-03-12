package main;

import java.util.List;

public class PrimeNumberGeneratorRunner {

	public static void main(String[] args) {
		PrimeNumbers generator = new PrimeNumbers();
		List<Integer> results = generator.generate(Integer.valueOf(args[0]), Integer.valueOf(args[1]));
		System.out.println(results.toString());
	}
}
