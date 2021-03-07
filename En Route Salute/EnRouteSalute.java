package googleProblems;

public class EnRouteSalute {
	public static void main(String[] args) {

		System.out.println(solution("<<>><"));
		System.out.println(solution("--->-><-><-->-"));
		System.out.println(solution(">----<"));
	}

	public static int solution(String s) {
		int numberOfSalutes = 0;

		int right = 0, left = 0;
		for (char c : s.toCharArray()) {

			if (c == '<') {
				numberOfSalutes += (right * 2);
			}
			if (c == '>') {
				right++;
			}
		}

		return numberOfSalutes;
	}
}
