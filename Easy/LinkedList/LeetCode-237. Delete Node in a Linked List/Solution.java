// LeetCode 237: Delete Node in a Linked List

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public void deleteNode(ListNode node) {
        // We are given direct access to the node to delete, NOT the head of the list.

        // Copy the value from the next node into the current node
        node.val = node.next.val;

        // Skip the next node, effectively deleting it from the list
        node.next = node.next.next;
    }
}
