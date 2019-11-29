package Josephus_Permutation;

import java.util.ArrayList;
import java.util.List;

public class Josephus {
	public static <T> List<T> josephusPermutation(final List<T> items, final int k) {
		System.out.println(items);
		List<T> killedOrder = new List<T>();
		//ArrayList<String> killedOrder = new ArrayList<String>();
		int toKill = k - 1;
		while (!items.isEmpty()) {
			killedOrder.add((String) items.get(toKill));
			items.remove(toKill);
			toKill += k;
			System.out.println(items);
			System.out.println(killedOrder);
			if (toKill > items.size()) {
				toKill -= items.size();
			}

		}
		return killedOrder;
	}
}