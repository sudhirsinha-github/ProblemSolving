package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;

class PairSum
{
    private static final int MAX = 100000; // Max size of Hashmap
 
    static void printpairs(int arr[],int sum)
    {
        // Declares and initializes the whole array as false
        boolean[] binmap = new boolean[MAX];

        for (int i=0; i<arr.length; ++i)
        {
            int temp = sum-arr[i];
            temp = Math.abs(temp);
            // checking for condition
            if (temp>=0 && binmap[temp])
            {
                System.out.println("Pair with given sum " +
                                    sum + " is (" + arr[i] +
                                    ", "+temp+")");
            }

            binmap[arr[i]] = true;
        }
    }
 
    // Main to test the above function
    public static void maino (String[] args)
    {
        int A[] = {1, 4, 45, 6, 10, 8};
//        int A[] = {1, 4, 45, 6, 10, 8};
        int n = 14;
        printpairs(A,  n);
    }

    public static void main(String[] args) {
        int a[] = {1, 10, 1, 4, 9, 10, 0, 8, 9,44,89,90};
        int distance = 2;

        boolean isFound = false;
        normalSearch(a, distance);

        //using Hashset
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < a.length; i++) {
            if (set.contains(a[i])) {
                System.out.println(a[i]+ "=SETTT=="+"i -- j" + i );

                isFound = true;
                break;
            }

            set.add(a[i]);
            if (i >= distance)
                set.remove(a[i - distance]);
        }

        System.out.println(findMaxRange(a));
        System.out.println("getSecondHighestNo" + getSecondHighestNo(a));
        arrReverse(a, 2);

    }

    private static void normalSearch(int[] a, int distance) {
        boolean isFound;
        for (int i = 0; i < a.length-1; i++) {
            for (int j = i+1,count=1; count < distance; count++,j++) {
                if(j > a.length -1)
                    break;

                if(a[i]== a[j]) {
                    System.out.println(a[i]+ "===" + a[j]+"i -- j" + i +"--- " + j);
                    isFound = true;
                    break;
                }
            }
        }
    }

    public static void main2(String[] args) {
        int[][]a = {{11,20},{30,40},{5,10}, {40,30}};

        // Creates an empty hashMap hM
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();

        // Traverse through the given array
        for (int i = 0; i < a.length; i++)
        {
            // First and second elements of current pair
            int first = a[i][0];
            int sec   = a[i][1];

            // Look for second element of this pair in hash
            Integer val = hM.get(sec);

            // If found and value in hash matches with first
            // element of this pair, we found symmetry
            if (val != null && val == first)
                System.out.println("(" + first + ", " + sec + ")");

            else  // Else put sec element of this pair in hash
                hM.put(first, sec);
        }
    }

    private static int findMaxRange(int []arr)
    {
        if(arr.length == 0)
            return 0;

        if(arr.length == 1)
            return 1;

        int start = 0;
        int end = 1;
        int max_length = 1;
        while (end < arr.length)
        {

            if(arr[end] > arr[end-1])
            {
                int len = end - start + 1;
                if(len >max_length)
                max_length = len ;
            }
            else {
                start = end;
            }

            end++;
        }

        return max_length;
    }

    private static int getSecondHighestNo(int a[])
    {
        //consider edhge case >>
        if(a.length < 1)
            return -1;

        int highest,secondhighest;
        highest=secondhighest= Integer.MIN_VALUE;

        for (int i =0; i< a.length; i++) {
            if (a[i] > highest) {
                secondhighest = highest;
                highest = a[i];
            } else if (a[i] > secondhighest) {
                secondhighest = a[i];
            }
        }

        return secondhighest;
    }

    private static void arrReverse(int []a, int d)
    {
        int n = a.length;
        reverseArr(a,0,d-1);
        reverseArr(a,d,n-1);
        reverseArr(a,0, n-1);

    }

    private static void reverseArr(int[] a, int i, int n) {

        int temp;
        while (i< n)
        {
            temp = a[i];
            a[i++] = a[n];
            a[n--] = temp;
        }
    }
}