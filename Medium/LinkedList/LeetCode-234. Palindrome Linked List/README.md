# 🔄 LeetCode 234 – Palindrome Linked List

This solution checks if a singly linked list is a palindrome using an **optimal approach** that modifies the list temporarily, compares both halves, and restores it to the original form.

---

## ✅ Algorithm Used

### 1. **Fast and Slow Pointers**
To find the **middle** of the linked list in one pass.

### 2. **Reversing the Second Half**
Reverse the second half **in-place** to compare values from both ends.

### 3. **Comparison**
Check values from head and from the end simultaneously.

### 4. **Restore Original Structure**
Reverse the second half again to maintain the integrity of the original input list.

---

## 🧠 Intuition

A palindrome is a sequence that reads the same forward and backward.  
To validate a linked list:
- We don’t want to use extra space (like a stack or array),
- So we reverse the second half **in-place** and compare it with the first half.

---

## 📦 Code (Java)

```java
public class Solution {

    // Helper function to reverse a linked list
    private ListNode reverse(ListNode head) {
        ListNode tmp = head;
        ListNode prev = null;
        ListNode front = null;

        while (tmp != null) {
            front = tmp.next;     // Save next node
            tmp.next = prev;      // Reverse link
            prev = tmp;           // Move prev forward
            tmp = front;          // Move tmp forward
        }

        return prev; // New head of reversed list
    }

    public boolean isPalindrome(ListNode head) {
        // Edge case: 0 or 1 node
        if (head == null || head.next == null) return true;

        // Step 1: Find middle using fast and slow pointers
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        ListNode newHead = reverse(slow.next);

        // Step 3: Compare both halves
        ListNode first = head;
        ListNode second = newHead;

        while (second != null) {
            if (first.val != second.val) {
                reverse(newHead); // Restore original list before returning
                return false;
            }
            first = first.next;
            second = second.next;
        }

        // Step 4: Restore the original structure
        reverse(newHead);

        return true;
    }
}
```

---

## ⏱️ Time & Space Complexity

| Metric           | Value     |
|------------------|-----------|
| Time Complexity  | O(n)      |
| Space Complexity | O(1) ✅   |

> The list is modified in place and restored back, maintaining O(1) space.

---

## 🧪 Example

```
Input:  [1, 2, 2, 1]
Output: true

Input:  [1, 2]
Output: false
```

---

## 📌 Notes

- Always reverse the second half **back to original** to avoid side effects.
- This is an **interview-friendly** and **optimal** solution.
- Avoids using any extra data structures like stack or array.

---

## 🔗 Related Problems

- [LeetCode 206 – Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/)
- [LeetCode 876 – Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/)
- [LeetCode 141 – Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)

---

⭐ If this helped, please consider ⭐️ starring the repo!
