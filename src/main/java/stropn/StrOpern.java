package stropn;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;


public class StrOpern {
    static boolean isAnagram(String a, String b) {
        // if both have different lenth return false
        if(a.length() != b.length()) return false;

        String firstOne = a.toUpperCase();
        String second = b.toUpperCase();
        Map<Character, Integer> hmap1 = new HashMap<>();
        Map<Character, Integer> hmap2 = new HashMap();

        for(int i=0; i<firstOne.length();i++)
        {
            char ch = firstOne.charAt(i);
            if(!hmap1.containsKey(ch)){
                hmap1.put(ch, 1); // If key not exist insert new with 1
            }
            else{
                hmap1.put(ch, hmap1.get(ch) +1 ); // if it's already there get existing val + 1
            }
        }


        for(int i=0; i<second.length();i++)
        {
            char ch = second.charAt(i);
            if(!hmap2.containsKey(ch)){
                hmap2.put(ch, 1); // If key not exist insert new with 1
            }
            else{
                hmap2.put(ch, hmap2.get(ch) +1 ); // if it's already there get existing val + 1
            }
        }

         System.out.println(hmap1.entrySet());
         System.out.println(hmap2.entrySet());
        //hmap1.entrySet().forEach(System.out::println);

        return mapsAreEqual(hmap1, hmap2);
    }

    static boolean mapsAreEqual(Map<Character, Integer> mapA, Map<Character, Integer> mapB) {

        try{
            for (Character k : mapB.keySet())
            {
                if (!mapA.get(k).equals(mapB.get(k))) {
                    return false;
                }
            }
            for (Character y : mapA.keySet())
            {
                if (!mapB.containsKey(y)) {
                    return false;
                }
            }
        } catch (NullPointerException np) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String a = scan.next();
        String b = scan.next();
        scan.close();
        boolean ret = isAnagram(a, b);
        System.out.println( (ret) ? "Anagrams" : "Not Anagrams" );
    }
}
