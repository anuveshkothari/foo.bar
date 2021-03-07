package googleProblems;

import java.util.Arrays;

public class FindTheAcessCodes {
	public static void main(String[] args) {

		int[] arr1 = { 1, 1, 1 };
		int[] arr2 = { 1, 2, 3, 4, 5, 6 };
		System.out.println(solution(arr1));
		System.out.println(solution(arr2));
	}

	public static int solution(int[] l) {
		int numberOfTriplets = 0;

		int len = l.length;

		for (int i = 0; i < len - 2; i++) {
			for (int j = i + 1; j < len - 1; j++) {
				if (l[j] % l[i] == 0) {
					for (int k = j + 1; k < len; k++) {
						if (l[k] % l[j] == 0)
							numberOfTriplets++;
					}
				}
			}
		}

		return numberOfTriplets;
	}
}
