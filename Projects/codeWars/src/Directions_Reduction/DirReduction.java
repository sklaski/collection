package Directions_Reduction;

import java.util.HashMap;
import java.util.Stack;

public class DirReduction {
	public static String[] dirReduc(String[] arr) {
        Stack<String> s = new Stack<String>();
        for (String direction : arr) {
        	if (s.empty() || !(oppositeDirection(s.peek(), direction))) {
        		s.push(direction);
        	} else {
        		s.pop();
        	}
        }
        String[] returnString = new String[s.size()];
        for (int i = s.size() -1 ; i >= 0; i--) {
        	returnString[i] = s.pop();
        }
        return returnString;
    }

	private static boolean oppositeDirection(String lastElement, String direction) {
		HashMap<String, String> oppositeDirection = new HashMap<String, String>();
		oppositeDirection.put("NORTH", "SOUTH");
		oppositeDirection.put("EAST", "WEST");
		oppositeDirection.put("SOUTH", "NORTH");
		oppositeDirection.put("WEST", "EAST");
		if (oppositeDirection.get(lastElement).equals(direction)) {
			return true;
		} else {
			return false;
		}
	}
}
