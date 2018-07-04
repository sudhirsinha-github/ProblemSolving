package arrays;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.*;

public class MyList<T> implements Serializable{
    //List does not implement Serializable because is it not a key requirement for a list.
    // There is no guarantee (or need) that every possible implementation of a List can be serialized.
//LinkedList and ArrayList choose to do so, but that is specific to their implementation.

    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];
    private static final long serialVersionUID = 86834525233456789L;

    public MyList(int capacity) {
       capacity = (capacity != 0) ? capacity : DEFAULT_CAPACITY;
        elements = new Object[capacity];
    }

    public void add(T item) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = item;
    }

    public void addAll(T[] e) {
        for (T el : e) {
            if (size + e.length >= elements.length) {
                ensureCapa();
            }
            elements[size++] = el;
        }

    }

    public void remove(int index) {
        if(getSize() == 0)
            return;
        if(index  <0 && index > getSize())
            throw new ArrayIndexOutOfBoundsException();
        System.out.println(size +"--" + index);
        int newVal = size - index -1 ;

        System.arraycopy(elements, index+1, elements, index, newVal);
        elements[--size] = null;
    }

    public void removeAll() {
        if(getSize() == 0)
            return;

        elements = new Object[size]; // since we need a new brand array
    }

    public int getSize()
    {
        return this.size;
    }

    private void ensureCapa() {
        //ArrayList defaults to doubling the size of its array
        // while the ArrayList increases its array size by 50 percent.
        int newSize = (int) (elements.length * 1.5);
        System.out.println("###"+ newSize);
        elements = Arrays.copyOf(elements, newSize);
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index>= size || index <0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size " + index );
        }
        return (T) elements[index];
    }


    public static void main(String[] args) {
        MyList<Object> list = new MyList<>(2);
        list.add(99);
        list.add("kkkk");
        list.add("iii");
        list.add("www");
        list.add("qqqq");

       String[] arrayList = new String[]{"sss","wwwws"};
        list.addAll(arrayList);
        System.out.println(list.get(1) +" "+ list.getSize());
        list.remove(2);
        System.out.println(list.get(1) +" "+ list.size);

    }
}
