package designpaterns.builder;

public class Test {
    public static void main(String[] args) {
        CarBuilder builder = new CarBuilder.Builder("RED").
                setBody("TATA").setSupportsAutomatic(true)
                .setWeight(122).build();

        System.out.println(builder.hashCode());

         builder = new CarBuilder.Builder("RED").
                setBody("TATA").setSupportsAutomatic(true)
                .setWeight(122).build();
        System.out.println(builder.hashCode());

Car getMyCar = new CustomCarBuilder().setColor("GG").setBody("EEE").setWeight(22).build();

        System.out.println(getMyCar.getColor());
    }
}
