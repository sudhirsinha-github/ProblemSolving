package recursionNBacktracking;

public class StrReverse {
    private static String string = "MELAN";


    public static void main(String[] args) {
        System.out.println(reverse(string));

        System.out.println("$%%^*((**(()))");

        //System.out.println(isPelindrome("LEVEL"));

        // printBinaries(5009);


    }

    private static String reverse(String str){
        if ((str==null)||(str.length() <= 1) )
            return str;
        return reverse(str.substring(1)) + str.charAt(0);
    }


    private static boolean isPelindrome(String string)
    {
        //base
        if(string.length()<2) {
            return true;
        }
        //normal
        else{
            char first = string.charAt(0);
            char last = string.charAt(string.length() -1);
            if(first == last)
            {
                return isPelindrome(string.substring(1,string.length() -1));
            }
            else {
                return false;
            }
        }
    }


    private static void printBinaries(int number)
    {
        if(number ==0 || number ==1 )
            System.out.print(number);
        else {
            int lastDigi = number%2;
            int rest = number/2;
            printBinaries(rest);
            System.out.print(lastDigi);
        }
    }

   /* private static int hcf(int number1, int number2)
    {
        while(number1!=number2){
            if(number1 > number2){
                number1 = number1-number2;
            }else{
                number2 = number2-number1;
            }
        }

        if(number1 == number2)
           return number1;
    }*/
}
