package parseMolecule;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class ParseMolecule {

	public static Map<String, Integer> getAtoms(String formula) {
//		System.out.println("-".repeat(160));
//		System.out.println("In: " + formula);
		if (!Character.isDigit(formula.charAt(formula.length() - 1))) {
			formula += 1;
		}
		Pattern pattern = Pattern.compile("[\\(\\{\\[]{1}[A-Za-z0-9]+[\\}\\]\\)]{1}\\d+");
		Matcher matcher = pattern.matcher(formula);
		while (matcher.find()) {
			String key = "";
			Integer innerValue = 1;
			Integer outerValue = 1;
			String inner = formula.substring(matcher.start(), matcher.end());
			String tofill = "";
			if (Character.isDigit(inner.charAt(inner.length() - 1))) {
				outerValue = Integer.parseInt(String.valueOf(inner.charAt(inner.length() - 1)));
				inner = inner.substring(0, inner.length() - 2);
			}
			for (int i = 0; i < inner.length(); i++) {
				innerValue = 1;
				if (inner.substring(i, i + 1).matches("[\\(\\{\\[\\]\\}\\)]")) {
					continue;
				}
				if (Character.isLetter(inner.charAt(i))) {
					if (inner.substring(i, i + 1).equals(inner.substring(i, i + 1).toUpperCase())) {
						key = inner.substring(i, i + 1);
						if (i < inner.length() - 1 && Character.isDigit(inner.charAt(i + 1))) {
							innerValue = Integer.parseInt(String.valueOf(inner.charAt(i + 1)));
							inner.substring(i + 1, i + 2).equals(inner.substring(i + 1, i + 2).toUpperCase());
						}
						tofill += key + (innerValue * outerValue);
//						System.out.println("key: " + key + ", value: " + (innerValue * outerValue));
					} else {
						key += inner.substring(i, i + 1);
					}
				}
			}
			formula = formula.substring(0, matcher.start()) + tofill
					+ formula.substring(matcher.end(), formula.length());
			matcher = pattern.matcher(formula);
		}
		Pattern patternFinal = Pattern.compile("([A-Z][a-z]*)(\\d*)");
		HashMap<String, Integer> out = new HashMap<String, Integer>();
		while (formula.length() > 0) {
			Matcher matcherFinal = patternFinal.matcher(formula);
			if (matcherFinal.find()) {
				int value = 1;
				if (!(matcherFinal.group(2) == null) && !matcherFinal.group(2).isEmpty()) {
					value = Integer.parseInt(String.valueOf(matcherFinal.group(2)));
				}
				if (out.containsKey(matcherFinal.group(1))) {
					out.put(matcherFinal.group(1), out.get(matcherFinal.group(1)) + value);
				} else {
					out.put(matcherFinal.group(1), value);
				}
				formula = formula.substring(matcherFinal.end(), formula.length());
			}
		}
//		System.out.println("out:" + out.toString());
//		System.out.println();
		return out;
	}
}