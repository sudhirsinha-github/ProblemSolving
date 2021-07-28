


//1 1 1 1 0 4
//1 1 1 0 0 3
//1 0 0 0 0 //1 o/p
//1 1 0 0 0 //2
//
//min
// res[4 ,3 ,1,2]

//Given a matrix of 0s and 1s, where 0 represent villagers and 1 represent soldiers.
//In each row soldiers stand in front (left to right) and villagers stand behind.
//The enemy is known to attack a row with the least number of soldiers.
//
//Find the next row that the enemy will target.

public class MSTest {
    public static void main(String[] args) {

    }

    /**
     *
     * @param matrix
     * @return
     */

    //1 1 1 1 0  -- 4  col/2*r ~m*N
//1 1 1 0 0  -- 3
//1 0 0 0 0 //1 o/p
//1 0 0 0 0 //1


  // 1 1 1 0 0 m*logn

    static int findRowToBeAttacked(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[row - 1].length;
        int min = Integer.MAX_VALUE;
        int minIndex = -1;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                // count number of soldiers
                if (matrix[i][j] == 1) {
                    count++;
                }

                if (matrix[i][j] == 0) {
                    break;
                }
            }

            // min check
            if (min >= count) {
                min = count; // 4
                minIndex = i; // 0
                if(minIndex == 0)
                    return minIndex;
            }

            count = 0;
        }

        return minIndex;
    }
}
