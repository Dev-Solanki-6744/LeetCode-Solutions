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
//same method to find middle element in list 
public class Solution {
    
    public boolean hasCycle(ListNode head) {
        //optimal solution- Hare Tortoise method
        ListNode slow = head ;
        ListNode fast = head ;

        //for odd fast  will point to last node and slow to middle 
        //for even fast  will point to null and slow to second middle 
        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;//move slow one step
            fast=fast.next.next;//move fast 2 steps
            if(fast==slow)return true; //if the collapse together at somepoint means loop exists 
        }
        return false ;//if it will be a linear list we return false 
    }
}
