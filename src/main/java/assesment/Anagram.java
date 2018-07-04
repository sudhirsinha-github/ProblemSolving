package assesment;

import java.util.Scanner;

public class Anagram
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            String str = in.next();

            int n = str.length();
            Anagram anagram = new Anagram();
            anagram.generateAnagram(str, 0, n - 1);
        }
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