package findMissingLetter;

public class FindMissingLetter {
	public static char findMissingLetter(char[] array) {
		char memory = '0';
		for (char c : array) {
			if (memory == '0') {
				memory = (char) ((int)c - 1);
			}
			if ((int)c - (int)memory != 1) {
				System.out.println((char)((int) c - 1));
				return (char) ((int) c - 1);
			} else {
				memory = c;
			}
		}
		return ' ';
	}
}