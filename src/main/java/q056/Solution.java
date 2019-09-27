package q056;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mengchuilu
 */
public class Solution {
    public int[][] merge(int[][] intervals) {

        if (intervals.length == 0) {
            return intervals;
        }
        Arrays.sort(intervals, (x, y) -> {
            if (x[0] != y[0]) {
                return x[0] - y[0];
            } else {
                return x[0] - y[0];
            }
        });

        List<int[]> result = new ArrayList<>();

        int[] temp = intervals[0].clone();

        for (int i = 0;i < intervals.length; i ++) {
            if (temp[1] >= intervals[i][0]) {
                temp[1] = Math.max(temp[1], intervals[i][1]);
            } else {
                result.add(temp.clone());
                temp = intervals[i].clone();
            }
        }

        result.add(temp.clone());

        int[][] resu = new int[result.size()][];
        for (int i= 0; i< result.size();i ++) {
            resu[i] = result.get(i);
        }

        return resu;
    }

    public static void main(String[] args) {
        int[][] param = new int[][]{new int[]{1, 3}, new int[]{2, 6}, new int[]{8, 10}, new int[]{15, 18}};
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.merge(param)));
    }
}