class Node{
  private Integer data;
  private Node next,prev;

  public Node(Integer value, Node n, Node p){ //make node where you store data, directions to next and previous node
    data = value;
    next = n;
    prev = p;
  }

  public Node next(){ //returns the address to the next node;
    return next;
  }
  public Node prev(){ //returns address to previous node
    return prev;
  }

  public void setNext(Node other){ //sets the next node to other
    next = other;
  }
  public void setPrev(Node other){ //sets the previous node to other
    prev = other;
  }

  public Integer getData(){ //returns the data of the node
    return data;
  }
  public Integer setData(Integer i){ //sets the data of the node
      Integer temp = data;
      data = i;
      return temp;
  }

  public String toString(){ //string displaying the data
    return ""+data;
  }

}



class LinkedList{
  private int size;
  private Node start,end;

  public LinkedList(){ //simple constructor to make empty list of nodes
    size = 0;
    start=null;
    end=null;
  }

  private Node getNthNode(int n){ //private method to be used inside class to get specific node
    Node current = start;
    for (int i=0;i<n&&current!=null;i++){
      current=current.next();
    }
    return current;
  }

  public int size(){ //returns size of the list
    return size;
  }

  public void clear(){
    size =0;
    start = null;
    end = null;
  }

  public Integer get(int index){ //getNthNode but for public use
    if (index>size||index<0)throw new IndexOutOfBoundsException("Index is Out of Bounds");
    return getNthNode(index).getData();
  }

  public boolean add(Integer value){ //adds a new value to the list by makign a new node
    Node n = new Node(value,null,end); //node to add with next node being null and previous node being end
    if (size == 0){//if the list is empty, make the start = new node, the next and previous nodes will still be null so it works out
      start = n;
      end=start;
    }else{ // if list is not empty, then go on with original plan
      end.setNext(n);
      end=n;
    }
    size++;//increase size
    return true;
  }

  public Integer set(int index,Integer value){  //setting value at index to new value
    if (index>size||index<0)throw new IndexOutOfBoundsException("Index is Out of Bounds");
    Integer oldValue = getNthNode(index).getData();
    getNthNode(index).setData(value);
    return oldValue;
  }

  public boolean contains(Integer value){ //loop through list and check for value
    Node current = start;
    while(current!=null){
      if (current.getData()==value)return true;
      current = current.next();
    }
    return false;
  }

  public int indexOf(Integer value){ //simply loop through list and try and find value
    int place = 0;
    Node current = start;
    while(current!=null){
      if (current.getData()==value)return place;
      place ++;
      current = current.next();
    }
    return -1;
  }



  public Integer removeFront(){
    Node removed = getNthNode(1);
    Integer removedInt = removed.getData();
    start=removed.next();
    start.setPrev(null);
    size--;
    return removedInt;
  }

  public boolean remove(Integer value) {//a private method to find a node you want could be useful here
    for (int i=0;i<size;i++){
      Node toRemove = getNthNode(i);
      if (i==0&&toRemove.getData()==value){
        start = toRemove.next();
        start.setPrev(null);
        size--;
        return true;
      }
      if (toRemove.getData()==value){
        toRemove.setNext(toRemove.next());
        toRemove.setPrev(toRemove.prev());
        size--;
        return true;
      }
    }
    return false;
  }


  public String toString(){ //simple toString by looping through list and adding on to string
    String n = "[";
    Node current = start;
      while (current != null){ //check to see if current node is null, if so stop the loop
        n = n + current.getData();
        if (current.next()!=null){
          n=n+", ";
        }
        current = current.next();
      }
      return n+"]";
  }

  public void extend(LinkedList other){

    if (this!=null&&this.size==0){
      this.start = other.start;
      this.end = other.end;
      this.size = other.size;
      other.size=0;
      other.start=null;
      other.end=null;
      return;
   }
   if (other.size!=0){
  this.end.setNext(other.start);
  other.start.setPrev(this.end);
  this.end = other.end;
  other.start = null;
  other.end = null;
  this.size += other.size();
  other.size = 0;
  return;
}
 }


 public static void main(String[] args){

   //add(something) workds
   //clear() works
   //removeFront() works
   //extend works

    LinkedList test = new LinkedList();
    for (int i=0;i<10;i++){
      test.add(i);
    }
    //test.clear();
    //System.out.println(test.removeFront());
    LinkedList extension = new LinkedList();
    for (int i=10;i<20;i++){
      extension.add(i);
    }
    test.extend(extension);
    System.out.println(test);
    System.out.println(extension);
 }

}
