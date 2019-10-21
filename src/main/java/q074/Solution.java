package q074;

/**
 * @author mengchuilu
 */
public class Solution {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int height = matrix.length;
        int width = matrix[0].length;

        int pHeight = 0;
        int pWidth = width - 1;
        while (pHeight < height && pWidth >= 0) {
            if (matrix[pHeight][pWidth] > target) {
                pWidth --;
            } else if (matrix[pHeight][pWidth] < target) {
                pHeight ++;
            } else {
                return true;
            }
        }

        return false;
    }
}