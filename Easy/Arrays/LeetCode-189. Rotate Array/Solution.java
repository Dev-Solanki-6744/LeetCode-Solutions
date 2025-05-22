// LeetCode 189: Rotate Array
// Problem: Rotate the array to the right by k steps, where k is non-negative.

class Solution {
    public void rotate(int[] nums, int k) {
        // Handle cases where k is greater than the array length
        k = k % nums.length;

        // If k is 0, no rotation is needed
        if (k == 0) return;

        // Create a new array to store rotated result
        int[] rotated = new int[nums.length];

        // Copy the last k elements to the beginning of the rotated array
        for (int i = 0; i < k; i++) {
            rotated[i] = nums[nums.length - k + i];
        }

        // Copy the remaining elements to the rotated array
        for (int i = k; i < nums.length; i++) {
            rotated[i] = nums[i - k];
        }

        // Copy the rotated array back to the original array
        for (int i = 0; i < nums.length; i++) {
            nums[i] = rotated[i];
        }
    }
}
