class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0;
        int left = 0;
        int right = height.length - 1;
        
        while (left < right) {
            // Calculate current width
            int width = right - left;
            
            // Find the limiting height and calculate area
            int currentHeight = Math.min(height[left], height[right]);
            int currentArea = width * currentHeight;
            
            // Update max water found so far
            maxWater = Math.max(maxWater, currentArea);
            
            // Move the pointer pointing to the smaller line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxWater;
    }
}