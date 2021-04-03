package amcat;

import java.util.Scanner;

public class tryfinally {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        String pwd= new String();
        try {
            System.out.println("Enter password");
            pwd = scanner.nextLine();
            System.out.println("Pwd entered is " + pwd);

        }
        finally {
            if(pwd.length()>3)
            {
                System.out.println("valid");
            }
            else{
                System.out.println("NOT valid");
            }
        }
    }
}
