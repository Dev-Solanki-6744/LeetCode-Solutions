/**
 * LeetCode 1752 - Check if Array Is Sorted and Rotated
 */
class Solution {
    /**
     * Checks if the array is sorted in non-decreasing order and then rotated.
     * 
     * @param nums The input integer array
     * @return true if the array is sorted and rotated, false otherwise
     */
    public boolean check(int[] nums) {
        int countBreaks = 0; // Counts how many times the order breaks

        // Iterate through the array to count how many times nums[i] > nums[i+1]
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                countBreaks++;
            }
        }

        // Check the last and first elements to handle rotation case
        if (nums[nums.length - 1] > nums[0]) {
            countBreaks++;
        }

        // If order breaks less than or equal to 1, it's sorted and rotated
        return countBreaks <= 1;
    }
}
