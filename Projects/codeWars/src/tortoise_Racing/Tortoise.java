package tortoise_Racing;

public class Tortoise {
  public static int[] race(int v1, int v2, int g) {
    if (v1 >= v2) return null;
System.out.println("V1: " + v1 + ", V2: " + v2 + ", g: " + g);    
    double t = (double) g / (v2 -v1);
System.out.println("T: " + t);
    double hd = Math.floor(t);
    double md = (t-hd) * 60;
    double sd = (md - Math.floor(md)) * 60;
    int h = (int) hd;
    int m = (int) (Math.floor(md * 1000) / 1000);
    int s = (int) (Math.round(sd * 1000) / 1000);
    if (s == 60) {
      s = 0;
      m++;
    }
System.out.println("Hd: " + hd + " Md: " + md + " Sd: " + sd);    
//    int h = (int)t;
//    int m = (int)((t - h) * 60);
//    int s = (int)((((t - h) * 60) - m ) * 60);
System.out.println("H: " + h + " M: " + m + " S: " + s);    
    return new int[] {h, m, s};  
    }
}