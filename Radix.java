public class Radix {
  public static void radixsort(int[]data){
    int passes = biggest (data);
    while (passes >= 0) {
    }
  }

  private static int biggest (int[] data) { //look through list to find how many digits in the number with greatest magnitude
    int m = data[0];
    for (int i = 1; i < data.length; i ++) {
      if (Math.abs (data[i]) > Math.abs (m)) {
        m = data[i];
      }
    }
    return (int) (Math.log10 (Math.abs (m)) + 1);
  }

  public static void main (String[] args) {
    System.out.println (biggest (new int [] {1,2,4,6,31,5,2}));
    System.out.println (biggest (new int [] {100}));
    System.out.println (biggest (new int [] {1000000,1,4,2}));
    System.out.println (biggest (new int [] {-1111,2,4,23,100,41,1111}));
  }
}
