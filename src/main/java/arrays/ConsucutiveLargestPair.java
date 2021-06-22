package arrays;

import java.util.HashMap;

public class ConsucutiveLargestPair
{
    public static void main(String[] args) {
        int[] a ={4,1,2,0,7,0,1,5};
        smallestSubWithSum();
        Object o1 = 999;
        Object o2 = 999;
        System.out.println(o1.equals(o2));
    }

    private static void arrayWay(int[] a) {
        int[] temp = new int[]{-1,-1,-1};

        for (int i = 0; i < a.length; i++) {
            if(a[i]>temp[0]){
                temp[2] = temp[1];
                temp[1] = temp[0];
                temp[0] = a[i];
            }
            else if(a[i] > temp[1]){
                temp[2] = temp[1];
                temp[1] = a[i];
            }
            else if(a[i]> temp[2])
            {
                temp[2]= a[i];
            }
        }
    }

    private static void mm(int[] a) {
        int firstLargest = a[0];
        int secondLargest = -1;

        for (int i = 1; i < a.length; i++) {
            if(a[i]> firstLargest){
                secondLargest = firstLargest;
                firstLargest = a[i];
            }
            else if (a[i] > secondLargest){
                secondLargest = a[i];
            }
        }
        System.out.println("****" + firstLargest +" --- " + secondLargest);
    }

    private static void findSubArray(){
        int[] a1 ={4,1,2,0,7,0,1,5};
        int[] a2 = { 7,2};
        HashMap<Integer, Integer> hashMap1 = new HashMap<>();
        HashMap<Integer, Integer> hashMap2 = new HashMap<>();

        for (int i = 0; i <a1.length; i++) {
            Integer integer = hashMap1.get(a1[i]) != null ? hashMap1.get(a1[i]):0;
            hashMap1.put(a1[i], integer + 1);
        }


        for (int i = 0; i <a2.length; i++) {
            Integer integer = hashMap2.get(a2[i]) != null ? hashMap2.get(a2[i]):0;

            hashMap2.put(a2[i], integer + 1);
        }


        hashMap1.entrySet().containsAll(hashMap2.entrySet());

     }

     private static void shuffleMinMax(){
        int[] a = new int[]{1,2,3,4,5,6,7,8};
        int min = a[0];
        int max = a[a.length-1];

         for (int i = 0; i < a.length; i++) {
             if(i%2 == 0){
                 a[i]=max;
                 max = max -1;
             }
             else {
                 a[i] = min;
                 min= min+1;
             }
         }


         System.out.println(a);
     }

     private static void lowAvg(){
        int a[] = new int[]{3,7,90,20,10,50,40,1,0};
        int k =3;
        int curr_avg = 0;
        int low_avg = Integer.MAX_VALUE;
        int startIndex = 0;

         for (int i = 0; i < a.length -2; i=i+3) {
             curr_avg = (a[i] + a[i+1] + a[i+2])/3;

             if(low_avg> curr_avg){
                 low_avg = curr_avg;
                 startIndex = i;
             }
         }

         System.out.println(low_avg +"---" + startIndex);
     }

     private static void smallestSubWithSum() {
         int arr1[] = {1, 10, 5, 2, 7};
         int x = 9;
         int n1 = arr1.length;
         // int res1 = smallestSubWithSum(arr1, n1, x);
         int startIndex = 0;
         int currSum = 0;
         int minLength = 100;
         int i = 0;
         for (i = 0; i < n1; i++) {
             currSum += arr1[i];

             if (currSum >= x && minLength > (i - startIndex)) {
                 minLength = i - startIndex;
                 currSum = currSum - arr1[startIndex];
                 startIndex++;
             }

         }
         System.out.println(startIndex + "-- " + minLength);
     }
}
