package dynamicpg;

import java.util.ArrayList;

public class StringCombinations {
    static ArrayList<String> permList = new ArrayList<>();

    public static void main(String[] args) {

        String text = "abc";
        permute(text,0 , text.length()-1);

        // bbbae
        String fulltext = "ccccbaaaa";

    //"abc"
        //"ccccbbbbaaaa"
        for (String stext:permList) {

            if(searchSubString(fulltext, stext) == true){
                System.out.println("matched!!");
            }
        }
    }

    static boolean searchSubString(String fulltext, String text) {
        int m = fulltext.length();
        int n = text.length();

        for (int i = 0; i <= m - n; i++) //slider
        {int j =0;
            for ( ; j < n; j++) {
                if (fulltext.charAt(i+j) != text.charAt(j)) { //both +j increases
                    break;
                }
            }

            if (j == n)
                return true;
        }

        return false;
    }


    static void permute(String str, int startIndex, int endIndex)
    {

        if(startIndex == endIndex) {
            System.out.println(str);
            permList.add(str);
        }
        else{

            for (int i = startIndex; i <= endIndex; i++) {
                //choose
                str = swap(str, startIndex, i);

                //explore it
                permute(str, startIndex +1, endIndex);

                //unchoose
                str = swap(str, startIndex, i);
            }

        }
    }

    static public String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }

}
