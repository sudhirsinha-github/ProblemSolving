package amcat;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;

public class NestedListItterator implements Iterator {

    private List<Object> nesObjects =null;
    private Stack<Object> stack = new Stack<>();
    private Object object = null;
    NestedListItterator(List<Object> objectList) {
        this.nesObjects = objectList;
        for (int i = objectList.size() - 1; i >= 0; i--) {
            stack.push(objectList.get(i));
        }
    }

    @Override
    public boolean hasNext() {

        if(stack.empty())
            return false;

        Object item = stack.peek();

        if(item == null)
            return false;

        if(item instanceof Integer)
        {
            return true;
        }
        else {
            stack.pop();
            List<Object> objectList = (List<Object>) item;
            for (int i = objectList.size() - 1; i >= 0; i--) {
                stack.push(objectList.get(i));
            }

         return hasNext();
        }
    }

    @Override
    public Object next() {
        return stack.pop();
    }

    public static void main(String[] args) {
        ArrayList<Object> objects = new ArrayList<>();
        ArrayList<Object> childobjects = new ArrayList<>();
        childobjects.add(new Integer(234));
        childobjects.add(new Integer(211));
        objects.add(new Integer(88));
        objects.add(new Integer(70));
        objects.add(childobjects);
        List<Object> list = new ArrayList<>();
        list.add(new Integer(12));
        list.add(new Integer(16));
        list.add(objects);


        NestedListItterator nestedListItterator = new NestedListItterator(list);
        while (nestedListItterator.hasNext()){
            System.out.println(nestedListItterator.next());
        }

        /*Iterator<Object> iterator = list.iterator();
        iterator.hasNext();
        iterator.hasNext();
        System.out.println(iterator.next());
        System.out.println(iterator.next());*/
    }
}


