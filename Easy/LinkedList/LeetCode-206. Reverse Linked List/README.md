# 🔁 Reverse a Singly Linked List (Java)

This repository contains a Java method to **reverse a singly linked list** in-place using an **iterative approach**.

---

## ✅ Problem Statement

Given the head of a singly linked list, reverse the list and return the new head.

### 🧾 Example:

```
Input:  1 -> 2 -> 3 -> 4 -> 5 -> null  
Output: 5 -> 4 -> 3 -> 2 -> 1 -> null
```

---

## 🧠 Intuition

To reverse a singly linked list, we need to make each node point to its previous node instead of its next.

But if we directly reverse the pointer, we lose track of the rest of the list.  
So, we need to carefully manage **three pointers**:

| Variable | Role |
|----------|------|
| `tmp`    | Current node we're processing |
| `front`  | The next node (used to not lose the list) |
| `prev`   | The previous node (where we want `tmp.next` to point) |

---

## 🧩 Step-by-Step Code Walkthrough

Here’s the method:

```java
public ListNode reverseList(ListNode head) {
    ListNode tmp = head;     // Start with the head of the list
    ListNode prev = null;    // Initially, there is no previous node
    ListNode front = null;   // Will be used to store tmp.next

    // Loop until we reach the end of the list
    while (tmp != null) {
        front = tmp.next;     // Step 1: Store the next node
        tmp.next = prev;      // Step 2: Reverse the pointer
        prev = tmp;           // Step 3: Move prev one step forward
        tmp = front;          // Step 4: Move tmp to the saved next node
    }

    // When loop ends, prev will be the new head of the reversed list
    return prev;
}
```

---

## 🔍 How it Works (Example)

### Original List:
```
tmp → 1 → 2 → 3 → null
prev = null
```

---

### 🔁 Iteration 1:
- `front = 2`
- `tmp.next = prev` → 1 → null
- `prev = 1`, `tmp = 2`

Now the list looks like:
```
1 → null
↑
prev

2 → 3 → null
↑
tmp
```

---

### 🔁 Iteration 2:
- `front = 3`
- `tmp.next = prev` → 2 → 1 → null
- `prev = 2`, `tmp = 3`

---

### 🔁 Iteration 3:
- `front = null`
- `tmp.next = prev` → 3 → 2 → 1 → null
- `prev = 3`, `tmp = null`

Done! `prev` is the new head.

---

## 🧮 Time & Space Complexity

| Metric           | Value     |
|------------------|-----------|
| Time Complexity  | O(n)      |
| Space Complexity | O(1)      |

- `n` = number of nodes
- No extra memory used (in-place)

---

## 📚 Summary

✅ **Efficient:** Uses no extra space  
✅ **Clean:** Just three pointers  
✅ **Safe:** Doesn’t lose access to any node

---

## 🧪 Want to Test?

You can use this in any linked list problem like checking for palindromes, adding numbers, etc.

---

## 📎 Related Interview Questions

- Reverse Linked List – [LeetCode #206](https://leetcode.com/problems/reverse-linked-list/)
- Palindrome Linked List – [LeetCode #234](https://leetcode.com/problems/palindrome-linked-list/)

---

⭐️ **If you found this helpful, give it a star and follow for more clean code!**
