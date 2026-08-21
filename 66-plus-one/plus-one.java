class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        
        // Traverse from right to left (least significant digit to most significant)
        for (int i = n - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits; // No carry remains, done early
            }
            // If the digit is 9, it becomes 0 and carry continues
            digits[i] = 0;
        }
        
        // If all digits were 9 (e.g., [9, 9, 9] -> [0, 0, 0]),
        // we need an extra leading 1: [1, 0, 0, 0]
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}