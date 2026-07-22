class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        // Pointer 'k' tracks the index for inserting the next unique element
        int k = 1;

        for (int i = 1; i < nums.length; i++) {
            // Compare current element with the last known unique element
            if (nums[i] != nums[k - 1]) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}