package q078;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mengchuilu
 */
public class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrace(nums, new ArrayList<>(), 0);

        return result;
    }

    private void backtrace(int[] nums, List<Integer> now, int start) {

        if (start == nums.length) {
            result.add(new ArrayList<>(now));
            return;
        }

        backtrace(nums, now, start + 1);
        now.add(nums[start]);
        backtrace(nums, now, start + 1);
        now.remove(now.size() - 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> subsets = solution.subsets(new int[]{1, 2, 3, 4});

        System.out.println(subsets);

    }
}
