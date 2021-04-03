package amcat;

public interface itest {
      int i =1;


      itest rr= new itest() {
          @Override
          public inner doWork() {
              System.out.println("86789876");
              return new inner();
          }
      };

    inner doWork();

    class inner{
        int x = 111;

        int test()
        {
            return x;
        } // default method not allowed in class .its only for interface
    }

    enum ww {
        ss;
    }
}
