package dynamicpg;

public class StringCombinations {
    public static void main(String[] args) {

        permute("abc",0 , 2);
    }


    static void permute(String str, int startIndex, int endIndex)
    {

        if(startIndex == endIndex)
        {
            System.out.println(str);
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
