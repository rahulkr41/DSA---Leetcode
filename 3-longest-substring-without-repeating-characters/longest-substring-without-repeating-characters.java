import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Map to store the most recent index of each character
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        // Loop through the string with the 'right' pointer
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If the character is already in the map and within the current window
            if (map.containsKey(currentChar)) {
                // Move the left pointer past the previous occurrence
                left = Math.max(left, map.get(currentChar) + 1);
            }

            // Update or insert the character's latest index
            map.put(currentChar, right);

            // Calculate the window size and update the maximum length
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}