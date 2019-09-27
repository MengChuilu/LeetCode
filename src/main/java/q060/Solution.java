package q060;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mengchuilu
 */
public class Solution {

    String  result = null;

    public String getPermutation(int n, int k) {

        List<Integer> list = new ArrayList<>();
        for (int i = 1;i <= n;i ++) {
            list.add(i);
        }
        List<Integer> subResult = new ArrayList<>();

        traceBack(list, k, subResult);
        return result;
    }

    private void traceBack(List<Integer> remain, int k, List<Integer> subResult) {

        if (result != null) {
            return;
        }
        if (remain.size() == 0) {
            String s = "";

            for (int i = 0;i < subResult.size();i ++) {
                s += subResult.get(i);
            }

            result = s;
        }
        for (int i = 0;i < remain.size();i ++) {
            int remove = remain.remove(i);
            subResult.add(remove);
            int factorial = findFactorial(remain.size());
            if (k <= factorial) {
                traceBack(remain, k, subResult);
            }

            k -= factorial;
            remain.add(i, remove);
            subResult.remove(subResult.size() - 1);
        }
    }

    private int findFactorial(int n) {

        int result = 1;
        for (int i = 1;i <= n;i ++) {
            result *= i;
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String permutation = solution.getPermutation(3, 3);
        System.out.println(permutation);
    }
}