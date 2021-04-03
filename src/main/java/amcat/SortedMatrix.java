package amcat;

public class SortedMatrix {
    public static void main(String[] args) {
        int a[][] ={
                {1,5,9},
                {14,20,21},
                {30,34,43}
        };

        int searchItem = 34;

        /*for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if(a[i][j] == searchItem)
                    System.out.println("Found at pos" + i +"-- " + j);
            }
        }*/

        // 2nd approach
        int x= 0, y=0;
        while (x< a.length) {

            if (a[x][a.length-1] < searchItem)
                x++;

            for (int i = 0; i < a.length; i++) {
                if(a[x][i] == searchItem) {
                    System.out.println("Found at pos" + x + "-- " + i);
                    x = a.length;
                    break;
                }
            }
        }

    }
}
