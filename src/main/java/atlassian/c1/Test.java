package atlassian.c1;

public class Test {

    public static void main(String[] args) {
        RateLimiter rateLimiter = new RateLimiter();

        try {
            for (int i = 0; i < 50; i++) {
                rateLimiter.verifyAndUpdateClient("CLIENT_Google");
                Thread.sleep(100);
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}



// web app
// client_ID | 100
// client


// clintid | timestamp_r1 0 (ttl - 1min)