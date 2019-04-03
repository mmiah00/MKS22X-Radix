public class Radix {

  @SuppressWarnings("unchecked")
  public static void radixsort(int[]data){
    int i = 0;
    int passes = biggest (data);
    //set up buckets
    MyLinkedList<Integer>[] buckets = new MyLinkedList [20];
    for (int x = 0; x < buckets.length; x++) {
      buckets[x] = new MyLinkedList();
    }

    MyLinkedList<Integer> ans = new MyLinkedList ();

    while (i < passes) {
      int place = (int) Math.pow (10,i);
      //put numbers in buckets
      if (i == 0) {
        for (int x = 0; x < data.length; x ++) {
          if (data[x] > 0) {
            int digit = data[x] / place % 10;
            buckets[digit + 10].add (data[x]);
          }
          else {
            int digit = (Math.abs (data[x])) / place % 10;
            buckets[9-digit].add (data[x]);
          }
        }
      }
      else {
        for (int x = 0; x < data.length; x ++) {
          int rn = ans.removeFront ();
          if (rn > 0) {
            int digit = rn/place% 10;
            buckets[digit + 10].add (rn);
          }
          else {
            int digit = (Math.abs (rn)) / place % 10;
            buckets[9 - digit].add (rn);
          }
        }
      }

      //merge to a linked list
      for (int x = 0; x < buckets.length; x ++) {
        ans.extend (buckets[x]);
      }
      i ++;
    }

    //after finished with passes, put back into the data
    int t = 0;
    while (t < data.length) {
      data[t] = ans.removeFront ();
      t ++;
    }
  }


  /*
  @SuppressWarnings("unchecked")
  private static MyLinkedList <Integer> convert (int[] data) {
    MyLinkedList<Integer> ans = new MyLinkedList ();
    for (int i = 0; i < data.length; i ++) {
      ans.add (data[i]);
    }
    return ans;
  }
  */

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
    System.out.println ("Ones Digit of 1239012 = " + (1239012/1%10));
  }
}
