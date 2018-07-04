package designpaterns.builder;

public interface ICarBuilder {
    public ICarBuilder setColor(String color);
    public ICarBuilder setBody(String body);
    public ICarBuilder setWeight(Integer weight);
    public Car build();
}
