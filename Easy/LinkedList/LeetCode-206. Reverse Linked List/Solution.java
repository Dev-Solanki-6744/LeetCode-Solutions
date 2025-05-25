/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        // Optimal in-place solution to reverse a singly linked list

        ListNode tmp = head;     // tmp will traverse through the list (current node)
        ListNode prev = null;    // prev will hold the previous node (initially null)
        ListNode front = null;   // front temporarily stores the next node

        // Iterate through the list
        while (tmp != null) {
            front = tmp.next;     // Save the next node before breaking the link
            tmp.next = prev;      // Reverse the current node's pointer
            prev = tmp;           // Move prev to current node
            tmp = front;          // Move tmp to the next node (original next)
        }

        // At the end, prev points to the new head of the reversed list
        return prev;
    }
}
