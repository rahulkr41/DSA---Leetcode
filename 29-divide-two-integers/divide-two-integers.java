class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow edge case: Integer.MIN_VALUE / -1 = 2^31 (exceeds Integer.MAX_VALUE)
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Handle case where dividend and divisor are equal
        if (dividend == divisor) {
            return 1;
        }

        // Determine the sign of the result
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert both numbers to negative values to avoid overflow with Math.abs(Integer.MIN_VALUE)
        int nDividend = dividend < 0 ? dividend : -dividend;
        int nDivisor = divisor < 0 ? divisor : -divisor;

        int quotient = 0;

        // Since both numbers are negative, comparison logic is reversed:
        // nDividend <= nDivisor means |dividend| >= |divisor|
        while (nDividend <= nDivisor) {
            int tempDivisor = nDivisor;
            int multiple = 1;

            // Exponentially scale up tempDivisor using bit shifts (doubling each step)
            // Prevent integer underflow during shifting
            while (tempDivisor >= (Integer.MIN_VALUE >> 1) && nDividend <= (tempDivisor << 1)) {
                tempDivisor <<= 1;
                multiple <<= 1;
            }

            // Subtract the chunk and add to the quotient
            nDividend -= tempDivisor;
            quotient += multiple;
        }

        return negative ? -quotient : quotient;
    }
}