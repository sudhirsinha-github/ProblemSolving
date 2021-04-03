public class Base {
    private String basePri = "basePri";
    protected String baseProt = "baseProt";
    public String basePub = "basePub";

    public Base(){
        System.out.println("baseConstructor");
    }

    private void doBasePrivate(){
        System.out.println("doBasePrivate");
    }

    protected void doBaseProtected(){
        System.out.println("doBaseProtected");
    }

    public void doBasePublic(){
        System.out.println("doBasePublic");
    }

    void doBaseVoid(){
        System.out.println("doBaseVoid");
    }

    public final void doBaseFinal(){
        System.out.println("doBaseFinal");
    }
}