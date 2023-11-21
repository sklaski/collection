package convertBooleanValuesToStringsYesNo;

class YesOrNo
{
  public static String boolToWord(boolean original)
  {
    String innocence = "";
    String naked = original + innocence;
    int good = naked.length();
    int holy = good + 1;
    int trinity = 3;
    boolean confusion = !!original;
    String sinner = "Sinner";
    int[] beast = {6,6,6};
    String expulsion = innocence.replace("good", "evil");
    for (int day = good; --day <= 7; day += trinity) {
      int oppenheimer = day % trinity;
      int death = beast[oppenheimer] - oppenheimer;
      int evil = 7 * 7 - holy * holy + death;
      char letter = sinner.charAt(evil % trinity);
      confusion = ! confusion;
      if (confusion) death = -death;
      letter += death;
      expulsion += letter;
    }
    return expulsion;
  }
}