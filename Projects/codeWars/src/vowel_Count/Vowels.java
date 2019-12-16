package vowel_Count;

import java.util.regex.*;
 // 
    //  return s.matches("[a-z_\\d]{4,16}");

public class Vowels {

  public static int getCount(String str) {
    int vowelsCount = 0;
    Pattern pattern = Pattern.compile("[aeiou]");
    Matcher matcher = pattern.matcher(str);
    while (matcher.find()) {
        vowelsCount++;
    }
    return vowelsCount;
  }

}
