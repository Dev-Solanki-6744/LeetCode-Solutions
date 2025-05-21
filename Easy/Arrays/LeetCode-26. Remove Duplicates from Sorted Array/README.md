# 26. Remove Duplicates from Sorted Array

## 🔗 Problem Link
[LeetCode #26](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)

---

## ✅ Problem Statement

Given an integer array `nums` sorted in **non-decreasing order**, remove the duplicates **in-place** such that each unique element appears only once. The relative order of the elements should be kept the same.

Return the number of unique elements in `nums`.

You **must** do this by modifying the input array in-place with `O(1)` extra memory.

---

## 💡 Approach

- Use two pointers:
  - `i`: Points to the last unique element in the result.
  - `j`: Scans through the array to find new unique elements.
- If `nums[i] != nums[j]`, then `nums[j]` is a new unique value.
  - Place it at `nums[i + 1]` and move `i` forward.
- At the end, return `i + 1` as the count of unique elements.

---

## 🧠 Complexity

- **Time Complexity:** `O(n)` – Single pass through the array.
- **Space Complexity:** `O(1)` – No extra space used, in-place modification.

---

## 📌 Example

```java
Input: nums = [1,1,2]
Output: 2
Explanation: The first two elements are [1,2]. The rest of the elements are not important.

👨‍💻 Author
Dev Solanki
GitHub: Dev-Solanki-6744