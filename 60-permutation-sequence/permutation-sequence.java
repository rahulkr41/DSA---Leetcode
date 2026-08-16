import java.util.ArrayList;
import java.util.List;

class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int fact = 1;
        
        // Precompute (n-1)! and populate the list [1, 2, ..., n]
        for (int i = 1; i < n; i++) {
            fact *= i;
            numbers.add(i);
        }
        numbers.add(n);
        
        StringBuilder result = new StringBuilder();
        // Convert k to 0-based indexing
        k = k - 1;
        
        while (true) {
            // Determine the index of the next character
            int index = k / fact;
            result.append(numbers.get(index));
            numbers.remove(index);
            
            if (numbers.isEmpty()) {
                break;
            }
            
            // Update k and the factorial for the next position
            k = k % fact;
            fact = fact / numbers.size();
        }
        
        return result.toString();
    }
}