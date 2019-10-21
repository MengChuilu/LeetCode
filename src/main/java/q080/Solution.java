package q080;

import java.util.Arrays;

/**
 * @author mengchuilu
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        int i = 0;

        while(j < nums.length) {

            if (j > 1 && nums[j] == nums[i-1] && nums[j] == nums[i-2]) {
                j ++;
                continue;
            }

            nums[i] = nums[j];
            i ++;
            j ++;
        }

        System.out.println(Arrays.toString(nums));
        return i - 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int size = solution.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3});

        System.out.println(size);
    }
}
