package binarytree;

import java.util.HashMap;

public class Car {
    Car() {
        System.out.println("carrr. ..");
    }

    void run() {
        System.out.println("car is running");
    }

}

class Audi extends Car {
    Audi() {
        System.out.println("AAudiii");
    }

    void run() {

        System.out.println("Audi is running safely with 100km");
    }

    public static void main(String args[]) {
        Car b = new Audi();    //upcasting
        b.run();

    }
}