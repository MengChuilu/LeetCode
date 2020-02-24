package q661;

import java.util.Arrays;

public class Solution {

    public int[][] imageSmoother(int[][] M) {
        if (M == null || M.length == 0) {
            return null;
        }

        int width = M[0].length;
        int height = M.length;

         int [][] result = new int[height][width];

         for (int i = 0;i < height;i ++) {
             for (int j = 0;j < width;j ++) {

                 int sum = 0;
                 int count = 0;

                 for (int x = -1;x < 2;x ++) {
                     for (int y = -1;y < 2;y ++) {
                         int subX = i + x;
                         int subY  = j + y;

                         if (!(subX < 0 || subX >= height || subY < 0 || subY >= width)) {
                             sum += M[subX][subY];
                             count ++;
                         }
                     }
                 }

                 result[i][j] = sum / count;
             }
         }

         return result;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        int[][] result = solution.imageSmoother(new int[][]{new int[]{2, 3, 4}, new int[]{5, 6, 7}, new int[]{8, 9, 10}, new int[]{11, 12, 13},
                new int[]{14, 15, 16}});
        System.out.println(Arrays.deepToString(result));
    }
}
