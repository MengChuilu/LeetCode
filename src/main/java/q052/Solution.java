package q052;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mengchuilu
 */
public class Solution {

    List<List<String>> result = new ArrayList<>();
    List<int[][]> list = new ArrayList<>();

    public int totalNQueens(int n) {

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

        return result.size();
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
}