package arrays;

import java.util.Arrays;
import java.util.LinkedList;

public class MyList<T> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList(int capacity) {
       capacity = (capacity != 0) ? capacity : DEFAULT_CAPACITY;
        elements = new Object[capacity];
    }

    public void add(T e) {
        if (size == elements.length) {
            ensureCapa();
        }
        elements[size++] = e;
    }


    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }

    @SuppressWarnings("unchecked")
    public T get(int i) {
        if (i>= size || i <0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
        }
        return (T) elements[i];
    }

    public static void main(String[] args) {
        MyList<Object> list = new MyList<>(7);
        list.add(99);
        list.add("kkkk");
        list.add("iii");

        System.out.println(list.get(0));
    }
}
