package googleProblems;

import java.util.*;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SolarDoomsday {

	public static int[] workingSolution(int area) {

		int MAX_SIZE = Integer.MAX_VALUE;

		List<Integer> dataSet = new ArrayList<Integer>();

		for (int i = 1; i * i <= area; i++) {
			dataSet.add(i * i);
		}

		List<Integer> tempFinalArray = new ArrayList<Integer>();

		List<Integer> reverseSort = dataSet.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

		// reverseSort.forEach(System.out::println);

		while (area > 3) {
			for (int temp : reverseSort) {
				if (area >= temp) {
					// System.out.println("1-> area= " + area + ", temp = " +
					// temp);
					area -= temp;
					tempFinalArray.add(temp);
				}
			}
		}

		while (area-- > 0) {
			tempFinalArray.add(1);
		}

		// tempFinalArray.forEach(System.out::println);
		// int[] finalArray = new int[tempFinalArray.size()];

		int[] finalArray = tempFinalArray.stream().mapToInt(i -> i).toArray();

		// int counter = 0;
		// for (int i : tempFinalArray)
		// finalArray[counter++] = i;

		return finalArray;
	}

	public static int[] solution(int area) {

		int areaLeft = area;
		List<Integer> tmpList = new ArrayList<Integer>();
		List<Integer> maxplusremain = new ArrayList<Integer>();

		while (areaLeft > 0) {
			maxplusremain = findMax(areaLeft);
			// System.out.print("maxplusremain ");
			// maxplusremain.forEach(System.out::println);
			int max = maxplusremain.get(0);
			areaLeft = maxplusremain.get(1);

			tmpList.add(max);
		}

		int finalArray[] = new int[tmpList.size()];

		for (int j = 0; j < tmpList.size(); j++) {

			finalArray[j] = tmpList.get(j) * tmpList.get(j);
		}

		return finalArray;
	}

	public static List<Integer> findMax(int tmpArea) {
		int max1 = 1;
		List<Integer> max_remainarea = new ArrayList<Integer>();
		for (int i = 1; (i * i) <= tmpArea; i++) {
			int tmpSqr = i * i;

			if (tmpSqr <= tmpArea) {
				max1 = Math.max(max1, i);

			}
		}

		max_remainarea.add(max1);
		// System.out.println(max1);
		max_remainarea.add(tmpArea - (max1 * max1));

		return max_remainarea;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int ab[] = workingSolution(n);
		// int ab[] = solution(n);

		System.out.println(Arrays.toString(ab));

	}
}
