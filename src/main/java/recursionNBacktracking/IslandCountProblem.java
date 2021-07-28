package recursionNBacktracking;

public class IslandCountProblem {
    static int largest = 0;
    public static void main(String[] args) {

        //11110
        //11010
        //11000
        //00000
        int[][] grid = new int[][]{
                {1,1,1,1,1},
                {0,0,0,0,1},
                {1,1,0,0,0},
                {0,0,0,1,0}
        };

        System.out.println(countNumberOfIsland(grid));
        System.out.println(largest);
    }

    private static int countNumberOfIsland(int[][] grid){
        if(grid == null || grid.length == 0) // grid.length is matrix rows length
            return 0;

        int count = 0;

        // i  < rows
        for (int i = 0; i < grid.length; i++) {
            // j< columns == {{grid[i].length}}
            for (int j = 0; j < grid[i].length; j++) {
                count += dfs(grid, i, j);
            }
        }


        return count;
    }

    static int largestIslandCount =0;
    private static int dfs(int[][] grid, int i, int j) {
        // base condition here
        // i can travel up ,down , left and right
        // within given matrix /grid boundaries in 4 directions and for value = 1 only
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] == 0) {
            return 0;
        }

        // don't visit same block again
        // so set current position as 0
        grid[i][j] = 0;
        largestIslandCount++;

        largest = Math.max(largestIslandCount, largest);

        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);

        largestIslandCount = 0;
        return 1;
    }


}
