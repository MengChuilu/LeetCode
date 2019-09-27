package q063;

import java.util.Arrays;

/**
 * @author mengchuilu
 */
public class Solution {
    int[][] cache = new int[100][];

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        for (int i = 0;i < 100;i ++) {
            cache[i] = new int[100];
            Arrays.fill(cache[i], -1);
        }
        if (obstacleGrid == null || obstacleGrid.length == 0) {
            return 0;
        }

        int width = obstacleGrid[0].length;
        int height = obstacleGrid.length;
        return uniquePathsWithObstacles(obstacleGrid, 0, 0, width, height);
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid, int x, int y, int width, int height) {

        if ((y + 1 == width) && (x + 1 == height) && obstacleGrid[x][y] == 0) {
            return 1;
        }

        if (x == height || y == width || obstacleGrid[x][y] == 1) {
            return 0;
        }

        if (cache[x][y] != -1) {
            return cache[x][y];
        }

        int result = uniquePathsWithObstacles(obstacleGrid, x + 1, y, width, height)
                + uniquePathsWithObstacles(obstacleGrid, x, y + 1, width, height);

        cache[x][y] = result;

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int [][] parm = new int[3][];
        parm[0] = new int[]{0, 0, 0};
        parm[1] = new int[]{0, 1, 0};
        parm[2] = new int[]{0, 0, 0};
        System.out.println(solution.uniquePathsWithObstacles(parm));
    }
}