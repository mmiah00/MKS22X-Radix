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

}
