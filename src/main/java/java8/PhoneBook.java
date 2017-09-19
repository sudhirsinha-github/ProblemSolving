package java8;

import java.util.*;

/**
 * Created by sudhirkumar on 9/3/17.
 */
public class PhoneBook {
    public static void main(String []argh)
    {
        /*Scanner in = new Scanner(System.in);
        int n=in.nextInt();
        in.nextLine();
        HashMap<String, Integer> phoneList = new HashMap<>();

        for(int i=0;i<n;i++)
        {
            String name=in.nextLine();
            int phone=in.nextInt();
            phoneList.put(name, phone);
            in.nextLine();
        }

        while(in.hasNext())
        {
            String s=in.nextLine();
            if(phoneList.containsKey(s)){
                System.out.println(s +"=" +phoneList.get(s));
            }
            else
            {
                System.out.println("Not Found");
            }
        }*/

        List<String> tt = new ArrayList<>();
        tt.add("ttteee");
        tt.add("11ttteee");
        tt.add("222ttteee");


        String str = Arrays.toString(tt.toArray());
        System.out.println(str);

    }
}
