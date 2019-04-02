public class Radix {

  @SuppressWarnings("unchecked")
  public static void radixsort(int[]data){
    int i = 0;
    int passes = biggest (data);
    MyLinkedList<Integer>[] buckets = new MyLinkedList [20];
    //MyLinkedList<Integer> temp = convert (data);
    while (i < passes) {
      //digit is the number % 10 ^ i
      for (int x = 0; x < data.length; x ++) {
        if (data[x] >= 0) {
          int digit = (int) (data[x] / (Math.pow (10,i)));
        }
        else {
        }
      }
      i ++;
    }
  }

  @SuppressWarnings("unchecked")
  private static MyLinkedList <Integer> convert (int[] data) {
    MyLinkedList<Integer> ans = new MyLinkedList ();
    for (int i = 0; i < data.length; i ++) {
      ans.add (data[i]);
    }
    return ans;
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
    /*
    System.out.println (biggest (new int [] {1,2,4,6,31,5,2}));
    System.out.println (biggest (new int [] {100}));
    System.out.println (biggest (new int [] {1000000,1,4,2}));
    System.out.println (biggest (new int [] {-1111,2,4,23,100,41,1111}));
    */
    System.out.println ("Hundreds Digit of 1239012 = " + (1239012/100%10));
  }
}
