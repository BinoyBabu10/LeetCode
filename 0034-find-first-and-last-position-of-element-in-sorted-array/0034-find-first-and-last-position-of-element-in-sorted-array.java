class Solution {
    public int[] searchRange(int[] nums, int target) {

        int first = lowerBound(nums, target);
        int last = upperBound(nums, target) - 1;

        if (first == nums.length || nums[first] != target) {
            return new int[]{-1, -1};
        }

        return new int[]{first, last};
    }

    public int lowerBound(int[] nums, int target) {

        int low = 0;
        int high = nums.length;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] >= target) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }

        return low;
    }

    public int upperBound(int[] nums, int target) {

        int low = 0;
        int high = nums.length;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (nums[mid] > target) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }

        return low;
    }
}