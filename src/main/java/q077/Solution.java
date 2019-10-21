package q077;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mengchuilu
 */
public class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backTrace(1, n, k, new ArrayList<>());
        return result;
    }

    private void backTrace(int start, int n, int k, List<Integer> now) {

        if (now.size() == k) {
            result.add(new ArrayList<>(now));
            return;
        }

        if (start > n) {
            return;
        }

        backTrace(start + 1, n, k, now);

        now.add(start);
        backTrace(start + 1, n, k, now);
        now.remove(now.size() - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> combine = solution.combine(4, 2);

        System.out.println(combine);
    }
}
