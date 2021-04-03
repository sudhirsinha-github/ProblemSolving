public class Derived extends Base {

    private String derivedPri = "derivedPri";
    protected String derivedProt = "derivedProt";
    public String derivedPub = "derivedPub";

    public Derived(){
        System.out.println("derivedConstructor");
    }

    private void doDerivedPrivate(){
        System.out.println("doDerivedPrivate");
    }

    protected void doDerivedProtected(){
        System.out.println("doDerivedProtected");
    }

    public void doDerivedPublic(){
        System.out.println("doDerivedPublic");
    }

    void doDerivedVoid(){
        System.out.println("doDerivedVoid");
    }
}
