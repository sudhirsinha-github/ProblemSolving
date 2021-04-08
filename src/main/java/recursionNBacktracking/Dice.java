package recursionNBacktracking;

import java.util.ArrayList;

public class Dice {

    static int calls = 0;

    static int[] containsArr ={1,2,1,7,4};

    public static void main(String[] args) {
        ArrayList<Integer> choosen = new ArrayList<>();
        int value =5; // no of dices
        dicehelper(value, choosen, 26);
        System.out.println(calls);
    }

    private static void dicehelper(int value, ArrayList<Integer> choosen, int desiredSum) {

        calls ++;
        if(value == 0)
        {
           // if(sumOfAll(choosen) <= desiredSum) {

                System.out.println(choosen);
           // }
        }
        else {
            for (Integer i:containsArr) {

           // for (int i = 1; i < 27; i++) {

                //choose
                choosen.add(i);

                //explore
                dicehelper(value -1, choosen, desiredSum);

                //unchoose
                choosen.remove(choosen.size() -1);
            }
        }
    }

    private static Integer sumOfAll(ArrayList<Integer> arrayList, int item) {

        return arrayList.stream().mapToInt(a -> a).sum();
    }
}
