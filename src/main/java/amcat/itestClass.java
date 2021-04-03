package amcat;

public class itestClass{
    public static void main(String[] args) {
        // itest itest = new itestClass();
//        itest itest1 = new itest(){
//            @Override
//            public void doWork() {
//                System.out.println("eee");
//            }
//        };
//
//        itest1.doWork();

        itest itest1= new itest() {
            @Override
            public inner doWork() {

                System.out.println("uuuu");
                return new inner();
            }
        };


       itest.inner in = itest1.doWork();
        System.out.println(in.x);
    }
}
