public class Node <E> {
 private E data;
 private Node<E> next,prev;

 public Node (E info, Node<E> nex, Node<E> pre){
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

 public Node<E> next () {
   return next;
 }

 public Node<E> prev () {
   return prev;
 }

 public void setNext (Node<E> other) {
   next = other;
 }

 public void setPrev (Node<E> other) {
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
