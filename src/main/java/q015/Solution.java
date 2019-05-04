package q015;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0 ;i < nums.length - 1;i ++) {
            if (i == 0 || (nums[i] != nums[i - 1])) {
                int j = i + 1;
                int k = nums.length - 1;
                while(j < k) {
                    if (j == i || nums[j] + nums[k] + nums[i] < 0) {
                        j ++;
                    } else if (k == i || nums[j] + nums[k] + nums[i] > 0){
                        k --;
                    } else {
                        if ((j - 1 == i || nums[j] != nums[j-1]) && (k == nums.length - 1 || nums[k] != nums[k+1])) {
                            List<Integer> list = new ArrayList<>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            result.add(list);
                        }
                        j ++;
                        k --;
                    }
                }
            }
        }

        return result;
    }

}