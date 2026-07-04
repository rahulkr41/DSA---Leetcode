class Solution {
    public String convert(String s, int numRows) {
        // Edge case: if there's only 1 row or the string is shorter than the rows
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        // Initialize a StringBuilder for each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currentRow = 0;
        boolean goingDown = false;

        // Iterate through the characters in the string
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);

            // Turn around if we hit the top or bottom row
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }

            // Move up or down
            currentRow += goingDown ? 1 : -1;
        }

        // Combine all rows into a single string
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}