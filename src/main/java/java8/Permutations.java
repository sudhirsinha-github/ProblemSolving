package java8;

public class Permutations {
    public static void main(String[] args) {

        String given = "axc" ;
        int length = given.length() -1;

        permute(given, 0, length);
    }

    private static void permute(String str, int startIndex,int endIndex) {
        if (startIndex == endIndex)
            System.out.println(str);
        else {
            for (int i = startIndex; i <= endIndex; i++) {
                str = swap(str, startIndex, i);
                permute(str, startIndex + 1, endIndex);
                str = swap(str, startIndex, i);
            }
        }
    }

    private static String swap(String str, int startIndex,int endIndex){
        char[] temp = str.toCharArray();
        char temp1 = temp[startIndex];
        temp[startIndex] = temp[endIndex];
        temp[endIndex] = temp1;

        return String.valueOf(temp);
    }
}
