package convert_string_to_camel_case;

class Solution{

  static String toCamelCase(String s){
    if (s == null || s.isEmpty()) {
      return s;
    }
    String delimiter = s.contains("_") ? "_" : "-";
    boolean firstWord = true;
    String firstLetter;
    String returns = "";
    for (String word : s.split(delimiter)) {
      firstLetter = word.substring(0,1);
      if (firstWord) {
        firstWord = false;
      } else {
        firstLetter = firstLetter.toUpperCase();
      }
      word = firstLetter + word.substring(1).toLowerCase();
      returns += word;
    }
    return returns;
  }
}