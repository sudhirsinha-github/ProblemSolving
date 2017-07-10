package prac;

import sun.jvm.hotspot.oops.Array;

import java.util.*;

/**
 * Created by sudhirkumar on 4/18/17.
 */
public class MajorItem {
   /* private static int count = 0;

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,5,3,3,2,2,2,2,2,2};
        int length = arr.length;
        boolean isFound = false;

        for (int i = 0; i < length; i++)
        {
            for (int j =1 ; j<length-1; j++){
                if(arr[i] == arr[j]){
                    count++;
                    if(count >= Math.abs(length/2))
                    {
                        isFound = true;
                        break;
                    }
                }

            }

            if (isFound == true){
                System.out.println("Gotta -->>>" + arr[i] + " ]]]] " + count);
                break;
            }

            count=0;
        }

        int evenCount =0;
        for (int i=0;i<length ;i++)
        {
            if(!isEven(arr[i])){
                evenCount ++;
            }
        }
        System.out.println(evenCount);

    }

    private static boolean isEven(int i) {
        return i%2 == 0;
    }*/

    public static void mainSubstr(String[] args) {
        String mainStringData = "HI how are your doing?";
        String subString = "you";

        char[] ch = mainStringData.toCharArray();
        char[] substr = subString.toCharArray();
        boolean found = false;

            for (int j = 0; j < ch.length; j++) {
                if (substr[0] == ch[j] && ch[j+substr.length]== 32) {
                    for (int i = 0; i < substr.length; i++) {
                     if(substr[i] == ch[i+j]){
                         System.out.println(ch[i+j]);
                     }
                     else {
                         System.out.println("Not found");
                     }
                    }
                }
            }
            //TODO
        /*String[] strings = mainStringData.split("\\s");
        System.out.printf(" -- " + Arrays.asList(strings).contains(subString));*/
    }


    public static void mainWordReverseInLine(String[] args) {

        String sentenceLine = "my name is sudhir !!**45678";
        String[] data = sentenceLine.split("\\s+");
        for (String d:data) {
            //reverse individual str
            System.out.print(reverseStringWord(d));
            System.out.print(" ");
        }
    }
    private static char[] reverseStringWord(String subWord) {
        char[] ch = subWord.toCharArray();
        char[] newCh = new char[ch.length];
        int j =0 ;

        for (int i = ch.length-1;i >=0 ;i--) {
            // System.out.print(ch[i]);
            newCh[j++] = ch[i];
        }

        //System.out.println(newCh);

        return newCh;
    }


    public static void mainSwapArr(String[] args) {
        int[] array = {1,2,3,4,5,6,7};

        for (int i = 0; i < 2; i++) {
         array = swapArray(array);
        }

        for (int i:array) {
            System.out.print(i);
        }

    }

    public static int[] swapArray(int[] arr)
    {
        int temp = arr[0];
        for (int i = 0; i < arr.length -1 ; i++) {
            arr[i] = arr[i+1];
        }

        arr[arr.length-1] = temp;
        return arr;
    }


    public static void mainP(String[] args) {
        int length = 4;
        int[] arr = new int[]{3, 4, 1, 0}; // 455-1

        ArrayList<Integer> al = new ArrayList<>();
        // Arrays.asList(arr).stream().filter(n -> n > arr)

        boolean flag = false;
        //int i =0;
        int j =0;
        for (int i = 0; i < arr.length -1; i++) {
            j = i + 1;
            while (j < arr.length) {
                if (arr[i] < arr[j]) {
                    flag = true;
                    al.add(arr[j]);
                    //arr[i++] = arr[j];
                    i++;
                    //System.out.println(arr[j]);
                    // break;
                } else {
                    flag = false;
                    j++;
                }
            }

            if (flag == false && j == arr.length - 1) {
                //arr[i] = -1;
                al.add(-1);
            }

        }


//al.add(arr.length -1, -1);
       // }

        // arr[arr.length -1] = -1;


        for (int a:al) {
            System.out.println(a);
        }

    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        set.add(12);
        set.add(12);


    }
}
