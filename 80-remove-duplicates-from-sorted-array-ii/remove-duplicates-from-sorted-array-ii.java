class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int k = 2; // Pointer for the position of the next valid element
        for (int i = 2; i < nums.length; i++) {
            // If the current element is different from the element at k - 2,
            // it can appear at most twice in the prefix array.
            if (nums[i] != nums[k - 2]) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}