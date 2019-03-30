public class Node <E> {
 private E data;
 private Node next,prev;

 public Node (Integer info, Node nex, Node pre){
   data = info;
   next = nex;
   prev = pre;
 }

 public Node (Integer info) {
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
