package recursionNBacktracking;

public class ReverseLines {

    public static void main(String[] args) {
        String[] lines = {"rose are black","blue is sky", "who are you?"};
        //reverseLines(lines);

        String string = "ho ho MANnnnn wasssuuuppppp!!! ";
        reverseAString(string);
    }


    private static void reverseLines(String[] lines)
    {
        int i =0;
        if(lines[i] != null){
            reverseLines(lines);
            i++;
            System.out.println(lines[i]);
        }
        else {

        }

    }


    private static void reverseAString(String str) {
        if ((str == null) || (str.length() <= 1))
            System.out.println(str);
        else {
            System.out.print(str.charAt(str.length() - 1));
            reverseAString(str.substring(0, str.length() - 1));
        }
    }
}
