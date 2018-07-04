package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class FindDuplicate
{
    void printRepeating(int arr[], int size)
    {
        System.out.println("The repeating elements are : ");
        for (int i = 0; i < size ; i++) {
            if(arr[Math.abs(arr[i])] >= 0)
            {
             arr[Math.abs(arr[i])] = -arr[Math.abs(arr[i])];
            }
            else {
                // value is repeated ...
                System.out.println((arr[Math.abs(arr[i])]));
            }
        }
    } 
 
    // Driver program 
    public static void main(String[] args) 
    {
        FindDuplicate duplicate = new FindDuplicate();
        int arr[] = {1, 2, 3, 1, 3, 6, 6};
        int arr_size = arr.length;
 
        //duplicate.printRepeating(arr, arr_size);
       // checkDuplicates(arr,arr_size);

        duplicacy(arr);
    }

    private static void duplicacy(int[] arr) {
        int[] input = arr;
        Arrays.sort(input);
        for(int i = 0, j = 1; j < input.length ; j++, i++){
            if( input[i] == input[j]){
                System.out.println(input[i]);


                while(j < input.length && input[i] == input[j]) j++;
                i = j - 1;
            }
        }
    }

    private static void checkDuplicates(int[] arr, int arr_size) {
        Set<Integer> bucket = new HashSet<>();

        for (int i = 0; i < arr_size; i++) {
            int e = arr[i];
            if(! bucket.add(e))
            System.out.println(e);
        }
    }
}
 