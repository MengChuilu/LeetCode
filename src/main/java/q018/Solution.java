package q018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();
        //先排序
        Arrays.sort(nums);

        for (int i = 0;i < nums.length - 2;i ++) {
            // 去除指针i可能的重复情况
            if (i != 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for (int j = i + 1;j < nums.length;j ++) {
                // 去除j可能重复的情况
                if (j != i + 1 && nums[j] == nums[j-1]) {
                    continue;
                }

                int left = j + 1;
                int right = nums.length -1;

                while (left < right) {
                    // 不满足条件或者重复的，继续遍历
                    if ((left != j + 1 && nums[left] == nums[left-1]) || nums[i] + nums[j] + nums[left] + nums[right] < target) {
                        left ++;
                    } else if ((right != nums.length -1 && nums[right] == nums[right + 1]) || nums[i] + nums[j] + nums[left] + nums[right] > target) {
                        right --;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[left]);
                        list.add(nums[right]);

                        result.add(list);
                        // 满足条件的，进入下一次遍历
                        left ++;
                        right --;
                    }
                }

            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] in = new int[]{0, 0, 0, 0};

        Solution solution = new Solution();
        solution.fourSum(in, 0);
    }
}
