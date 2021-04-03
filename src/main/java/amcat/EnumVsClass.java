package amcat;

public enum EnumVsClass implements Runnable{
    Header("test"),
    Type("local");

    private String value;
    EnumVsClass(String data){
        this.value = data;
    }

    public String getValue()
    {
        return this.value;
    }


    @Override
    public void run() {

    }
}

class Testq{
}
class ClassTest{
    public static void main(String[] args) {
        EnumVsClass.values();

        // EnumVsClass.
        // Can't instantiate enum class
        // EnumVsClass enumVsClass = new EnumVsClass();

        Testq test = new Testq();
    }
}