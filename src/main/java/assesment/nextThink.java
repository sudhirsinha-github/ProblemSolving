package assesment;

import com.sun.tools.javac.util.List;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.stream.Collectors;

public class nextThink {
    public static int solution(int N) {

        // convert number to string

        String data = Integer.toString(N);
        int numberToDelete = 5;
        // if number is positive delete from front
        String result = "0";
        if (N > 0) {
            result = frontDelete(data, numberToDelete);
        }
// if number is -ve delete from last occurence
        else {
            result = rearDelete(data, numberToDelete);
        }

// convert string to number
        int x = Integer.parseInt(result);
        System.out.print(x);
        return x;
    }

    static String frontDelete(String data, int numberToDelete) {
        try {
            int index = data.indexOf( Integer.toString(numberToDelete));
            String first = data.substring(0, index);
            String next = data.substring(index+1, data.length());
            return first + next;
        } catch (Exception e) {
            return "0";
        }

    }

    static String rearDelete(String data, int numberToDelete) {
        try {
            int index = data.lastIndexOf( Integer.toString(numberToDelete));

            String first = data.substring(0, index);
            String next = data.substring(index+1, data.length());
            return first + next;
        } catch (Exception e) {
            return "0";
        }
    }

    public static void main(String[] args) {
        solution(15958);
        solution(-5859);
//        BigDecimal bigDecimal = 1.002;
//        List<BigDecimal> integers = (List<BigDecimal>) Arrays.asList(1D);
//        Integer sum = integers.stream()
//                .reduce(0, BigDecimal::sum);
    }
}

