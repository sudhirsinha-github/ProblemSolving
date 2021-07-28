package assesment;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class VM {

    public static void main(String[] args) {
        // Scanner in = new Scanner(System.in);
        // int a;
        // a = in.nextInt();
        // int b;
        // b = in.nextInt();
        // int sum;

        // sum = addNumbers(a, b);
        specialStringReversal("this$ h*as value+");

        // System.out.println(getNextNumber(200999));

    }

    // return immeadiate next number
    // 1 -> 3
// 2 -> 3
// 3 -> 5
    static int getNextNumber(int a) {
        int digit_three = 3;
        int digit_five = 5;

        // int calculateNumber = 0;
        int max = Integer.MAX_VALUE;
        for (int i = a + 1; i < max; i++) {
            // calculateNumber = i +1 ;  //a ==1

            // check if digit contains 3 or 5
            if (checkDigitThreeOrFive(i)) {
                return i;
            }
        }

        return 3;
    }

    static boolean checkDigitThreeOrFive(int number) {
        // 3,4 ,5, 10,13, 15 30 /??
        //

        //  if(number % 3 == 0 || number % 5 == 0)
        //     {
        //         return true;
        //     }

        // 13%10
        // 30/10
        // String data = Integer.toString(number);

        // if(data.contains("3") || data.contains("5"))
        //     {
        //         return true;
        //     }
        //     else
        //     {
        //         return false;
        //     }
        int unitDigit = number % 10;
        int tenDigit = number / 10;
        int hundredDigit = number / 100;

        // 2,99,999
        if (unitDigit == 3 || unitDigit == 5 || tenDigit == 3 || tenDigit == 5 || hundredDigit == 3 || hundredDigit == 5) {
            return true;
        } else {
            return false;
        }
    }

    //
    // Input -> this$ h*as value+
// Output -> eula$v *sah isht+
// [this$ h*as value+]
    // i              j
// [eula$v *sah isht+]

    static void specialStringReversal(String data) {
        char[] value = data.toCharArray();
        int i = 0;
        int j = value.length - 1;

        while (i < j) {
            // check if not alpha c[i]
            if (checkIfNotAlphabet(value[i])) {
                i++;
            }

            // check if not alpha c[j]
            if (checkIfNotAlphabet(value[j])) {
                j--;
            } else
            // swap c[i], c[j]
            {
                // SWAP AS METHOD
                char temp = value[i];
                value[i] = value[j];
                value[j] = temp;
                i++;
                j--;
            }
        }

        System.out.print(value);
    }

    static boolean checkIfNotAlphabet(char ch) {
        if (ch == '*' || ch == '$' || ch == '+') {
            return true;
        }
        return false;
        //return !Character.isAlphabetic(ch);
    }
}
