package googleProblems;

import java.util.Arrays;

public class PleasePassTheCodedMessage {
	public static void main(String[] args) {

		int[] arr = { 3, 1, 4, 1, 5, 9 };
		int[] arr1 = { 3, 1, 4, 1, 0, 2 };
		int[] arr2 = { 1, 1 };

		// System.out.println(workingSolution(arr1));
		// System.out.println(workingSolution(arr));
		System.out.println(solution(arr1));
		System.out.println(solution(arr));
		System.out.println(solution(arr2));
	}

	public static int workingSolution(int[] l) {

		int zeroRemainder[] = new int[10];
		int oneRemainder[] = new int[10];
		int twoRemainder[] = new int[10];
		int resultArray[] = new int[10];
		int zeroFinalIndex = 0, oneFinalIndex = 0, twoFinalIndex = 0, resultArrayIndex = 0, sum = 0;
		int oneStartIndex = 0, twoStartIndex = 0;
		for (int d : l) {
			sum += d;
			resultArray[resultArrayIndex++] = d;
			if (d % 3 == 0)
				zeroRemainder[zeroFinalIndex++] = d;
			else if (d % 3 == 1)
				oneRemainder[oneFinalIndex++] = d;
			else if (d % 3 == 2)
				twoRemainder[twoFinalIndex++] = d;
		}

		// System.out.println(sum);

		Arrays.sort(zeroRemainder, 0, zeroFinalIndex);
		Arrays.sort(oneRemainder, 0, oneFinalIndex);
		Arrays.sort(twoRemainder, 0, twoFinalIndex);

		if (sum % 3 == 0) {
			int i, res = 0;
			Arrays.sort(resultArray, 0, resultArrayIndex);
			for (i = resultArrayIndex - 1; i >= 0; i--) {
				res = res * 10 + resultArray[i];
			}
			return res;
		} else if (sum % 3 == 1) {
			if (oneFinalIndex != 0)
				oneStartIndex++;
			else if (twoFinalIndex >= 2)
				twoStartIndex = twoStartIndex + 2;
			else
				return 0;
		} else if (sum % 3 == 2) {
			if (twoFinalIndex != 0)
				twoStartIndex++;
			else if (oneFinalIndex >= 2)
				oneStartIndex = oneStartIndex + 2;
			else
				return 0;
		}

		int finalArray[] = new int[20];
		int i, finalArrayIndex = 0, res = 0;

		for (i = 0; i < zeroFinalIndex; i++)
			finalArray[finalArrayIndex++] = zeroRemainder[i];
		for (i = oneStartIndex; i < oneFinalIndex; i++)
			finalArray[finalArrayIndex++] = oneRemainder[i];
		for (i = twoStartIndex; i < twoFinalIndex; i++)
			finalArray[finalArrayIndex++] = twoRemainder[i];

		Arrays.sort(finalArray, 0, finalArrayIndex);

		for (i = finalArrayIndex - 1; i >= 0; i--) {
			res = res * 10 + finalArray[i];
		}

		return res;
	}

	public static int solution(int[] l) {

		int result = 0;

		int len = l.length;

		// divided into groups based on remainder after divisible by 3
		int[] zeroRemainder = new int[10];
		int[] oneRemainder = new int[10];
		int[] twoRemainder = new int[10];
		int[] resultArray = new int[10];

		Arrays.fill(zeroRemainder, 10);
		Arrays.fill(oneRemainder, 10);
		Arrays.fill(twoRemainder, 10);
		Arrays.fill(resultArray, 10);

		int sum = 0;
		int zeroFinalIndex = 0, oneFinalIndex = 0, twoFinalIndex = 0, zeroStartIndex = 0, oneStartIndex = 0,
				twoStartIndex = 0;

		for (int num : l) {
			sum += num;

			int remainder = num % 3;
			if (remainder == 0) {
				zeroRemainder[zeroFinalIndex++] = num;
			} else if (remainder == 1) {
				oneRemainder[oneFinalIndex++] = num;
			} else if (remainder == 2) {
				twoRemainder[twoFinalIndex++] = num;
			}
		}
		Arrays.sort(zeroRemainder, 0, zeroFinalIndex);
		Arrays.sort(oneRemainder, 0, oneFinalIndex);
		Arrays.sort(twoRemainder, 0, twoFinalIndex);
		// System.out.println(Arrays.toString(zeroRemainder));
		// System.out.println(Arrays.toString(oneRemainder));
		// System.out.println(Arrays.toString(twoRemainder));
		// System.out.println(Arrays.toString(resultArray));
		// System.out.println(zeroIndex);
		// System.out.println(oneIndex);
		// System.out.println(twoIndex);
		int sumRemainder = sum % 3;
		if (sumRemainder == 0) {
			Arrays.sort(l, 0, len);
			for (int i = len - 1; i >= 0; i--)
				result = 10 * result + l[i];
			return result;

		} else if (sumRemainder == 2) {
			if (twoFinalIndex >= 1) {
				twoStartIndex++;
			} else if (oneFinalIndex >= 2) {
				oneStartIndex += 2;
			} else
				return 0;
		} else if (sumRemainder == 1) {
			if (oneFinalIndex >= 1) {
				oneStartIndex++;
			} else if (twoFinalIndex >= 2) {
				twoStartIndex += 2;
			} else
				return 0;
		}
		Arrays.sort(zeroRemainder, 0, zeroFinalIndex);
		Arrays.sort(oneRemainder, 0, oneFinalIndex);
		Arrays.sort(twoRemainder, 0, twoFinalIndex);
		// System.out.println(Arrays.toString(zeroRemainder));
		// System.out.println(Arrays.toString(oneRemainder));
		// System.out.println(Arrays.toString(twoRemainder));
		// System.out.println(zeroStartIndex + "-" + zeroFinalIndex);
		// System.out.println(oneStartIndex + "-" + oneFinalIndex);
		// System.out.println(twoStartIndex + "-" + twoFinalIndex);

		int k = 0;

		for (int i = zeroStartIndex; i < zeroFinalIndex; i++)
			resultArray[k++] = zeroRemainder[i];
		for (int i = oneStartIndex; i < oneFinalIndex; i++)
			resultArray[k++] = oneRemainder[i];
		for (int i = twoStartIndex; i < twoFinalIndex; i++)
			resultArray[k++] = twoRemainder[i];

		Arrays.sort(resultArray, 0, k);
		// System.out.println(Arrays.toString(resultArray));

		for (int i = k - 1; i >= 0; i--) {
			result = 10 * result + resultArray[i];
		}

		return result;
	}
}
