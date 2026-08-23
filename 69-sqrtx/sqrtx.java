class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) {
            return x;
        }

        int left = 1;
        int right = x;
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Use division (mid <= x / mid) to prevent 32-bit integer overflow
            if (mid <= x / mid) {
                ans = mid;        // mid is a valid floor candidate
                left = mid + 1;   // try finding a larger square root
            } else {
                right = mid - 1;  // mid * mid > x, search left half
            }
        }

        return ans;
    }
}