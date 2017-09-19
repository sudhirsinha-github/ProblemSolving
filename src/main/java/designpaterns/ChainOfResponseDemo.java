package designpaterns;

import com.sun.org.apache.bcel.internal.generic.ARRAYLENGTH;

import java.util.*;

/**
 * Created by sudhirkumar on 9/18/17.
 */

// Chain of Respo ...
abstract class Approver {
    Approver nextApprover;

    abstract void processClaimsRequest(int amount);

    public void setNextApprover(Approver approver) {
        nextApprover = approver;
    }
}


class Manager extends Approver{

    @Override
    void processClaimsRequest(int amount) {
        if(amount>0 & amount < 1000)
        {
            System.out.println("Processed by manager!!!" + amount);
        }
        else if(nextApprover != null)
        {
            System.out.println("Will pass ticket to nextApprover - " + nextApprover);
            nextApprover.processClaimsRequest(amount);
        }
    }
}

class Director extends Approver{

    @Override
    void processClaimsRequest(int amount) {
        if(amount>1000 & amount <10000)
        {
            System.out.println("Processed by Director!!!" + amount);
        }
        else if(nextApprover != null)
        {
            System.out.println("Will pass ticket to nextApprover - " + nextApprover);
            nextApprover.processClaimsRequest(amount);
        }
    }
}

class President extends Approver{

    @Override
    void processClaimsRequest(int amount) {
        if(amount>10000 & amount < 200000)
        {
            System.out.println("Processed by President!!!" + amount);
        }
        else
        {
            System.out.println("Will pass ticket to nextApprover - " + nextApprover);
            System.out.println("Schedule a meeting with President!!");
        }
    }
}

public class ChainOfResponseDemo{
    public static void main(String[] args) {
        Approver approver = new Manager();
        Approver director = new Director();
        Approver president = new President();
        approver.setNextApprover(director);
        director.setNextApprover(president);
        approver.processClaimsRequest(100000);
    }
}