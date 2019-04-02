import java.util.*;
import java.io.*;

public class MyLinkedList <E> {
  private int size;
  private Node start, end;

  public MyLinkedList() {
    size = 0;
    start= null;
    end = null;
  }

  public void clear() {
    size = 0;
    start.setNext(end);
    end.setPrev(start);
    start = null;
    end = null;
  }

  public int size() {
    return size;
  }

  public boolean add (E adding) {
    if (size() == 0) {
      Node a = new Node (adding, null, end);
      start = a;
      end = a;
    }
    else {
      Node a = new Node (adding, end, null);
      end.setNext(a); //the end changes
      end = a;
    }
    size++;
    return true;
  }

  public E removeFront() {
    E was = start.getData();
    if (size() == 1) {//reset
      start = null;
      end = null;
    }
    else {
      Node second = start.next();
      second.setPrev(null); //make it first
      start.setNext(null); //unlinking start from the list
      start = second; //second now now becomes first
    }
    size --;
    return was;
  }

  public void extend(MyLinkedList<E> other) {
    if (size () == 0) {
      Node rn = other.start;
      int i =0;
      while (i < other.size () && rn != null){
        add (rn.getData ());
        rn = rn.next ();
      }
      size = other.size();
      other.size = 0;
    }
    else {
      if (other.size != 0) {
        end.setNext (other.start);
        other.start.setPrev (end);
        end = other.end;
        size += other.size ();
        other.size = 0;
      }
    }
  }

  public String toString() {
    String ans = "[ ";
    Node rn = start;
    while (rn != null) {
      ans += rn.toString () + " ";
      rn = rn.next ();
    }
    return ans + "]";
  }
  class Node{
    private E data;
    private Node next, prev;

    public Node(E info) {
      data = info;
      prev = null;
      next = null;
    }
    public Node (E info, Node pre, Node nex) {
      data = info;
      prev = pre;
      next = nex;
    }

    public void setData(E info) {
      data = info;
    }

    public void setNext(Node other) {
      next = other;
    }

    public void setPrev(Node other) {
      prev = other;
    }

    public E getData() {
      return data;
    }

    public Node next() {
      return next;
    }

    public Node prev() {
      return prev;
    }

    public String toString() {
      if (data == null) {
        return "";
      }
      return data + "";
    }
  }

  public static void main (String[] args) {
    MyLinkedList<Integer> test = new MyLinkedList <Integer> ();
    for (int x = 0; x < 10; x ++) {
      test.add (x);
    }
    System.out.println ("Size (should be 10): " + test.size ());
    System.out.println ("List: "+ test.toString ());

    for (int i = 0; i < 3; i ++) {
      System.out.println (test.removeFront ());
    }

    System.out.println (test.toString ());
    System.out.println (test.size ());

    MyLinkedList<Integer> another = new MyLinkedList <Integer> ();
    another.extend (test);
    System.out.println ("Added test to an empty list:" + another.toString ());
    System.out.println (another.size ());
    System.out.println (test.size ());
    for (int x = 0; x< 10; x ++) {
      another.add (x*x);
    }
    System.out.println (another.toString ());

    test.extend (another);
    System.out.println (test.toString ());
    System.out.println (another.size ());
    System.out.println (test.size ());
  }

}
