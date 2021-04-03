package designpaterns;

/**
 * Represents the product created by the builder.
 */
class Car {
    private int wheels;
    private String color;

    public Car() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(final String color) {
        this.color = color;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(final int wheels) {
        this.wheels = wheels;
    }

    @Override
    public String toString() {
        return "Car [wheels = " + wheels + ", color = " + color + "]";
    }
}

/**
 * The builder abstraction.
 */
interface CarBuilder {
    Car build();

    CarBuilder setColor(final String color);

    CarBuilder setWheels(final int wheels);
}

class CarBuilderImpl implements CarBuilder {
    private Car car = new Car();

    public CarBuilderImpl() {
        car = new Car();
    }

    @Override
    public Car build() {
        return car;
    }

    @Override
    public CarBuilder setColor(final String color) {
        car.setColor(color);
        return this;
    }

    @Override
    public CarBuilder setWheels(final int wheels) {
        car.setWheels(wheels);
        return this;
    }
}

public class CarBuildDirector {
    private CarBuilder builder;

    public CarBuildDirector(final CarBuilder builder) {
        this.builder = builder;
    }

    public Car construct() {
        return builder.setWheels(4)
                      .setColor("Red")
                      .build();
    }

    public static void main(final String[] arguments) {
        final CarBuilder builder = new CarBuilderImpl();

        // final CarBuildDirector carBuildDirector = new CarBuildDirector(builder);
        Car car = builder.setWheels(4)
                .setColor("Red")
                .build();
        System.out.println(car);
    }
}

abstract class test implements Cloneable{
    @Override
    public Object clone() throws CloneNotSupportedException {
        return (test)super.clone();
    }
}

class TestA extends test
{
    public test clone() throws CloneNotSupportedException {
        return (test) super.clone();
    }
}