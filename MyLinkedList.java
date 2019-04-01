import java.util.*;
import java.io.*;

public class MyLinkedList<E> {
  class Node {
   private E data;
   private Node next,prev;

   public Node (E info, Node nex, Node pre){
     data = info;
     next = nex;
     prev = pre;
   }

   public Node (E info) {
     data = info;
   }

   public Node () {
     data = null;
     next = null;
     prev = null;
   }

   public E getData () {
     return data;
   }

   public Node next () {
     return next;
   }

   public Node prev () {
     return prev;
   }

   public void setNext (Node other) {
     next = other;
   }

   public void setPrev (Node other) {
     prev = other;
   }

   public E setData (E num) {
     E old = data;
     data = num;
     return old;
   }

   public String toString () {
     if (data == null) {
       return "";
     }
     return data + " ";
   }
  }
  private int size;
  private Node start,end;

  public MyLinkedList () {
    size = 0;
    start = new Node ();
    end = new Node ();
  }

  public String toString(){
    String ans = "[ ";
    Node rn = start;
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
    Node a = new Node (adding);
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
