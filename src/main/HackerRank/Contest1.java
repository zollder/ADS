package main.HackerRank;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * HackerRank solutions - 1st round
 *
 * @author zollder
 */
public class Contest1 {

	Set<Long> megaSet = Stream.of(2l, 3l, 5l, 7l).collect(Collectors.toSet());


	/*-------------------------------------------------------------------------------------*/
	public Contest1() {
	}

	public List<Long> getMegaprimes(long min, long max) {
		List<Long> primes = new ArrayList<Long>();
		if (max < min || min < 1) {
			return primes;
		}

		//		int increment = min % 2 != 0 ? 2 : 1;

		for (long number = min; number <= max; number = number + 1) {
			if (number < 10 && megaSet.contains(number)
					|| isOdd(number)
					&& has3or7(number)
					&& isMega(number / 10)
					&& isPrime(number)) {
				primes.add(number);
			}
		}

		return primes;
	}

	private boolean isOdd(long number) {
		return number != 2 && number % 2 != 0;
	}

	private boolean has3or7(long number) {
		long lastDigit = number % 10;
		return lastDigit == 3 || lastDigit == 7;
	}

	private boolean isMega(long number) {
		while (number > 0) {
			long reminder = number % 10;
			if (!megaSet.contains(reminder)) {
				return false;
			}
			number /= 10;
		}
		return true;
	}

	private boolean isPrime(long number) {
		long root = (long) Math.sqrt(number);
		for (long i = 3; i < root; i = i + 2) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	//---------------------------------------------------------------------------------
}