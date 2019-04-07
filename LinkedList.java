import java.util.*;

public class LinkedList<E> {

  private int l;
  private Node start,end;
  public LinkedList() {
    Node tempstart = new Node(null,null,null);
    start = tempstart;
    end = tempstart;
    l = 0;
  }

  public int size() {
    return l;
  }

  public void clear() {
    Node newStart = new Node(null,null,null);
    start = newStart;
    end = newStart;
    l = 0;
  }
  public String toString() {
    Node current = start;
    String ans = "";
    while (current != null){
      ans += current.getData();
      if (current.next() != null){
        ans += ", ";
      }
      if (current.next() != null){
        current = current.next();
      } else {
        return ans;
      }
    }
    return ans;
  }
  @SuppressWarnings("unchecked")
  public boolean add(E element) {
    if (l == 0){
      start.setData(element);
      l++;
      return true;
    }
    if (l == 1){
      Node toAdd = new Node(element,null,null);
      end = toAdd;
      start.setNext(end);
      end.setPrev(start);
      l++;
      return true;
    }
    Node addToEnd = new Node(element,null,null);
    end.setNext(addToEnd);
    addToEnd.setPrev(end);
    end = addToEnd;
    l++;
    return true;
  }
  @SuppressWarnings("unchecked")
  public void extend (LinkedList<E> other) {
    if(other.size() == 0){
      return;
    }
    if(size() == 0){
      this.start = other.start;
      this.end = other.end;
      this.l = other.l;
      other.clear();
    }else{
      Node startOfOtherList = other.start;
      end.setNext(startOfOtherList);
      startOfOtherList.setPrev(end);
      end = other.end;
      l += other.size();
      other.clear();
    }
  }
  public E removeFront() {
    Node next = start.next();
    E old = (E) start.getData();
    start.setNext(null);
    start = next;
    return old;
  }

//-----------------------------------------------------------------------------------------------------------------------------

  private class Node<E> {
    private E data;
    private Node next,prev;

    @SuppressWarnings("unchecked")
    public Node(E element, Node prevNode, Node nextNode){
      data = element;
      prev = prevNode;
      next = nextNode;
    }
    public Node next(){
      return next;
    }
    public Node prev(){
      return prev;
    }
    public void setNext(Node other){
      next = other;
    }
    public void setPrev(Node other){
      prev = other;
    }
    public E getData(){
      return data;
    }
    @SuppressWarnings("unchecked")
    public E setData(E value){
      E old = data;
      data = value;
      return old;
    }
    public String toString(){
      return data + "";
    }
  }

}
