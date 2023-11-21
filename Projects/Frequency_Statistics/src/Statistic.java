import java.util.ArrayList;

public class Statistic {

	private static ArrayList<Frequency> freqStrings = new ArrayList<>();
//	private static ArrayList<String> strings = new ArrayList<String>();

	public static void main(String[] args) {

		int foundAt = -1;
		for (String s : args) {
			foundAt = getIndexByProperty(s);
			if (foundAt == -1) {
				freqStrings.add(new Frequency(s));
				foundAt = getIndexByProperty(s);
				freqStrings.get(foundAt).setCount(1);
			} else {
				freqStrings.get(foundAt).setCount(freqStrings.get(foundAt).getCount() + 1);
			}
		}
		
		int count = 0;
		for (Frequency f : freqStrings) {
			count++;
			System.out.print(f.getString() + ": " + f.getCount() + " ".repeat(5));
			if(count % 10 == 0) {
				System.out.println();
			}
		}
	}

	private static int getIndexByProperty(String yourString) {
		for (int i = 0; i < freqStrings.size(); i++) {
			if (freqStrings != null && freqStrings.get(i).getString().equals(yourString)) {
				return i;
			}
		}
		return -1;// not there is list
	}
}