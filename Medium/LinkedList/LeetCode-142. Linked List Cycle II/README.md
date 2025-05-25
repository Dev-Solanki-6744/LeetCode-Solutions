# 🔁 LeetCode 142 – Linked List Cycle II

This repository contains two Java solutions to find the **starting node of the cycle** in a singly linked list:

1. 🐢 Brute Force using a `HashSet`
2. 🏎️ Optimal Floyd's Cycle Detection Algorithm (Tortoise and Hare, Phase 2)

---

## 📘 Problem Statement

Given a **linked list**, return the **node where the cycle begins**.  
If there is **no cycle**, return `null`.

You must **not modify the list**.

---

## 🧪 Example

```
Input: head = [3,2,0,-4], pos = 1  
Output: Node at index 1 (with value 2)
Explanation: The tail connects to the second node
```

---

## 🚨 Method 1: Brute Force Using HashSet

### ✅ Approach

We use a `HashSet` to keep track of visited nodes.  
While traversing the list:
- If a node is already in the set, we've found the **start of the cycle**.
- Otherwise, we continue traversing.

### 🧠 Intuition

Think of this like visiting cities. If you ever visit the same city twice, that’s where your journey started looping.

### 📦 Code

```java
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // HashSet to track visited nodes
        HashSet<ListNode> map = new HashSet<>();

        ListNode tmp = head;

        while (tmp != null) {
            if (map.contains(tmp)) return tmp; // already visited → cycle starts here
            map.add(tmp);                      // mark as visited
            tmp = tmp.next;
        }

        return null; // No cycle
    }
}
```

### ⏱️ Time & Space Complexity

| Metric           | Value    |
|------------------|----------|
| Time Complexity  | O(n)     |
| Space Complexity | O(n)     |

---

## ⚡ Method 2: Optimal Floyd’s Cycle Detection (Phase 2)

### ✅ Approach

Use the **Hare and Tortoise** method in two phases:

1. **Phase 1**: Detect whether a cycle exists by moving two pointers (`slow`, `fast`).
   - If they meet → a cycle exists.
2. **Phase 2**: 
   - Move one pointer to `head` and keep the other at meeting point.
   - Move both one step at a time.
   - The point where they meet is the **start of the cycle**.

### 🧠 Why It Works

Let:
- `x` = distance from `head` to start of cycle
- `y` = distance from start of cycle to meeting point
- `z` = remaining cycle length to get back to start

Since fast moves 2 steps and slow 1 step:
```
2(x + y) = x + y + z + y  → 2(x + y) = x + 2y + z
→ x = z
```

So moving one pointer from head and one from meeting point will both reach the cycle start after `x` steps.

### 📦 Code

```java
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Phase 1: Detect meeting point if a cycle exists
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Phase 2: Find the start of the cycle
                ListNode start = head;
                while (start != slow) {
                    start = start.next;
                    slow = slow.next;
                }
                return start; // Start of the loop
            }
        }

        return null; // No cycle
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

| Method         | Time | Space | Technique                        |
|----------------|------|-------|----------------------------------|
| Brute Force    | O(n) | O(n)  | HashSet to detect duplicates     |
| Optimal        | O(n) | O(1)  | Floyd’s Cycle Detection (2-phase)|

---

## 📎 Related LeetCode Problem

- 🔗 [LeetCode #142 – Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/)

---

⭐️ If this helped, don’t forget to star the repo and follow for more clean, commented DSA solutions!
