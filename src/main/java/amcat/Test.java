package amcat;

import java.util.HashSet;
import java.util.Set;

public class Test {
    int i = 1;

    public void set(int t)
    {
        i = t;
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalize called !!" + i);

        i++;
        //System.out.println(i);
    }


    public static void main(String[] args) throws Throwable {
        /*Test t1 = new Test();
        Test t2 = new Test();
        t1.i = t2.i;
        t2.i = t1.i;

        t1= null;
        t2= null;

        if(t1 instanceof Test){


        }

        List<?> tt = new ArrayList<>();
        Iterator te =  tt.iterator();
        te.hasNext();
        te.next();

        System.gc(); // WHY NOT GC CALLS FINALIZE -*/

        //Set<String> set = decode("", "112");
        System.out.println("");

        int []a ={1,1,2};
        print(a, 0, 3, "");

    }

    public static int print(int [] a, int i, int n, String s) {
        if(i == n)  {
            System.out.println(s);
            return 0;
        }

        int ans = 0;
        if(i < n-1 && a[i+1] <= 6 && a[i] <= 2) {
            ans += print(a, i+2, n, new String(s+(char)(a[i]*10+a[i+1]+'a'-1))) +1;
        }
        ans += print(a, i+1, n, new String(s+(char)(a[i]+'a'-1)));
        return ans;
    }

    public static Set<String> decode(String prefix, String code) {
        Set<String> set = new HashSet<String>();
        if (code.length() == 0) {
            set.add(prefix);
            return set;
        }

        if (code.charAt(0) == '0')
            return set;

        set.addAll(decode(prefix + (char) (code.charAt(0) - '1' + 'a'),
                code.substring(1)));
        if (code.length() >= 2 && code.charAt(0) == '1') {
            set.addAll(decode(
                    prefix + (char) (10 + code.charAt(1) - '1' + 'a'),
                    code.substring(2)));
        }
        if (code.length() >= 2 && code.charAt(0) == '2'
                && code.charAt(1) <= '6') {
            set.addAll(decode(
                    prefix + (char) (20 + code.charAt(1) - '1' + 'a'),
                    code.substring(2)));
        }
        return set;
    }
}

