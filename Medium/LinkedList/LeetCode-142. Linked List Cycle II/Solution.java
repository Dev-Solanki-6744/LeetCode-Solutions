/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    public ListNode detectCycle(ListNode head) {
        // Step 1: Initialize two pointers
        ListNode slow = head;
        ListNode fast = head;

        // Step 2: Use Floyd's Cycle Detection algorithm to check if a cycle exists
        //condition inside while loop are bcoz of 2 case - odd list and even list 
        //if odd-fast will point to last index so fast.next jab tak nall ni hojata
        //if even- fast will point to null so jatak fast null ni hojata 
        while (fast != null && fast.next != null) {
            slow = slow.next;           // Move slow pointer by 1
            fast = fast.next.next;      // Move fast pointer by 2

            // If slow and fast meet, a cycle is detected
            if (slow == fast) {
                // Step 3: Reset one pointer to the start of the list
                slow = head;

                // Step 4: Move both pointers one step at a time
                // They will meet at the starting node of the cycle
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }

                // Return the node where both pointers meet (start of cycle)
                return slow;
            }
        }

        // If fast reached the end, no cycle exists
        return null;
    }
}
