class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];

        // Base case: An empty string matches an empty pattern
        dp[0][0] = true;

        // Base case: Deals with patterns like "a*", "a*b*", ".*" matching an empty string
        for (int j = 1; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sChar = s.charAt(i - 1);
                char pChar = p.charAt(j - 1);

                // If characters match, or the pattern has a '.', carry over the diagonal value
                if (pChar == '.' || pChar == sChar) {
                    dp[i][j] = dp[i - 1][j - 1];
                } 
                // If the pattern has a '*', we have two scenarios
                else if (pChar == '*') {
                    // 1. Zero occurrences of the preceding character (ignore the 'X*')
                    dp[i][j] = dp[i][j - 2];

                    // 2. One or more occurrences (if the preceding character matches sChar or is '.')
                    char prevPChar = p.charAt(j - 2);
                    if (prevPChar == '.' || prevPChar == sChar) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }

        // The result is whether the entire string matches the entire pattern
        return dp[m][n];
    }
}