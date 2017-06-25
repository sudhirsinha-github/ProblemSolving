package java8;

/**
 * Created by sudhirkumar on 6/1/17.
 */
 class Subclass{
   // C c = new B();
   public static void main(String[] args) {
       A a = new C();
       a.read();
   }
}

class A{
     public void write(){
        System.out.println("A.write");
    }

     public void read(){
        System.out.println("A.read");
    }
}

class B extends A{
    public void write(){
        System.out.println("B.write");
    }

    public void read(){
        System.out.println("B.read");
    }
}

class C extends A{
    public void write(){

        System.out.println("C.write");
    }

}


