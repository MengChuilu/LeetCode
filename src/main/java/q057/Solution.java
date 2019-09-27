package q057;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mengchuilu
 */
class Solution {
//    public int[][] insert(int[][] intervals, int[] newInterval) {
//
//        if (intervals.length == 0) {
//            return new int[][]{newInterval};
//        }
//        int[][] ints = new int[intervals.length + 1][];
//        ints[0] = newInterval;
//        for (int i = 1;i < ints.length;i ++) {
//            ints[i] = intervals[i-1];
//        }
//        Arrays.sort(ints, (x, y) -> {
//            if (x[0] != y[0]) {
//                return x[0] - y[0];
//            } else {
//                return x[0] - y[0];
//            }
//        });
//
//        List<int[]> result = new ArrayList<>();
//
//        int[] temp = ints[0].clone();
//
//        for (int i = 0;i < ints.length; i ++) {
//            if (temp[1] >= ints[i][0]) {
//                temp[1] = Math.max(temp[1], ints[i][1]);
//            } else {
//                result.add(temp.clone());
//                temp = ints[i].clone();
//            }
//        }
//
//        result.add(temp.clone());
//
//        int[][] resu = new int[result.size()][];
//        for (int i= 0; i< result.size();i ++) {
//            resu[i] = result.get(i);
//        }
//
//        return resu;
//    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        List<int[]> hasInterval = new ArrayList<>();
        List<int[]> endlist = new ArrayList<>();
        for (int i = 0;i < intervals.length; i ++) {
            if (intervals[i][1] < newInterval[0]) {
                list.add(intervals[i]);
            } else if (intervals[i][0] > newInterval[1]) {
                endlist.add(intervals[i]);
            } else {
                hasInterval.add(intervals[i]);
            }
        }

        hasInterval.add(newInterval);
        int start = Integer.MAX_VALUE;
        int end = Integer.MIN_VALUE;

        for (int[] ints : hasInterval) {
            start = Math.min(start, ints[0]);
            end = Math.max(end, ints[1]);
        }

        list.add(new int[]{start, end});
        list.addAll(endlist);
        int[][] resu = new int[list.size()][];
        for (int i= 0; i< list.size();i ++) {
            resu[i] = list.get(i);
        }

        return resu;
    }

    public static void main(String[] args) {
        int[][] param = new int[][]{new int[]{1, 2}, new int[]{3, 5}, new int[]{6, 7}, new int[]{8, 10},
                new int[]{12, 16}};
        Solution solution = new Solution();
        System.out.println(Arrays.deepToString(solution.insert(param, new int[]{4, 8})));
    }
}