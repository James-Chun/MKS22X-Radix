import java.util.*;

public class Radix {
  public static void main(String[]args){
    System.out.println("Size\t\tMax Value\tRadix/builtin ratio ");
    int[]MAX_LIST = {1000000000,500,10};
    for(int MAX : MAX_LIST){
      for(int size = 31250; size < 2000001; size*=2){
        long qtime=0;
        long btime=0;
        for(int trial = 0 ; trial <=5; trial++){
          int []data1 = new int[size];
          int []data2 = new int[size];
          for(int i = 0; i < data1.length; i++){
            data1[i] = (int)(Math.random()*MAX);
            data2[i] = data1[i];
          }
          long t1,t2;
          t1 = System.currentTimeMillis();
          Radix.radixsort(data2);
          t2 = System.currentTimeMillis();
          qtime += t2 - t1;
          t1 = System.currentTimeMillis();
          Arrays.sort(data1);
          t2 = System.currentTimeMillis();
          btime+= t2 - t1;
          if(!Arrays.equals(data1,data2)){
            System.out.println("FAIL TO SORT!");
            System.exit(0);
          }
        }
        System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
      }
      System.out.println();
    }
  }
  @SuppressWarnings("unchecked")
  public static void radixsort(int[]data){
    LinkedList<Integer>[] buckets = new LinkedList[19];
    LinkedList storage = new LinkedList();
    int index = 0;
    int placeValue = 1; // 1 reps the ones digit, 10 reps the tens digit and so on
    int maxDigit = getMaxDigit(data);
    for (int i = 0; i < buckets.length; i++) {
      LinkedList nums = new LinkedList();
      buckets[i] = nums;
    }
    for (int i = 0; i < maxDigit; i++) {
      if (placeValue == 1) {
        for (int x = 0; x < data.length; x++) {
          int num = data[x];
          int digit = (num / placeValue) % 10;
          buckets[digit + 9].add(num);
        }
      } else {
        for (int y = 0; y < storage.size(); y++) {
          int num = (int) storage.removeFront();
          //System.out.println(num);
          int digit = (num / placeValue) % 10;
          //System.out.println(digit);
          buckets[digit + 9].add(num);
          //System.out.println(buckets[digit + 9]);
          //System.out.println(storage);
        }
      }
      //storage = new LinkedList();
      // int ans = 0;
      // System.out.println("______________");
      // for (int p = 0; p < buckets.length; p++) {
      //   ans += buckets[p].size();
      //   System.out.println(buckets[p]);
      // }
      // System.out.println("ans: " + ans);
      storage = new LinkedList();
      // link all the linked lists together have to take into account nulls due to my implementation of linked list
      while (index < buckets.length) {
        //System.out.println(buckets[index].size() != 0);
        if (buckets[index].size() != 0) {
          storage.extend(buckets[index]);
        }
        index++;
      }
      // System.out.println("______________!");
      // for (int p = 0; p < buckets.length; p++) {
      //   System.out.println(buckets[p]);
      // }
      placeValue *= 10;
      index = 0;
      // testing
      //System.out.println("ans: " + ans);
      for (int j = 0; j < buckets.length; j++) {
        buckets[j].clear();
      }
      //System.out.println(placeValue);
      // System.out.println("storage");
      // System.out.println(storage.size());
    }
    for (int i = 0; i < data.length; i++) {
      //System.out.println(i);
      data[i] = (int) storage.removeFront();
    }
    // System.out.println("data");
    // System.out.println(Arrays.toString(data));
  }

  public static int getMaxDigit(int[] data) {
    int max = 0;
    for (int num : data) {
      int count = 1;
      int temp = num;
      while (temp / 10 != 0) {
        count++;
        temp = temp / 10;
      }
      if (count > max) {
        max = count;
      }
    }
    return max;
  }
}
