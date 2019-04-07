import java.util.*;

public class Radix {

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
  LinkedList storage = new LinkedList();
      LinkedList<Integer>[] bucket = new LinkedList[19];
      int digitIndex = 1;
      int place = 0;
      int maxDigit = findDigitMax(data);
      //--------------------------------------------
      for (int m = 0; m < bucket.length; m++) {
          LinkedList nums = new LinkedList();
          bucket[m] = nums;
      }

      //--------------------------------------------

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
        //--------------------------------------------
        storage = new LinkedList();

        while (place < bucket.length) {
            if (bucket[place].size() != 0) {
              storage.extend(bucket[place]);
            }
            place++;
        }
        //--------------------------------------------
        digitIndex *= 10;

        place = 0;
        for (int j = 0; j < bucket.length; j++) {
            bucket[j].clear();
        }

      }
      //--------------------------------------------
      for (int i = 0; i < data.length; i++) {
          data[i] = (int) storage.removeFront();
      }
  }


}
