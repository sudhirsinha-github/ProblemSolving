package designpaterns.builder;

public class CustomCarBuilder implements ICarBuilder {
    private String color; //Enforce color mandatory fields
    private String body;
    private Integer weight;


    @Override
    public ICarBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    @Override
    public ICarBuilder setBody(String body) {
        this.body = body;
        return this;
    }

    @Override
    public ICarBuilder setWeight(Integer weight) {
        this.weight = weight;
        return this;
    }

    @Override
    public Car build(){
            Car car = new Car();
            car.setWeight(this.weight);
            car.setBody(this.body);
            car.setColor(this.color);

            return car;
    }
}
