public class Test {

    public static void main(String[] args) {


        System.out.println(3*0.1);
        try {
            Parent parent = new Subclass();

//        Subclass subclass = new Parent();
            Subclass subclass = (Subclass) (new Parent()); //java.lang.ClassCastException: Parent cannot be cast to Subclass
            subclass.get();
            parent.get();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}

class Parent{
    public Parent() {
        System.out.println("Parent...CTTT");
    }

    public void get()
    {
        System.out.println("Parent...");
    }
}

class Subclass extends Parent{

    public Subclass() {
        System.out.println("subclass CTR");
    }

    public void run(){

    }

    @Override
    public void get() {
        System.out.println("subclass");
    }
}
