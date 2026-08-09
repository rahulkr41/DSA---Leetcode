class Solution {
    public int maxSubArray(int[] nums) {
        int maxSoFar = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Decide whether to add current element to existing subarray or start a new subarray
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            // Track the maximum sum encountered so far
            maxSoFar = Math.max(maxSoFar, currentSum);
        }

        return maxSoFar;
    }
}