# 🔄 Detect Cycle in a Singly Linked List (Java)

This repository contains two methods to detect if a singly linked list contains a **cycle (loop)**:

1. 🐢 Brute Force using a HashMap  
2. 🏎️ Optimal Floyd’s Cycle Detection Algorithm (Tortoise and Hare)

---

## 📘 Problem Statement

Given the `head` of a singly linked list, determine if the list has a **cycle**.

A cycle exists if any node in the list points back to a previous node instead of `null`.

---

## 🧪 Example

```
Input: head = [3,2,0,-4], pos = 1  
Explanation: The tail connects to the second node (index 1)

Output: true
```

---

## 🚨 Method 1: Brute Force using HashMap

### ✅ Approach

We use a **HashMap** (or a HashSet) to store all visited nodes.  
If we ever visit a node that’s already in the map, a cycle exists.

### 🧠 Intuition

This is like marking each node you walk on — if you step on a previously marked node, you're in a loop.

### 📦 Code

```java
public class Solution {
    public boolean hasCycle(ListNode head) {
        // HashMap to track visited nodes
        HashMap<ListNode, Integer> map = new HashMap<>();
        ListNode current = head;

        while (current != null) {
            // If current is already seen, cycle exists
            if (map.containsKey(current)) {
                return true;
            }

            // Mark node as visited
            map.put(current, 1);

            current = current.next;
        }

        // No cycle found
        return false;
    }
}
```

### ⏱️ Time & Space Complexity

| Metric           | Value    |
|------------------|----------|
| Time Complexity  | O(n)     |
| Space Complexity | O(n)     |

---

## 🏁 Method 2: Optimal (Floyd’s Tortoise & Hare Algorithm)

### ✅ Approach

We use **two pointers**, `slow` and `fast`:
- `slow` moves one step at a time.
- `fast` moves two steps at a time.

If there is a cycle, the two will eventually **meet** inside the loop.  
If there is no cycle, `fast` will reach the end (`null`).

### 🧠 Intuition

Think of a circular track:
- A faster runner will eventually lap the slower runner if they’re both running on the same loop.

### 📦 Code

```java
public class Solution {
    public boolean hasCycle(ListNode head) {
        // Hare and Tortoise approach
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;         // move 1 step
            fast = fast.next.next;    // move 2 steps

            if (fast == slow) return true; // collision → cycle detected
        }

        return false; // reached end → no cycle
    }
}
```

---

### ⏱️ Time & Space Complexity

| Metric           | Value    |
|------------------|----------|
| Time Complexity  | O(n)     |
| Space Complexity | O(1)     |

---

## 🧮 Summary

| Method         | Time | Space | Technique              |
|----------------|------|-------|------------------------|
| Brute Force    | O(n) | O(n)  | HashMap / HashSet      |
| Optimal        | O(n) | O(1)  | Floyd's Cycle Detection|

---

## 📎 Related LeetCode Problem

- 🔗 [LeetCode #141 – Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)

---

⭐️ **If this helped you, feel free to star the repo and share it with others!**
