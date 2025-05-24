# 🧠 Middle of the Linked List - LeetCode Problem 876

This repository contains two simple Java solutions (Brute Force and Optimal) for LeetCode Problem 876: **Middle of the Linked List**.

## 🧩 Problem Statement

Given the head of a singly linked list, return the **middle node** of the list.

If there are two middle nodes (even-length list), return the **second middle** node.

---

## 🛠️ Approaches

### 1. 🔁 Brute Force Approach

#### 🧪 Steps:
1. **Count all nodes** in the linked list.
2. Calculate the middle position: `middle = count / 2`.
3. **Traverse the list again** up to the middle index.
4. Return the node at the middle position.

#### ⏱️ Complexity:
- Time: O(n) + O(n) = O(n)
- Space: O(1)

#### ✅ Pros:
- Very simple and easy to understand.

#### ❌ Cons:
- Requires two full traversals of the list.

---

### 2. ⚡ Optimal Approach (Two Pointer Technique)

#### 🧪 Steps:
1. Use two pointers: `slow` and `fast`.
2. Move `slow` by 1 node and `fast` by 2 nodes in each step.
3. When `fast` reaches the end, `slow` will be at the middle.

#### ⏱️ Complexity:
- Time: O(n)
- Space: O(1)

#### ✅ Pros:
- Only one pass through the list.
- More efficient for large lists.

---

## 📄 Java Code

### 🔁 Brute Force Solution

```java
class Solution {
    public ListNode middleNode(ListNode head) {
        // Step 1: Count total number of nodes
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }

        // Step 2: Calculate the middle index
        int middle = count / 2;

        // Step 3: Traverse again to the middle node
        temp = head;
        for (int i = 0; i < middle; i++) {
            temp = temp.next;
        }

        // Step 4: Return the middle node
        return temp;
    }
}

👨‍💻 Author
Dev Solanki
GitHub: Dev-Solanki-6744
