package Josephus_Permutation;

import java.util.ArrayList;
import java.util.List;

public class Josephus {
	public static <T> List<T> josephusPermutation(final List<T> items, final int k) {
		System.out.println(items + ", " + k);
		List<T> out = new ArrayList<T>();
		int counter = k - 1;
		while (items.size() >= 1) {
//			System.out.println(items);
			while (counter >= items.size()) {
				counter -= items.size();
			}
			out.add(items.remove(counter));
			counter += k - 1;
//			System.out.println(out.toString());
//			System.out.println(counter + " " + items.size());
		}
		System.out.println("End: " + out.toString());
		return out;
	}
}