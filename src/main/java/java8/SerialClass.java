package java8;

import java.io.Serializable;
import java.util.*;

public class SerialClass extends Employee implements Serializable  {
    private Date currentTime;
    private static int i;

    private static long serialVersionUID = 719625691177501L;

    public SerialClass() {
        currentTime = Calendar.getInstance().getTime();
    }

    public Date getCurrentTime() {
        return currentTime;
    }

    static class ss{

    }


    public int getId()
    {

        return i;
    }

    public int gettestId(){

        return testId;
    }
}

class Employee implements Cloneable{

    int testId = 122;
    public Employee(){
    }
    public Object clone() throws
            CloneNotSupportedException {
        // Assign the shallow copy to new refernce variable t
        Employee t = (Employee) super.clone();

        t = new Employee();

        // Create a new object for the field c
        // and assign it to shallow copy obtained,
        // to make it a deep copy

        return t;
    }
}