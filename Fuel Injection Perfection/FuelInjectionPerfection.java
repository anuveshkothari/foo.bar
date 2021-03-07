package googleProblems;

import java.math.BigInteger;

public class FuelInjectionPerfection {
	public static void main(String[] args) {

		// System.out.println(22 & 1);
//		System.out.println(15 & 1);
//		System.out.println(15 & 2);
		// System.out.println(7 & 2);
		// System.out.println(2 | 1);
		// System.out.println(16 | 2);

		System.out.println("prac " +new BigInteger("-4").compareTo(BigInteger.ZERO));
//		System.out.println(solution("15"));
//		System.out.println(solution("-4"));
//		System.out.println(solution("0"));
	}

	public static int solution(String x) {
		int numberOfOperation = 0;

		BigInteger number = new BigInteger(x);
		while (!number.equals(BigInteger.ONE)) {
			// number is odd
			if (!number.and(BigInteger.valueOf(1)).equals(BigInteger.ZERO)) {
				if (number.and(BigInteger.valueOf(2)).equals(BigInteger.valueOf(2)) && !number.equals(BigInteger.valueOf(3))) {
					number = number.add(BigInteger.ONE);
				} else {
					number = number.subtract(BigInteger.ONE);
				}
			} else {
				number = number.divide(BigInteger.valueOf(2));
			}
			numberOfOperation++;
		}
		return numberOfOperation;
	}
}
