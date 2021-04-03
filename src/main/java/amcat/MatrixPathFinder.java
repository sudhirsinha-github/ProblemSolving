package amcat;

public class MatrixPathFinder {
    private int[][] map;
    private boolean[][] visited = new boolean[4][4];
    int[] dest ={3, 0};
    private int count = 0;

    public MatrixPathFinder(int[][] map) {
        this.map = map;
    }

    private void dfs(int row, int col)
    {
//        System.out.printf("Visiting node [%d %d ] \n", row, col);

        int endLength = this.map.length -1;

        if(row == dest[0] && col ==dest[1])
        {
            System.out.println("Found ..." + count);
           // System.exit(0);
        }
        else if(visited[row][col])
            return;
        else if(row<0 || row >= endLength)
            return;
        else if(col<0 || col >= endLength)
            return;
        else if(this.map[row][col] == 1)
            return;
        else {
            this.visited[row][col] = true; //set current node as visited
            System.out.printf("Routing node [%d %d ] \n", row, col);
            count++;

            dfs(row, col+1); //move fwd
            dfs(row+1, col); //move down
            dfs(row, col-1); // mov back by 1
            dfs(row-1,col); //mov up by 1
        }
    }

    public static void main(String[] args) {
//        {false, false, false, false},
//                {true, true, false, true},
//                {false, false, false, false},
//                {false, false, false, false}
        int[][] map = {{0,0,0,0}, {1,1,0,0},
                {0,0,0,0}, {0,0,0,0}};
        MatrixPathFinder matrixPathFinder = new MatrixPathFinder(map);
        matrixPathFinder.dfs(0,0);
    }
}
