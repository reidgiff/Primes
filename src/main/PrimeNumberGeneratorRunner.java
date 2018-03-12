package main;

import java.util.List;

public class PrimeNumberGeneratorRunner {

	public static void main(String[] args) {
		PrimeNumbers generator = new PrimeNumbers();
		if(args.length < 2) {
			System.out.println("2 numerical arguments seperated by a space expected");
		} else {
			try {
				List<Integer> results = generator.generate(Integer.valueOf(args[0]), Integer.valueOf(args[1]));
				System.out.println(results.toString());
			} catch (NumberFormatException e) {
				System.out.println("Number Format Exception. Numbers expected as arguement");
			}
		}
	}
}
