package assesment;

import java.sql.Array;
import java.util.*;

public class NestedIterator implements Iterator<Integer> {
    Stack<NestedInteger> stack = new Stack<NestedInteger>();
 
    public NestedIterator(List<NestedInteger> nestedList) {
        if(nestedList==null)
            return;
 
        for(int i=nestedList.size()-1; i>=0; i--){
            stack.push(nestedList.get(i));
        }
    }

    @Override
    public Integer next() {
        return stack.pop().getInteger();
    }
 
    @Override
    public boolean hasNext() {
       /* while(!stack.isEmpty()){
            NestedInteger top = stack.peek();
            if(top.isInteger()){
                return true;
            }else{
                stack.pop();
                for(int i=top.getList().size()-1; i>=0; i--){
                    stack.push(top.getList().get(i));
                }
            }
        }*/
 
        return false;
    }

    public static void main(String[] args) {
        List t = new ArrayList();
        t.add(1);
        t.add(2);
        t.add(Arrays.asList(1,4,5));
        t.add(3);
        t.add(5);
        t.add(Arrays.asList(1,5,7));
        System.out.println(t);
    }

    private class NestedInteger {
        public Integer getInteger() {
        return 1;
        }

    }
}