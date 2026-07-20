class Solution {
    public int minStartValue(int[] nums) {
        int min=0;
        int sum=0;
        for (int num : nums) {
            sum += num;                  // Running (prefix) sum
            min = Math.min(min, sum); // Track the minimum running sum
        }

        return 1 - min;
    }
}