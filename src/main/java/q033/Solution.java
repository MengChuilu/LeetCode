package q033;

class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (left + 1 == right) {
                for (int i = left;i <= right;i ++) {
                    if (target == nums[i]) {
                        return i;
                    }
                }
                return -1;
            }
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[left] && nums[mid] < nums[right]) {
                if (target < nums[mid]) {
                    right = mid - 1;
                } else if (target > nums[mid]){
                    left = mid + 1 ;
                } else {
                    return mid;
                }
            } else if (nums[mid] > nums[left] && nums[mid] > nums[right]){
                if (target > nums[mid]) {
                    left = mid + 1;
                } else if (target < nums[mid] && target < nums[left]) {
                    left = mid + 1;
                } else if (target < nums[mid] && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    return mid;
                }
            } else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else if (target < nums[mid] ) {
                    right = mid - 1;
                } else if (target > nums[mid] && target > nums[right]){
                    right = mid - 1;
                } else {
                    return mid;
                }
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1,3};

        Solution solution = new Solution();
        solution.search(array, 3);
    }
}
