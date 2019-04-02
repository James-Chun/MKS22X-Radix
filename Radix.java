public class Radix{
    private static LinkedList buckets = new LinkedList();  //overall bucket
    private static LinkedList zeroes = new LinkedList();
    private static LinkedList ones = new LinkedList();     //individual digits (will combine into bucket)
    private static LinkedList twos = new LinkedList();
    private static LinkedList threes = new LinkedList();
    private static LinkedList fours = new LinkedList();
    private static LinkedList fives = new LinkedList();
    private static LinkedList sixes = new LinkedList();
    private static LinkedList sevens = new LinkedList();
    private static LinkedList eights = new LinkedList();
    private static LinkedList nines = new LinkedList();

    public static void radixsort(int[]data){
      //need way to look at digits (possible way is to have variable keeping track of exponent for 10)
      for (int i =0;i<data.length;i++){ //loop through data and add values to corresponding sub_bucket depending on digits

        if (data[i]==0){
          zeroes.add(data[i]);
        }
        if (data[i]==1){
          ones.add(data[i]);
        }
        if (data[i]==2){
          ones.add(data[i]);
        }
        if (data[i]==3){
          ones.add(data[i]);
        }
        if (data[i]==4){
          ones.add(data[i]);
        }
        if (data[i]==5){
          ones.add(data[i]);
        }
        if (data[i]==6){
          ones.add(data[i]);
        }
        if (data[i]==7){
          ones.add(data[i]);
        }
        if (data[i]==8){
          ones.add(data[i]);
        }
        if (data[i]==9){
          ones.add(data[i]);
        }
      }//for end

      buckets.extend(zeroes);
      buckets.extend(ones);
      buckets.extend(twos);
      buckets.extend(threes);
      buckets.extend(fours);
      buckets.extend(fives);
      buckets.extend(sixes);
      buckets.extend(sevens);
      buckets.extend(eights);
      buckets.extend(nines);

      for (int i=0;i<data.length;i++){
        data[i]=buckets.removeFront();
      }
    }


    public static String visual(int[] data){
      String visual = "[";
        for (int i=0;i<data.length;i++){
          visual += data[i];
          if (i<data.length-1){
            visual += ", ";
          }
        }
        return visual+"]";
    }

    public static void main(String[] args){
      int[] test = {1,5,2,3,6,4,0,8,1,9,7};
      radixsort(test);
      System.out.println(visual(test));
    }

}
