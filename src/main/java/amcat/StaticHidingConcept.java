package amcat;

public class StaticHidingConcept {
    public static void main(String[] args) {


        A ab = new B();
        ab.foo();

        //B abb = (B) new A();
        //abb.foo();
    }
}

class A{
    A(){
        System.out.println("A base class");
    }

    public static void test(){
        System.out.println("A.. test");
    }

    public void foo(){
        System.out.println("BASE A foo");
    }
}

class B extends A{
    B(){
        System.out.println("B --->>Derived");
    }

    public static void test(){
        System.out.println("B.. test");
    }

    public void foo(){
        super.foo();
        System.out.println("B derived foo");
    }
}
