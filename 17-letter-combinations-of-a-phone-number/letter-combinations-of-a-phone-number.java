import java.util.ArrayList;
import java.util.List;

class Solution {
    // Mapping of digits to letters matching a standard telephone keypad
    private static final String[] KEYPAD = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        // Edge case: if the input string is empty, return an empty list
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int index, StringBuilder current, List<String> result) {
        // Base case: if the current combination is of the same length as digits, we found a match
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get the letters that the current digit maps to
        char digit = digits.charAt(index);
        String letters = KEYPAD[digit - '0'];

        // Loop through the letters and recurse
        for (int i = 0; i < letters.length(); i++) {
            current.append(letters.charAt(i));              // Choose
            backtrack(digits, index + 1, current, result);   // Explore
            current.deleteCharAt(current.length() - 1);     // Unchoose (Backtrack)
        }
    }
}