package q064;

import java.util.Arrays;

public class Solution {
    int[][] cache = new int[1000][];

    public int minPathSum(int[][] grid) {
        for (int i = 0;i < 1000;i ++) {
            cache[i] = new int[1000];
            Arrays.fill(cache[i], -1);
        }
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int width = grid[0].length;
        int height = grid.length;

        return minPathSum(grid, height - 1, width - 1);
    }

    public int minPathSum(int[][] grid, int x, int y) {

        if (x == 0 && y == 0) {
            return grid[x][y];
        }

        if (cache[x][y] != -1) {
            return cache[x][y];
        }

        int resultX = x > 0 ? minPathSum(grid, x-1, y) : Integer.MAX_VALUE;
        int resultY = y > 0 ? minPathSum(grid, x, y-1) : Integer.MAX_VALUE;

        int result = Math.min(resultX, resultY) + grid[x][y];
        cache[x][y] = result;
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int [][] parm = new int[3][];
        parm[0] = new int[]{1, 3, 1};
        parm[1] = new int[]{1, 5, 1};
        parm[2] = new int[]{4, 2, 1};
        System.out.println(solution.minPathSum(parm));
    }
}
