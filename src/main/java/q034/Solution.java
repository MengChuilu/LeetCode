package q034;

class Solution {
    public int[] searchRange(int[] nums, int target) {

        int[] result = new int[]{-1, -1};

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                left = mid;
                right = mid;

                while (left >= 0 && nums[left] == nums[mid]) {
                    left --;
                }
                result[0] = left + 1;
                while (right < nums.length && nums[right] == nums[mid]) {
                    right ++;
                }
                result [1] = right - 1;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.searchRange(new int[]{5,7,7,8,8,10}, 6);
    }
}