
## Approach

- Count the number of "order breaks" where `nums[i] > nums[i+1]`.
- Also check the last element with the first element to handle rotation.
- If total breaks are `0` or `1`, the array is sorted and rotated.
- Otherwise, it is not.

This solution runs in `O(n)` time and `O(1)` space.

## Code

See [`Solution.java`](Solution.java) for the implementation.

---

## Author

Dev Solanki 
GitHub: [https://github.com/Dev-Solanki-6744]  
