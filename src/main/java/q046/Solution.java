package q046;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrace(nums, 0);

        return result;
    }

    private void backtrace(int[] nums, int start) {
        if (start == nums.length - 1) {
            result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        }

        for (int i = start; i < nums.length; i ++) {
            swap(nums, start, i);
            backtrace(nums, start + 1);
            swap(nums, start, i);
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int t = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = t;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.permute(new int[]{1,2,3}));

    }
}