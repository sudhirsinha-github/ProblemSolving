package dynamicpg;

public class ConsecutiveMatch {
    public static void main(String[] args) {
        String s1 = "abcdeabcdef";
        String s2 = "abcfoooo";

        char[] ss1 = s1.toCharArray(); //j
        char[] ss2 = s2.toCharArray(); //i

        System.out.println(hasSubstring(ss1, ss2));
    }

    private static boolean hasSubstring(char[] text, char[] pattern){
        int i=0;
        int j=0;
        int k = 0;
        while(i < text.length && j < pattern.length){
            if(text[i] == pattern[j]){
                i++;
                j++;
            }else {
                i++;
            }
        }
        if(j == pattern.length){
            return true;
        }
        return false;
    }
}
