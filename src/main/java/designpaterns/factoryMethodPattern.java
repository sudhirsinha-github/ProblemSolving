package designpaterns;

public class factoryMethodPattern {
      static String planName = "COMMERCIALPLAN";
      static int units = 3;
      public static void main(String args[]) {
          GetPlanFactory planFactory = new GetPlanFactory();
          Plan p = planFactory.getPlan(planName);
          System.out.print("Bill amount for " + planName + " of  " + units
                        + " units is: ");
          p.getRate();
          p.calculateBill(units);

            CommercialPlan commercialPlan = (CommercialPlan) p; //factory u need to cast it to given type
            commercialPlan.newMethod();

            CommercialPlan commercialPlan1 = new CommercialPlan();
            commercialPlan1.newMethod();


      }
}

abstract class Plan {
      protected double rate;

      abstract void getRate();

      public void calculateBill(int units) {
            System.out.println(units * rate);
      }
}

class DomesticPlan extends Plan {
      // @override
      public void getRate() {
            rate = 3.50;
      }
}

class CommercialPlan extends Plan {
      // @override
      public void getRate() {
            rate = 7.50;
      }
      public void newMethod(){
            System.out.println("3456789");
      }
}

class InstitutionalPlan extends Plan {
      // @override
      public void getRate() {
            rate = 5.50;
      }

      public int newii(){
            return  88;
      }
}

class GetPlanFactory {

      // use getPlan method to get object of type Plan
      public Plan getPlan(String planType) {
            if (planType == null) {
//                  Plan plan = new InstitutionalPlan();
//                  (InstitutionalPlan)plan.newii(); // can't be resolved Y ?
                  return null;
            }
            if (planType.equalsIgnoreCase("DOMESTICPLAN")) {
                  return new DomesticPlan();
            } else if (planType.equalsIgnoreCase("COMMERCIALPLAN")) {
                  return new CommercialPlan();
            } else if (planType.equalsIgnoreCase("INSTITUTIONALPLAN")) {
                  return new InstitutionalPlan();
            }
            return null;
      }
}