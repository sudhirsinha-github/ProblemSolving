package designpaterns;

// Chain of Respo ...
abstract class Approver {
    protected Approver nextApprover;

    abstract void processBussinessClaimsRequest(int amount);

    public void setNextApprover(Approver approver) {
        nextApprover = approver;
    }
}

class Manager extends Approver{

    @Override
    void processBussinessClaimsRequest(int amount) {
        if(amount>0 & amount < 1000)
        {
            System.out.println("Processed by manager!!!" + amount);
        }
        else if(nextApprover != null)
        {
            System.out.println("Will pass ticket to nextApprover - " + nextApprover);
            nextApprover.processBussinessClaimsRequest(amount);
        }
    }
}

class Director extends Approver{

    @Override
    void processBussinessClaimsRequest(int amount) {
        if(amount>1000 & amount <10000)
        {
            System.out.println("Processed by Director!!!" + amount);
        }
        else if(nextApprover != null)
        {
            System.out.println("Will pass ticket to nextApprover - " + nextApprover);
            nextApprover.processBussinessClaimsRequest(amount);
        }
    }
}

class SeniorDirector extends Approver{

    @Override
    void processBussinessClaimsRequest(int amount) {
        if(amount>=10000 & amount < 200000)
        {
            System.out.println("Processed by SeniorDirector!!!" + amount);
        }
        else
        {
            System.out.println("Will pass ticket to nextApprover - " + nextApprover);
            System.out.println("Schedule a meeting with CEO !!");
        }
    }
}

public class ChainOfResponseDemo{
    public static void main(String[] args) {
        Approver manager = new Manager();
        Approver director = new Director();
        Approver seniorDirector = new SeniorDirector();
        manager.setNextApprover(director);
        director.setNextApprover(seniorDirector);
        manager.processBussinessClaimsRequest(1000000);
    }
}