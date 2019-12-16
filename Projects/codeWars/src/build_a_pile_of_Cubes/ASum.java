package build_a_pile_of_Cubes;

public class ASum {
	
	public static long findNb(long m) {
		// your code
    long h = 0L;
    long cubesNeeded;
System.out.println("Cubes to start with: " + m);
    //return(calc(m, height));
    while (m > 0) {
      cubesNeeded = (long) Math.pow(h + 1, 3);
//System.out.println("Needed: " + cubesNeeded + ", LeftOver: " + m);
      h++;
      m -= cubesNeeded;
      if (m < 0) {
        return -1;
      }
    }
    System.out.println("H: " + h);
    return h;
	}	
  
//  public static long calc(long c, long h) {
//    long n = 0;
//System.out.println("Cubes: " + c + ", Height: " + h);
//    long cubesNeeded = (h+1) * (h+1) * (h+1);
//System.out.println("Needed: " + cubesNeeded);
//    if (c == 0) {
//System.out.println("Found: " + h);
//      return h;
//    } else if (c < cubesNeeded) {
//System.out.println("Not possible!");
//      return -1;
//    }
//    if (c >= cubesNeeded) {
//      h++;
//      n = calc(c - cubesNeeded, h);
//    }
//    return n;
//  }
}