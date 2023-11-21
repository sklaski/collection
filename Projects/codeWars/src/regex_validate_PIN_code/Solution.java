package regex_validate_PIN_code;

public class Solution {

	  public static boolean validatePin(String pin) {
	    if (pin.matches("\\d{4}")  || pin.matches("\\d{6}")) {
	      return true;
	    }
	    return false;
	  }

	}