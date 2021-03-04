package googleProblems;

import java.util.HashMap;

public class BrailleTranslation {

	public static void main(String[] args) {

		// System.out.println((int)'A');
		// System.out.println((int)'Z');
		// System.out.println((int)'a');
		// System.out.println((int)'z');
		System.out.println(workingSolution("The quick brown fox jumps over the lazy dog"));
		System.out.println(workingSolution("Braille"));

	}

	public static String workingSolution(String s){

        
        StringBuilder stringBuilder = new StringBuilder();

        for (char ch: s.toCharArray()){
            if (Character.isUpperCase(ch)){
                stringBuilder.append("000001");
            }
            
            switch (Character.toLowerCase(ch)){
                case 'a':
                    stringBuilder.append("100000");
                    break;
                case 'b':
                    stringBuilder.append("110000");
                    break;
                case 'c':
                    stringBuilder.append("100100");
                    break;
                case 'd':
                    stringBuilder.append("100110");
                    break;
                case 'e':
                    stringBuilder.append("100010");
                    break;
                case 'f':
                    stringBuilder.append("110100");
                    break;
                case 'g':
                    stringBuilder.append("110110");
                    break;
                case 'h':
                    stringBuilder.append("110010");
                    break;
                case 'i':
                    stringBuilder.append("010100");
                    break;
                case 'j':
                    stringBuilder.append("010110");
                    break;
                case 'k':
                    stringBuilder.append("101000");
                    break;
                case 'l':
                    stringBuilder.append("111000");
                    break;
                case 'm':
                    stringBuilder.append("101100");
                    break;
                case 'n':
                    stringBuilder.append("101110");
                    break;
                case 'o':
                    stringBuilder.append("101010");
                    break;
                case 'p':
                    stringBuilder.append("111100");
                    break;
                case 'q':
                    stringBuilder.append("111110");
                    break;
                case 'r':
                    stringBuilder.append("111010");
                    break;
                case 's':
                    stringBuilder.append("011100");
                    break;
                case 't':
                    stringBuilder.append("011110");
                    break;
                case 'u':
                    stringBuilder.append("101001");
                    break;
                case 'v':
                    stringBuilder.append("111001");
                    break;
                case 'w':
                    stringBuilder.append("010111");
                    break;
                case 'x':
                    stringBuilder.append("101101");
                    break;
                case 'y':
                    stringBuilder.append("101111");
                    break;
                case 'z':
                    stringBuilder.append("101011");
                    break;
                default:
                    stringBuilder.append("000000");
                    break;
            }
        };
        
        return stringBuilder.toString();
	}
	public static String solution(String s) {

		HashMap<Character, String> dataSet = new HashMap<Character, String>();
		StringBuilder result = new StringBuilder();
		
		for (char c : s.toCharArray()) {

			if (Character.isUpperCase(c)) {
				result.append("000001");
			}
		}
		dataSet.put(' ', "000000");
		dataSet.put('a', "100000");
		dataSet.put('b', "110000");
		dataSet.put('c', "100100");
		dataSet.put('d', "100110");
		dataSet.put('e', "100010");
		dataSet.put('f', "110100");
		dataSet.put('g', "110110");
		dataSet.put('h', "110010");
		dataSet.put('i', "010100");
		dataSet.put('j', "010110");
		dataSet.put('k', "101000");
		dataSet.put('l', "111000");
		dataSet.put('m', "101100");
		dataSet.put('n', "101110");
		dataSet.put('o', "101010");
		dataSet.put('p', "111100");
		dataSet.put('q', "111110");
		dataSet.put('r', "111010");
		dataSet.put('s', "011100");
		dataSet.put('t', "011110");
		dataSet.put('u', "101001");
		dataSet.put('v', "111001");
		dataSet.put('w', "010111");
		dataSet.put('x', "101101");
		dataSet.put('y', "101111");
		dataSet.put('z', "101011");

		for (char c : s.toCharArray()) {

			c =Character.toLowerCase(c);

			result.append(dataSet.get(c));
		}

		return result.toString();
	}

}
