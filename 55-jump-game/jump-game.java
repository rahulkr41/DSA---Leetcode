class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        
        for (int i = 0; i < nums.length; i++) {
            // If current index is beyond the maximum reachable index, we can't move forward
            if (i > maxReach) {
                return false;
            }
            
            // Update the furthest reachable index
            maxReach = Math.max(maxReach, i + nums[i]);
            
            // Early exit if we can already reach or pass the last index
            if (maxReach >= nums.length - 1) {
                return true;
            }
        }
        
        return true;
    }
}