package soundex;

public class Soundex
{
    public static String getGode(String s)
    {
        char[] x = s.toUpperCase().toCharArray();
         
         
        char firstLetter = x[0];
 
        //RULE [ 2 ]
        //Convert letters to numeric code
        for (int i = 0; i < x.length; i++) {
            switch (x[i]) {
            case 'B':
            case 'F':
            case 'P':
            case 'V': {
                x[i] = '1';
                break;
            }
 
            case 'C':
            case 'G':
            case 'J':
            case 'K':
            case 'Q':
            case 'S':
            case 'X':
            case 'Z': {
                x[i] = '2';
                break;
            }
 
            case 'D':
            case 'T': {
                x[i] = '3';
                break;
            }
 
            case 'L': {
                x[i] = '4';
                break;
            }
 
            case 'M':
            case 'N': {
                x[i] = '5';
                break;
            }
 
            case 'R': {
                x[i] = '6';
                break;
            }
 
            default: {
                x[i] = '0';
                break;
            }
            }
        }
 
        //Remove duplicates
        //RULE [ 1 ]
        String output = "" + firstLetter;
         
        //RULE [ 3 ]
        for (int i = 1; i < x.length; i++)
            if (x[i] != x[i - 1] && x[i] != '0')
                output += x[i];
 
        //RULE [ 4 ]
        //Pad with 0's or truncate
        output = output + "0000";
        return output.substring(0, 4);
    }

    public static void main(String[] args)
    {
        String firstName = "cavid";
        String selectedName = "kaved";

        System.out.println(Soundex.getGode(firstName));
        System.out.println(Soundex.getGode(selectedName));

        if(firstName.equals(selectedName)) {
            System.out.println("same name");
            return;
        }

        Character firstChar = firstName.toCharArray()[0];
        Character secondChar = selectedName.toCharArray()[0];
        String firstValue = Soundex.getGode(firstName).trim().replaceFirst("[c-kC-K]", "");
        String secondValue = Soundex.getGode(selectedName).trim().replaceFirst("[c-kC-K]", "");

        if(firstValue.equals(secondValue)) {
            if (firstChar == 'c' && secondChar == 'k' || firstChar == 'K' && secondChar == 'c') {
                System.out.println("Matched-  special case with names starting with C & K as person with slightly different names");
                return;
            }
        }

        if(Soundex.getGode(firstName).equals(Soundex.getGode(selectedName))) {
            System.out.println("Matched-  same person with slightly different names");
            return;
        }
        else{
            System.out.println("Not matched - potentially different people");
            return;
        }
    }
}