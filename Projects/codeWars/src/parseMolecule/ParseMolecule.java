package parseMolecule;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ParseMolecule {

	public static Map<String, Integer> getAtoms(String formula) {
		System.out.println("-".repeat(160));
		System.out.println("In: " + formula);
		// not starting with capita letter -> no molecular
		// ({[ are ignored
		Pattern validString = Pattern.compile("^[\\(\\{\\[]*[A-Z][a-z]*[0-9]*");
		Matcher validMatch = validString.matcher(formula);
		if (!validMatch.find()) {
			throw new IllegalArgumentException();
		}
		// no valid syntax ({[]})
		Stack<String> s = new Stack<String>();
		HashMap<String, String> opposite = new HashMap<String, String>();
		opposite.put("(", ")");
		opposite.put("{", "}");
		opposite.put("[", "]");
		opposite.put(")", "(");
		opposite.put("}", "{");
		opposite.put("]", "[");
		validString = Pattern.compile("[\\(\\{\\[\\]\\}\\)]");
		for (String c : formula.split("")) {
			validMatch = validString.matcher(c);
			if (validMatch.find()) {
				if(s.empty() || !opposite.get(s.peek()).equals(c)) {
					s.push(c);
				} else {
					s.pop();
				}
			}
		}
		if(!s.isEmpty()) {
			throw new IllegalArgumentException();
		}
		// start of calc
		Integer outerValue = 1;
		Integer innerValue = 1;
		Pattern pattern = Pattern.compile("[\\(\\{\\[]{1}([[A-Z]+[a-z]*[0-9]*]+)[\\}\\]\\)]{1}(\\d*)");
		Matcher matcher = pattern.matcher(formula);
		while (matcher.find()) {
			System.out.println("Found: " + matcher.group());
			String innerTerm = matcher.group(1);
			System.out.println("InnerTerm: " + innerTerm);
			if (!(matcher.group(2) == null) && !matcher.group(2).isEmpty()) {
				outerValue = Integer.parseInt(String.valueOf(matcher.group(2)));
			} else {
				outerValue = 1;
			}
			System.out.println("outerValue: " + outerValue);
			String innerHelper = "";
			Pattern innerPattern = Pattern.compile("([A-Z][a-z]*)([0-9]*)");
			Matcher innerMatcher = innerPattern.matcher(innerTerm);
			while (innerMatcher.find()) {
				if (!(innerMatcher.group(2) == null) && !innerMatcher.group(2).isEmpty()) {
					innerValue = Integer.parseInt(String.valueOf(innerMatcher.group(2)));
				} else {
					innerValue = 1;
				}
				innerHelper += innerMatcher.group(1) + (innerValue * outerValue);
				System.out.println("innerHelper: " + innerHelper);
			}
			formula = formula.replace(matcher.group(), innerHelper);
			matcher = pattern.matcher(formula);
			System.out.println(formula);
//		System.out.println("out:" + out.toString());
//		System.out.println();
		}
		HashMap<String, Integer> out = new HashMap<String, Integer>();
		Pattern patternFinal = Pattern.compile("([A-Z][a-z]*)(\\d*)");
		while (formula.length() > 0) {
			System.out.println("Create out of: " + formula);
			Matcher matcherFinal = patternFinal.matcher(formula);
			if (matcherFinal.find()) {
				int value = 1;
				if (!(matcherFinal.group(2) == null) && !matcherFinal.group(2).isEmpty()) {
					value = Integer.parseInt(String.valueOf(matcherFinal.group(2)));
				}
				System.out.println("Value: " + value);
				if (out.containsKey(matcherFinal.group(1))) {
					out.put(matcherFinal.group(1), out.get(matcherFinal.group(1)) + value);
				} else {
					out.put(matcherFinal.group(1), value);
				}
				formula = formula.substring(matcherFinal.end(), formula.length());
			}
		}
		System.out.println(out.toString());
		return out;
	}
}