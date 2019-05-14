package q031;

class Solution {

    // 自己写的代码
//    public void nextPermutation(int[] nums) {
//        int backMax = -1;
//        for (int i = nums.length - 1;i > 0;i --) {
//            if (nums[i] > nums[i-1]) {
//                backMax = i - 1;
//                break;
//            }
//        }
//
//        if (backMax != -1) {
//            for (int i = nums.length - 1;i > backMax && i > 0;i --) {
//                if (nums[i] > nums[backMax]) {
//                    int t = nums[i];
//                    nums[i] = nums[backMax];
//                    nums[backMax] = t;
//
//                    break;
//                }
//            }
//        }
//
//        int i = backMax + 1;
//        int last = nums.length-1;
//        while(i < last) {
//            int t = nums[i];
//            nums[i] = nums[last];
//            nums[last] = t;
//
//            i ++;
//            last--;
//        }
//    }
    // 题解代码  好像也没优雅多少
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.nextPermutation(new int[]{1, 1});
    }
}
