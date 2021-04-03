package java8;

public class Vehicle {
   // void run(int speed);
    //void getT();
}

class Test extends Vehicle{

    public static void main(String[] args) {
        Vehicle vehicle = new Vehicle() {

            public void run(int speed) {
                System.out.println("Running :)" + speed);
            }
        };

        Vehicle v = new Test();


    }

    public void getT(){

    }
}
