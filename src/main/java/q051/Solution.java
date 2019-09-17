package q051;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mengchuilu
 */
public class Solution {

    List<List<String>> result = new ArrayList<>();
    List<int[][]> list = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {

        int[][] temp = new int[n][];
        for (int i = 0;i < n;i ++) {
            int[] s = new int[n];
            Arrays.fill(s, 0);
            temp[i] = s;
        }
        backtrace(0, n, temp);

        for (int[][] entry : list) {
            List<String> lists = new ArrayList<>();
            for (int i = 0;i < n;i ++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0;j < n;j ++) {
                    if (entry[i][j] == 0) {
                        stringBuilder.append(".");
                    } else {
                        stringBuilder.append("Q");
                    }
                }
                lists.add(stringBuilder.toString());
            }
            result.add(lists);
        }

        return result;
    }

    private void backtrace(int start, int n, int[][] map) {
        if (start == n) {
            int[][] brr = new int[n][];
            for (int i = 0;i < n;i ++) {
                int[] br = new int[n];
                for (int j = 0 ;j < n;j ++) {
                    br[j] = map[i][j];
                }
                brr[i] = br;
            }
            list.add(brr);
            return;
        }
        for (int i = 0;i < n; i ++) {
            int[] s = new int[n];
            Arrays.fill(s, 0);
            s[i] = 1;
            map[start] = s;
            if (!conflict(map, start, i, n)) {
                backtrace(start + 1, n, map);
            }
            s[i] = 0;
            map[start] = s;
        }
    }

    private boolean conflict(int[][] map, int x, int y, int n) {

        int result = 0;
        for (int i = 0;i < x;i ++) {
            result += map[i][y];
        }

        for (int i = 0;i < n;i ++) {
            int j = x + y - i;
            if (j < n && j >= 0 && j != y) {
                result += map[i][j];
            }
        }

        for (int i = 0; i < n;i ++) {
            int j = y - (x - i);
            if (j < n && j >= 0 && j != y) {
                result += map[i][j];
            }
        }

        return result != 0;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solveNQueens(4));
//        int[][] parm = new int[5][];
//        parm[0] = new int[]{1,0,0,0,0};
//        parm[1] = new int[]{0,0,1,0,0};
//        parm[2] = new int[]{0,0,0,0,1};
//        parm[3] = new int[]{0,1,0,0,0};
//        parm[4] = new int[]{0,0,0,1,0};
//        System.out.println(solution.conflict(parm, 0, 0, 5));
    }
}