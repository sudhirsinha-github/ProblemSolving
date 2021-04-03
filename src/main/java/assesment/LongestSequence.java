package assesment;

import java.util.ArrayList;

public class LongestSequence {
    public static void main(String[] args) {
        int[] a={1,1,0,1,1,1,1,0,1,1,1}; // by flipping any 1 to 0

        ArrayList<Integer> list = new ArrayList<>();

        // reduce the array value by summing
        int t = 0;
        for (int i = 0; i < a.length; i++) {
            if(a[i] == 1){
                t++;
                if(i == a.length -1)
                    list.add(t);
            }
            else {
                list.add(t);
                t =0;
                list.add(0);
            }
        }

        System.out.println(list);

        // flip any a 0
        int longestSeq = 0;
        int initialSeq = 0;
        for (Integer i: list) {
            if(i != 0) {
                initialSeq++;
            }
            else {
                if(initialSeq > longestSeq)
                    longestSeq = initialSeq;

                initialSeq = 0;

            }

        }

        System.out.println(longestSeq);


    }
}
