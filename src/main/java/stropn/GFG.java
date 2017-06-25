package stropn;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sudhirkumar on 5/7/17.
 */
class GFG
{
    static String encode(String str)
    {
        //Your code here

        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for(int i=0; i< str.length(); i++){
            char c = str.charAt(i);
            if(!map.containsKey(c))
            {
                map.put(c, 1);
            }
            else{
                map.put(c, map.get(c) +1 );
            }

        }

        System.out.println(map.entrySet());
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> tt :map.entrySet()) {
//            System.out.printf(tt.getKey() +" " + tt.getValue());
            sb.append(tt.getKey() +" " +tt.getValue());
        }

      //  System.out.printf(sb.toString().replaceAll("\\s+","").trim());
        return  sb.toString().replaceAll("\\s+","").trim();
    }

    public static void main(String[] args) {
        //encode("testss");
        encode2("testwwt");

    }

    private static String encode2(String str) {
        StringBuilder builder = new StringBuilder(str.length());

        for (int i=0 ;i< str.length();i++) {

            int count =0;
            char got = str.charAt(i);

            for (char c: str.toCharArray()) {
                if(c == got)
                    count ++;


            }

            if(!builder.toString().contains(got+""))
            {builder.append(got + "" + count);}

        }

        return builder.toString();
    }
}