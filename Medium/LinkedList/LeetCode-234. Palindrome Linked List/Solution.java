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

    // Helper function to reverse a linked list
    private ListNode reverse(ListNode head)
    {
        ListNode tmp = head;      // Pointer to traverse the list
        ListNode prev = null;     // Stores the previous node (initially null)
        ListNode front = null;    // Temporarily stores the next node

        // Iterate through the list and reverse the links
        while (tmp != null)
        {
            front = tmp.next;     // Save the next node
            tmp.next = prev;      // Reverse the current node's pointer
            prev = tmp;           // Move prev one step forward
            tmp = front;          // Move tmp one step forward
        }

        // At the end, prev will be the new head of the reversed list
        return prev;
    }

    public boolean isPalindrome(ListNode head) {
        // Edge case: empty list or a single node is always a palindrome
        if (head == null || head.next == null) return true;

        // Step 1: Use fast and slow pointers to find the middle of the list
        ListNode slow = head;
        ListNode fast = head;

        // Move fast by 2 steps and slow by 1 step until fast reaches end
        //*** Here for -even- fast should go till second last element 
        //for odd it will go to last element as usual 
        while (fast.next != null && fast.next.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list starting from slow.next
        ListNode newHead = reverse(slow.next);

        // Step 3: Compare the first half and the reversed second half
        ListNode first = head;
        ListNode second = newHead;

        while (second != null)
        {
            if (first.val != second.val)
            {
                // If values mismatch, not a palindrome
                // Imp for interview - reverse the second half again to restore original list
                reverse(newHead);
                return false;
            }
            // Move both pointers forward
            first = first.next;
            second = second.next;
        }

        // Restore the original list structure
        reverse(newHead);

        // All values matched, so it's a palindrome
        return true;
    }
}
