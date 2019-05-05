package q016;

import java.util.Arrays;

class Solution {
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);
        int diff = Integer.MAX_VALUE;
        int result = 0;

        for (int i = 0;i < nums.length - 1;i ++) {
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                if (nums[i] + nums[j] + nums[k] < target) {
                    if (diff > Math.abs(nums[i] + nums[j] + nums[k] - target)) {
                        diff = Math.abs(nums[i] + nums[j] + nums[k] - target);
                        result = nums[i] + nums[j] + nums[k];
                    }
                    j ++;
                } else if (nums[i] + nums[j] + nums[k] > target){
                    if (diff > Math.abs(nums[i] + nums[j] + nums[k] - target)) {
                        diff = Math.abs(nums[i] + nums[j] + nums[k] - target);
                        result = nums[i] + nums[j] + nums[k];
                    }
                    k --;
                } else {
                    return target;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,2,1,-4};
        Solution solution = new Solution();
        solution.threeSumClosest(nums, 1);
    }
}
