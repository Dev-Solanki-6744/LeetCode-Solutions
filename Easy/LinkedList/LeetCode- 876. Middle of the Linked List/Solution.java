/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode middleNode(ListNode head) {
        // Initialize two pointers: slow and fast, both starting at the head of the list
        ListNode slow = head;
        ListNode fast = head;

        /*
         * Move 'fast' two steps and 'slow' one step at a time.
         * - When 'fast' reaches the end of the list:
         *      - If the list has an odd number of nodes, 'fast' will point to the last node.
         *      - If the list has an even number of nodes, 'fast' will become null.
         * In both cases, 'slow' will be pointing at the middle node.
         */
        while (fast != null && fast.next != null) {
            slow = slow.next;         // move slow one step
            fast = fast.next.next;    // move fast two steps
        }

        // When the loop ends, 'slow' will be at the middle node
        return slow;
    }
}
