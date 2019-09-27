package q059;

import java.util.Arrays;

/**
 * @author mengchuilu
 */
class Solution {
    public int[][] generateMatrix(int n) {
        String direct = "right";

        int[][] result = new int[n][];
        for (int i = 0;i < n;i++ ) {
            result[i] = new int[n];
        }

        int flag = 1;
        int i = 0;
        int j = 0;

        while (flag <= n * n) {
            result[i][j] = flag ++;
            if ("right".equals(direct)) {
                if (j < n-1 && result[i][j+1] == 0) {
                    j ++;
                } else {
                    direct = "down";
                    i ++;
                }
            } else if ("down".equals(direct)) {
                if (i < n-1 && result[i+1][j] == 0) {
                    i ++;
                } else {
                    direct = "left";
                    j --;
                }
            } else if ("left".equals(direct)) {
                if (j > 0 && result[i][j-1] == 0) {
                    j --;
                } else {
                    direct = "up";
                    i --;
                }
            } else {
                if (i > 0 && result[i-1][j] == 0) {
                    i--;
                } else {
                    direct = "right";
                    j ++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.generateMatrix(5)));
    }
}