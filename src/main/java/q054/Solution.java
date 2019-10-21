package q054;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> spiralOrder(int[][] matrix) {

        if (matrix.length == 0) {
            return new ArrayList<>();
        }
        int height = matrix.length;
        int width = matrix[0].length;

        String flag = "right";
        int x = 0;
        int y = 0;
        List<Integer> result = new ArrayList<>();
        while (true) {

            result.add(matrix[x][y]);
            matrix[x][y] = Integer.MIN_VALUE;

            if (result.size() == width * height) {
                return result;
            }

            switch (flag) {
                case "right" : {
                    if (y == width - 1 || matrix[x][y + 1] == Integer.MIN_VALUE) {
                        flag = "down";
                        x++;
                    } else {
                        y++;
                    }

                    break;
                }

                case "down" : {
                    if (x == height - 1 || matrix[x + 1][y] == Integer.MIN_VALUE) {
                        flag = "left";
                        y --;
                    } else {
                        x ++;
                    }

                    break;
                }

                case "left" : {
                    if (y == 0 || matrix[x][y - 1] == Integer.MIN_VALUE) {
                        flag = "up";
                        x --;
                    } else {
                        y --;
                    }

                    break;
                }

                case "up" : {
                    if (x == 0 || matrix[x - 1][y] == Integer.MIN_VALUE) {
                        flag = "right";
                        y ++;
                    } else {
                        x --;
                    }

                    break;
                }
                default:{

                }
            }
        }
    }

    public static void main(String[] args) {

        int[][] result = new int[3][];
        result[0] = new int[]{1,2,3,4};
        result[1] = new int[]{5,6,7,8};
        result[2] = new int[]{9,10,11,12};
        Solution solution = new Solution();
        List<Integer> list = solution.spiralOrder(result);

        System.out.println(list);
    }
}