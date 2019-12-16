package persistent_Bugger;

class Persist {
	public static long persistence(long n) {
 // System.out.println("Number: " + n);
    int runs = 0;
    if (n < 10) return 0;
    int[] tester = new int[1];
		return(recursive(n, runs, tester));
	}
  
  public static int recursive (long number, int runs, int[] tester) {
    tester[0] = runs;
    long memory = number;
    int helper = 1;
    //System.out.println("Run: " + tester[0] + " n: " + number + " m: " + memory );
    while (number > 0) {
      //System.out.println("In while number: " + number);
      //System.out.println("Digit: " + number % 10);
      helper *= number % 10;
      number /= 10;
    }
    //System.out.println("Run: " + tester[0] + " m: " + memory + " h: " + helper);
    runs++;
    if (memory > 9) recursive(helper, runs, tester);
    //System.out.println("Run: " + runs + " n: " + tester[0]);
    return tester[0];
  }
}