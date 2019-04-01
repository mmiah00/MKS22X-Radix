import java.util.*;
import java.io.*;

public class MyLinkedList<E> {
  private int size;
  private Node<E> start,end;

  public MyLinkedList () {
    size = 0;
    start = new Node<> ();
    end = new Node<> ();
  }

  public String toString(){
    String ans = "[ ";
    Node <E> rn = start;
    while (rn != null) {
      ans += rn.toString ();
      rn = rn.next ();
    }
    return ans + "]";
  }

  public void clear() {
    size = 0;
    //start = new Node ();
    //end = new Node ();
  }

  public boolean add(E adding) {
    Node<E> a = new Node<E> (adding);
    end = a;
    size ++; 
    return true;
  }

  public int size () {
    return size;
  }

  public void extend(MyLinkedList<E> other) {
    this.add (other.start.getData());
    end = other.end;
    size += other.size ();
    other.clear ();
  }

  public E removeFront() {
    E front = start.getData ();
    start = start.next ();
    size --;
    return front;
  }

  public static void main (String[] args) {
    MyLinkedList<Integer> test = new MyLinkedList <Integer> ();
    for (int x = 0; x < 10; x ++) {
      test.add (x);
    }
    System.out.println ("Size (should be 10): " + test.size ());
    System.out.println ("List: "+ test.toString ());
  }

}
