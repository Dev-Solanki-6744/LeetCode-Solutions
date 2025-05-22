
---

## 🚀 Solution Idea (Super Simple):

We want to rotate the array to the **right** `k` times.

That means:
- The **last `k` elements** should come to the **front**
- The **first `n-k` elements** should go to the **back**

### 🔧 Steps:

1. Create a new array of the same size.
2. Copy the **last `k` elements** to the start of the new array.
3. Copy the **remaining elements** after that.
4. Copy the rotated array back to the original array.

---

## ✅ Code Explanation:

```java
k = k % nums.length; // Make sure k is not greater than array size

// Step 1: Copy last k elements to the start
for (int i = 0; i < k; i++) {
    rotated[i] = nums[nums.length - k + i];
}

// Step 2: Copy the first (n-k) elements to the rest of the array
for (int i = k; i < nums.length; i++) {
    rotated[i] = nums[i - k];
}

// Step 3: Overwrite the original array
