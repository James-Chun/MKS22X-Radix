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




  public static int findDigitMax(int[] data) {    //finding the maximum number of digits
      int maxDigit = 0;
      for (int n : data) {
          int c = 1;
          int temp = n;
          while (temp / 10 != 0) {
              c++;
              temp = temp / 10;
          }
          if (c > maxDigit) {
              maxDigit = c;
          }
      }
      return maxDigit;
  }


  @SuppressWarnings("unchecked")
  public static void radixsort(int[]data){
      LinkedList<Integer>[] bucket = new LinkedList[19];
      LinkedList storage = new LinkedList();
      int place = 0;
      int digitIndex = 1;
      int maxDigit = findDigitMax(data);
      for (int m = 0; m < bucket.length; m++) {
          LinkedList nums = new LinkedList();
          bucket[m] = nums;
      }


      for (int m = 0; m < maxDigit; m++) {
        if (1 == digitIndex) {


          for (int m1 = 0; m1 < data.length; m1++) {
            int num = data[m1];
            int digit = (num / digitIndex) % 10;
            bucket[digit + 9].add(num);
          }


        }

        else {

          for (int m2 = 0; m2 < storage.size(); m2++) {
              int num = (int) storage.removeFront();
              int digit = (num / digitIndex) % 10;
              bucket[digit + 9].add(num);
          }

        }
        storage = new LinkedList();
        while (place < bucket.length) {
          if (bucket[place].size() != 0) {
            storage.extend(bucket[place]);
          }
          place++;
        }
        digitIndex *= 10;
        place = 0;
        for (int j = 0; j < bucket.length; j++) {
          bucket[j].clear();
        }
      }
      for (int i = 0; i < data.length; i++) {
        data[i] = (int) storage.removeFront();
      }
  }
}
