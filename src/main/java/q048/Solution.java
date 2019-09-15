package q048;

import java.util.Arrays;

/**
 * @author mengchuilu
 */
public class Solution {
    public void rotate(int[][] matrix) {
        if (matrix == null) {
            return;
        }

        int length = matrix.length;
        for (int i = 0;i < length / 2;i ++) {
            for (int j = 0;j < length;j ++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[length -1 - i][j];
                matrix[length -1 - i][j] = t;
            }
        }

        for (int i = 0;i < length;i ++) {
            for (int j = i;j < length;j ++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{1,2,3};
        int[] b = new int[]{4,5,6};
        int[] c = new int[]{7,8,9};

        int[][] parm = new int[][]{a, b, c};

        Solution solution = new Solution();
        solution.rotate(parm);
        System.out.println(Arrays.deepToString(parm));
    }
}