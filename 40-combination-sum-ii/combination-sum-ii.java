import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        // Step 1: Sort candidates to handle duplicates and allow early pruning
        Arrays.sort(candidates);
        
        // Step 2: Start backtracking
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> current, int[] candidates, int remain, int start) {
        // Base case: Target sum achieved
        if (remain == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // Pruning: Since the array is sorted, if candidates[i] exceeds remain, subsequent elements will too
            if (candidates[i] > remain) {
                break;
            }

            // Skip duplicate elements at the same depth level
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // Choose candidate
            current.add(candidates[i]);

            // Explore with candidate included (pass i + 1 since each number can only be used once)
            backtrack(result, current, candidates, remain - candidates[i], i + 1);

            // Backtrack: Remove choice
            current.remove(current.size() - 1);
        }
    }
}