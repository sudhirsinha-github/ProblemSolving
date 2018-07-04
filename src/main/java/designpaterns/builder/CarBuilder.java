package designpaterns.builder;

public class CarBuilder {
    private final String color; //Enforce color mandatory fields
    private String body;
    private Integer weight;
    private Boolean supportsAutomatic;

    public CarBuilder(Builder builder) {
        this.color = builder.color;
        this.body = builder.body;
        this.weight = builder.weight;
        this.supportsAutomatic = builder.supportsAutomatic;
    }

    public static class Builder{

        private final String color; //Enforce color mandatory fields
        private String body;
        private Integer weight;
        private Boolean supportsAutomatic;

        //Enforce color mandatory fields
        public Builder(String color){
            this.color = color;
        }

//        public Builder setColor(String color) {
//            this.color = color;
//            return this;
//        }

        public Builder setBody(String body) {
            this.body = body;
            return this;
        }

        public Builder setWeight(Integer weight) {
            this.weight = weight;
            return this;
        }

        public Builder setSupportsAutomatic(Boolean supportsAutomatic) {
            this.supportsAutomatic = supportsAutomatic;
            return this;
        }

        public CarBuilder build()
        {
            return new CarBuilder(this);
        }
    }


}
