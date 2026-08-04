class Solution {
    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        // No need to process the last element (n - 1)
        for (int i = 0; i < nums.length - 1; i++) {
            // Update the furthest reach from the current index
            farthest = Math.max(farthest, i + nums[i]);

            // If we've reached the end of the range for the current jump,
            // we must make another jump and update the range for the next.
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
                
                // Early exit if we can already reach or exceed the last index
                if (currentEnd >= nums.length - 1) {
                    break;
                }
            }
        }

        return jumps;
    }
}