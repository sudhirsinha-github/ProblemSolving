package stack;

import java.util.Date;
import java.util.Stack;

/**
 * Created by sudhirkumar on 5/22/17.
 */
public class ExpressionValidator {
    /*
    1. if experession have '[{(' then push to stack
    2. if expr have ]}) then pop from stack and pop char is matched to equivalent brackets
    3. @last if stack is null - > Balanced else not if any char are avlbl
     */
    final private static Stack<Character> stack = new Stack();

    public static char pushToStack(char character)
    {
        return stack.push(character);
    }

    public static char popFromStack()
    {
        return stack.pop();
    }

    static boolean isMatchingBracket(Character ch1, Character ch2) {
        if (ch1 == '{' && ch2 == '}')
            return true;
        else if (ch1 == '(' && ch2 == ')')
            return true;
        else if (ch1 == '[' && ch2 == ']')
            return true;
        else
            return false;
    }


    public static void main(String[] args) {
        String expression ="{}}}{}";
        char[] character = expression.toCharArray();

        boolean flag = false;
        for (char ch:character) {
            if(ch == '{' || ch == '[' || ch == '(') {
                pushToStack (ch);
            }

            if(ch == '}' || ch == ']' || ch == ')') {
                if(!stack.isEmpty()) {
                    flag = isMatchingBracket(popFromStack(), ch);
                }
                else {
                    flag = false;
                    break;
                }
            }

        }

        if(!stack.isEmpty())
        {
            flag = false;
            stack.clear();
        }

        System.out.println(flag);

        Date date = new Date();
        //JSONObject sJsonObject = new JSONObject().put("ss", date);
    }
}
