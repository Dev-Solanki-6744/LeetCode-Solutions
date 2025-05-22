
---

## 💡 Intuition:

Since we **don't have access to the previous node**, we can't just unlink the current node.  
So we take a clever approach:

1. **Copy** the value of the **next node** into the **current node**.
2. Then **skip** over the next node.

---

## ✅ Steps in Code:

```java
node.val = node.next.val;       // Step 1: Copy next node's value
node.next = node.next.next;     // Step 2: Skip the next node
