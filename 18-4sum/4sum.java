import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return ans;
        }
        
        // Step 1: Sort the array to easily handle duplicates and use two pointers
        Arrays.sort(nums);
        int n = nums.length;
        
        for (int i = 0; i < n - 3; i++) {
            // Avoid duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            // Optimization 1: The smallest possible sum starting with i is larger than target
            if ((long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            // Optimization 2: The largest possible sum starting with i is smaller than target
            if ((long) nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target) continue;
            
            for (int j = i + 1; j < n - 2; j++) {
                // Avoid duplicates for the second element
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                
                // Optimization 3: The smallest possible sum starting with i and j is larger than target
                if ((long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) break;
                // Optimization 4: The largest possible sum starting with i and j is smaller than target
                if ((long) nums[i] + nums[j] + nums[n - 1] + nums[n - 2] < target) continue;
                
                // Step 2: Initialize two pointers for the remaining search space
                int left = j + 1;
                int right = n - 1;
                
                while (left < right) {
                    // Use long to prevent integer overflow from large test cases
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        
                        // Avoid duplicates for the third element
                        while (left < right && nums[left] == nums[left + 1]) left++;
                        // Avoid duplicates for the fourth element
                        while (left < right && nums[right] == nums[right - 1]) right--;
                        
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        
        return ans;
    }
}