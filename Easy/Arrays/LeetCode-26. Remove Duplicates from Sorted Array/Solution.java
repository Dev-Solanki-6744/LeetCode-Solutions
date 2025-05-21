// LeetCode Problem 26: Remove Duplicates from Sorted Array
// Link: https://leetcode.com/problems/remove-duplicates-from-sorted-array/

class Solution {
    public int removeDuplicates(int[] nums) {
        // Pointer i keeps track of the position to place the next unique element
        int i = 0;

        // Start from the second element and iterate through the array
        for (int j = 1; j < nums.length; j++) {
            // If the current element is different from the last unique element
            if (nums[i] != nums[j]) {
                // Move the next unique element to the position i+1
                nums[i + 1] = nums[j];
                i++; // Increment i as we've added a unique element
            }
        }

        // Return the length of the new array with unique elements
        return i + 1;
    }
}
