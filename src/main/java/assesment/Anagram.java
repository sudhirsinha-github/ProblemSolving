package assesment;

import java.util.Scanner;

public class Anagram
{
    public static void main(String[] args)
    {
       /* Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            String str = in.next();

            int n = str.length();
            Anagram anagram = new Anagram();
            anagram.generateAnagram(str, 0, n - 1);
        }*/

       String a = "polo";
       String b = "loop";
        System.out.println(areAnagram(a.toCharArray(), b.toCharArray()));
    }
 
   
    private void generateAnagram(String str, int l, int r)
    {
        if (l == r)
            System.out.println(str);
        else
        {
            for (int i = l; i <= r; i++)
            {
                str = swap(str,l,i);
                generateAnagram(str, l+1, r);
                str = swap(str,l,i);
            }
        }
    }

    static boolean areAnagram(char[] str1, char[] str2)
    {
        // Create a count array and initialize all values as 0
        if(str1.length != str2.length)
            return false;

        int NO_OF_CHARS = str1.length;

        int[] count = new int[256];
        int i;

        // For each character in input strings, increment count in
        // the corresponding count array count['a' ascii make +1 for first and -1 for other , if all are same tab 0 hoga
        // and make sure to consider case sensetive cases -tolower()]
        for (i = 0; i < NO_OF_CHARS; i++) {
            count[str1[i]]++;
            count[str2[i]]--;
        }

        // If both strings are of different length. Removing this condition
        // will make the program fail for strings like "aaca" and "aca"
//        if (str1[i] || str2[i])
//            return false;

        // See if there is any non-zero value in count array
        for (i = 0; i < 256; i++) {
            if (count[i] != 0)
                return false;
        }
        return true;
    }

  
    public String swap(String a, int i, int j)
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i] ;
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
    }
 
}