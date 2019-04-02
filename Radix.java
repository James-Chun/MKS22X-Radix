public class Radix{
    LinkedList buckets = new LinkedList();  //overall bucket
    LinkedList ones = new LinkedList();     //individual digits (will combine into bucket)
    LinkedList twos = new LinkedList();
    LinkedList threes = new LinkedList();
    LinkedList fours = new LinkedList();
    LinkedList fives = new LinkedList();
    LinkedList sixes = new LinkedList();
    LinkedList sevens = new LinkedList();
    LinkedList eights = new LinkedList();
    LinkedList nines = new LinkedList();

    public static void radixsort(int[]data){
      //need way to look at digits
      for (int i =0;i<data.length;i++){ //loop through data and add values to corresponding sub_bucket depending on digits

      }
    }
}
