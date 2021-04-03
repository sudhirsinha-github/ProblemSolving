import com.google.common.primitives.UnsignedInteger;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;

public class TestMain {
    static final String name = "sa";
    public static void main(String[] args) {
        String aa = "abcd";
        String bb = new String("abcd");
        System.out.println(aa==bb);
        System.out.println(aa.equals(bb));

        Integer aInt = 127;
        Integer bInt = 127;
        System.out.println(aInt==bInt);
        System.out.println(aInt.equals(bInt));

        System.out.println("==========================");
        Base b = new Base();
        System.out.println(b.baseProt);
        System.out.println(b.basePub);
        b.doBaseProtected();
        b.doBasePublic();
        b.doBaseVoid();
        System.out.println("==========================");
        Derived d = new Derived();
        System.out.println(d.baseProt );
        System.out.println(d.basePub);
        System.out.println(d.derivedProt);
        System.out.println(d.derivedPub);
        d.doBaseProtected();
        d.doBasePublic();
        d.doBaseVoid();
        d.doDerivedProtected();
        d.doDerivedPublic();
        d.doDerivedVoid();
        System.out.println("==========================");
        Base b1 = new Derived(); // Base == new base
        System.out.println(b1.baseProt);
        System.out.println(b1.basePub );
        b1.doBaseProtected();
        b1.doBasePublic();
        b1.doBaseVoid();
        System.out.println("==========================");
        Derived d1 = (Derived) new Base();

        int i = 120;
        int j = 120;
        System.out.println(i == j);

        Integer i1 = 120;
        Integer j1 = 120;
        System.out.println(i1 == j1);


        Integer i2 = 128;
        Integer j2 = 128;
        System.out.println(i2 == j2);


        Employee employee = new Employee();
        employee.emailId ="eee";
        employee.empId = 123;

        Employee employeeB = new Employee();
        employeeB.emailId ="eee";
        employeeB.empId = 123;
        employee.equals(employeeB);

        try{

        }
        catch(Exception e){

        }
        finally{

        }
    }
}

class Employee{
    Integer empId; // db is save?? to check if null?? and can customize error on process
    String firstName;
    String lastName;
    Date dob;
    Double salary;
    String emailId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        return empId.intValue() == employee.empId.intValue();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(21).build().hashCode();
    }
}